package com.infore.platform.core.mail.javamail;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * SMTP SSL方式发送邮件
 * 
 */
public class SMTPSSLClient implements ISMTPClient {
	private static Logger logger = LoggerFactory.getLogger(SMTPSSLClient.class);

	@Override
	public boolean send(final String username, final String password,
			String server, String from, List<String> tos, List<String> ccs,
			List<String> bccs, String subject, String text,
			List<String> fileList, Boolean validateCertificate) {

		Properties props = new Properties();
		props.put("mail.smtp.host", server);
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "false");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));

			for (String to : tos) {
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
			}
			for (String cc : ccs) {
				message.addRecipient(Message.RecipientType.CC,
						new InternetAddress(cc));
			}
			for (String bcc : bccs) {
				message.addRecipient(Message.RecipientType.BCC,
						new InternetAddress(bcc));
			}

			message.setSubject(subject);

			if (fileList == null) {
				message.setText(text, "utf-8");
			} else {
				// create and fill the first message part
				MimeBodyPart body = new MimeBodyPart();
				body.setText(text, "utf-8");
				// create the Multipart and add its parts to it
				Multipart mp = new MimeMultipart();
				mp.addBodyPart(body);
				
				for (String filename : fileList) {
					// create the second message part
					MimeBodyPart attachment = new MimeBodyPart();
					String attachementName = "";

					URL url;
					try {
						URI uri = new URI(filename);
						String asciiUrl = uri.toASCIIString();
						url = new URL(asciiUrl);
						URLDataSource dataSource = new URLDataSource(url);
						DataHandler dataHandler = new DataHandler(dataSource);
						attachment.setDataHandler(dataHandler);
						int index = asciiUrl.lastIndexOf("/");
						attachementName = filename.substring(index + 1);
					} catch (MalformedURLException | URISyntaxException e) {
						// attach the file to the message
						FileDataSource fds = new FileDataSource(filename);
						attachment.setDataHandler(new DataHandler(fds));
						attachementName = fds.getName();
					}

					try {
						attachment.setFileName((MimeUtility.encodeWord(attachementName)));
						mp.addBodyPart(attachment);

						// add the Multipart to the message
						message.setContent(mp);
					} catch (UnsupportedEncodingException e) {
						continue;
					}
				}

				// add the Multipart to the message
				message.setContent(mp);
			}

			Transport.send(message);

		} catch (MessagingException e) {
			logger.error(e.getMessage(), e);
			return false;
		}

		return true;
	}
}
