package com.infore.platform.core.mail;


import com.infore.platform.core.mail.javamail.*;

import java.util.ArrayList;
import java.util.List;

public class MailDriver{
	//
	private String host;
	private int port;
	private String user;
	private String password;

	//
	public MailDriver() {

	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//
	public void init() throws Exception {
		if (host == null) {
			throw new IllegalArgumentException("host can not be null");
		}
		if (port == 0) {
			throw new IllegalArgumentException("port can not be 0");
		}
		if (user == null) {
			throw new IllegalArgumentException("user can not be null");
		}
		if (password == null) {
			throw new IllegalArgumentException("password can not be null");
		}
	}

	//
	public boolean send(String from, String to, String subject, String content,
			Boolean validateCertificate) {
		List<String> tos = new ArrayList<>();
		tos.add(to);
		return send(from, tos, null, null, subject, content,
				null, validateCertificate);
	}

	/**
	 * 
	 */
	public boolean send(String from, List<String> tos, List<String> ccs,
			List<String> bccs, String subject, String content,
			List<String> fileList, Boolean validateCertificate) {
		ISMTPClient smtpClientSender;
		boolean isSendOk = false;
		switch (port) {
		case SMTPPort.DEFUALT_PORT:
			smtpClientSender = new SMTPClient();
			isSendOk = smtpClientSender.send(user, password, host, from, tos,
					ccs, bccs, subject, content, fileList, validateCertificate);
			break;
		case SMTPPort.SSL_PORT:
			smtpClientSender = new SMTPSSLClient();
			isSendOk = smtpClientSender.send(user, password, host, from, tos,
					ccs, bccs, subject, content, fileList, validateCertificate);
			break;
		case SMTPPort.TLS_PORT:
			smtpClientSender = new SMTPTLSClient();
			isSendOk = smtpClientSender.send(user, password, host, from, tos,
					ccs, bccs, subject, content, fileList, validateCertificate);
			break;
		default:
			break;
		}

		return isSendOk;
	}
}
