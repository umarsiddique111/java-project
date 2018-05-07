package com.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	
	private String email;
	private String msg;
	private String subject;
	
	
	public SendMail(String email,String msg,String subject) {
		super();
		this.email = email;
		this.msg = msg;
		this.subject = subject;
		
	}

	public static boolean sendMail(String email,String message,String subject) {
		System.out.println("Email has been sent to user"+message);
		boolean issent = false;
		issent = new SendMail(email,message,subject).sendSimpleMail();
		return issent;
	}
	
	private boolean sendSimpleMail() {
		
		boolean issent = false;
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getInstance(props, new javax.mail.Authenticator()  {
			protected  PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("umarsiddique498@gmail.com", "raheel123");
			}		
			});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("usiddiqui@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(subject);
			message.setText(msg);
			Transport.send(message);
			issent = true;
			System.out.println("Done");
			
		}catch(MessagingException ex) {
			issent=false;
			throw new RuntimeException(ex);
			
		}return issent;
		
	}
}
