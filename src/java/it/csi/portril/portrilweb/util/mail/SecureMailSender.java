/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util.mail;

//import it.csi.eope.eopelib.dto.mail.Allegato;
//import it.csi.eope.eopelib.dto.mail.Email;

import it.csi.portril.portrilweb.util.LogUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.URLName;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.smtp.SMTPMessage;
import com.sun.mail.smtp.SMTPTransport;

public class SecureMailSender {
	private LogUtil log = new LogUtil(getClass());

	private String server;
	private int port;
	private String username;
	private String password;
	private int timeout;

	private List<DataSource> allegati;

	public SecureMailSender() throws Exception {
		this.configura();
	}

	public SecureMailSender(String server, int port, String username,
			String password) {
		this.server = server;
		this.port = port;
		this.username = username;
		this.password = password;

	}

	private void configura() throws Exception {
		String methodName = "configura";
		log.startMethod(methodName);

		server = "host";
		port = 999;
		username = "";
		password = "";
		timeout = 100000;
		// numTentativi = Config.getIntProp("mail.tentativi");

		allegati = new ArrayList<DataSource>();

		//  da estrapolare
		allegati.add(

		new DataSource() {

			@Override
			public OutputStream getOutputStream() throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			public String getName() {
				return "pippo.zip";
			}

			@Override
			public InputStream getInputStream() throws IOException {
				return new ByteArrayInputStream(new byte[] { 0, 0 });
			}

			@Override
			public String getContentType() {
				return "application/zip";
			}
		}

		);

		log.stopMethod(methodName);

	}

	public void send() throws Exception {
		String methodName = "send";
		log.startMethod(methodName);
		Properties props = new Properties();
		props.putAll(System.getProperties());
		props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.connectiontimeout", timeout + "");
		props.put("mail.smtp.timeout", timeout + "");
		// props.setProperty("mail.mime.charset", "UTF-8");
		Session session = Session.getInstance(props, getAuth());
		session.setDebug(true);
		log.debug(methodName, "[SecureMail] send() TRACE 1 ");
		SMTPMessage msg = null;
		try {
			msg = new SMTPMessage(session);
		} catch (Throwable e) {
			log.debug(methodName, "[SecureMail] send() TRACE 1b ");
			log.error(e.getMessage(), e);
		} finally {
			log.debug(methodName, "[SecureMail] send() TRACE 1c ");
		}
		log.debug(methodName, "[SecureMail] send() TRACE 2 ");
		if(msg != null){
			InternetAddress from = new InternetAddress(username);
			InternetAddress to = new InternetAddress("ciao@pippo.it");
	
			log.debug(methodName, "[SecureMail] send() TRACE 3 ");
	
			msg.setFrom(from);
			msg.setRecipient(Message.RecipientType.TO, to);
	
			if (true) {
				Address[] replyTo = new Address[] { new InternetAddress(
						"reply@pippo.it") };
				msg.setReplyTo(replyTo);
			}
	
			log.debug(methodName, "[SecureMail] send() TRACE 4 ");
	
			InternetAddress[] ccAddresses = new InternetAddress[] { new InternetAddress(
					"cc1@pippo.it") };
	
			msg.setRecipients(Message.RecipientType.CC, ccAddresses);
	
			log.debug(methodName, "[SecureMail] send() TRACE 5 ");
	
			// per inserire nell'header X-proprieta' utili (es. tipo ricevuta)
			msg.setHeader("X-TipoRicevuta", "completa");
			// SMTP specifics
			msg.setAllow8bitMIME(true);
			// Send notification on Failure - no way to set envid in Java yet
			msg.setNotifyOptions(SMTPMessage.NOTIFY_FAILURE);
			// Bounce only header
			msg.setReturnOption(SMTPMessage.RETURN_HDRS);
	
			int msgId = new Random().nextInt(1000);
	
			msg.setSubject("subject");
	
			log.debug(methodName, "[SecureMail] send() TRACE 6 ");
	
	//		if (false) {
	//			msg.setContent(getMultiPart());
	//		} else {
	//			msg.setText("testo mail", "UTF-8");
	//		}
	
			msg.setSentDate(new Date());
	
			log.debug(methodName, "[SecureMail] send() TRACE 7 ");
	
			msg.saveChanges();
			URLName urln = new URLName("smtp", server, port, null, null, null);
			SMTPTransport t = new SMTPTransport(session, urln);
	
			log.debug(methodName, "[SecureMail] send() SMTPTransport.connect ");
			t.connect();
			log.debug(methodName, "[SecureMail] send() SMTPTransport.sendMessage ");
			t.sendMessage(msg, msg.getAllRecipients());
			log.debug(methodName, "[SecureMail] send - OK - msgID=" + msgId);
			t.close();
			log.startMethod(methodName);
		}
	}
/*
	private Multipart getMultiPart() throws MessagingException,UnsupportedEncodingException {
		Multipart mp = new MimeMultipart();
		MimeBodyPart mbp0 = new MimeBodyPart();
		mbp0.setText("testo della mail", "UTF-8");
		mp.addBodyPart(mbp0);
		MimeBodyPart mbp = new MimeBodyPart();
		mbp.setDataHandler(new DataHandler(allegati.get(0)));
		mbp.setFileName(MimeUtility.encodeWord("nomeFile.zip", "Cp1252", null));
		mp.addBodyPart(mbp);
		return mp;
	}
*/
	public Authenticator getAuth() {
		return new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				PasswordAuthentication pa = new PasswordAuthentication(
						username, password);
				return pa;
			}
		};
	}

}
