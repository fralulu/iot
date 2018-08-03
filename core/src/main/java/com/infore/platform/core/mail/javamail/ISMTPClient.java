package com.infore.platform.core.mail.javamail;

import java.util.List;

public interface ISMTPClient {

	boolean send(final String username, final String password,
				 String server, String from, List<String> tos, List<String> ccs,
				 List<String> bccs, String subject, String text,
				 List<String> fileList, Boolean validateCertificate);
}
