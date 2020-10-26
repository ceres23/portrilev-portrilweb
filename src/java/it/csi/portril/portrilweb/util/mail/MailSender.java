/*
*SPDX-FileCopyrightText: Copyright 2020 | Regione Piemonte
*SPDX-License-Identifier: EUPL-1.2
*/
package it.csi.portril.portrilweb.util.mail;

import it.csi.portril.portrilweb.util.Costanti;
import it.csi.portril.portrilweb.util.LogUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private  LogUtil log = new LogUtil(getClass());
	
	public final static String PROP = "/parametriMail.properties";
	Properties props = new Properties();
	
	String mailSmtp;
	String provider;
			
	public MailSender() {
		String methodName="MailSender";
		InputStream is = this.getClass().getResourceAsStream(PROP);
		try {
			props.load(is);
		 	mailSmtp = props.getProperty("mailSmtp");
		 	provider = props.getProperty("provider");
		} catch (IOException e) {			
			log.error(methodName,"IoException "+ e);
		}	
		finally{
			try {
				is.close();
			} catch (IOException e) {
				log.error(methodName,"IoException fynally "+ e);
			}
		}	
	}

	/**
	 * 
	 * @param mittente
	 * @param oggetto
	 * @param corpoMail
	 * @param IndirizzoMail
	 * @param indirizzoEmailCC
	 * @throws MessagingException
	 */
	public  void inviaMail(String mittente,String oggetto,String corpoMail,String IndirizzoMail, List<String> listaindirizzoEmailCC)throws MessagingException {
		String indirizzoEmailCC ="";
		String separatore ="";
				
//		for(String mail : listaindirizzoEmailCC){
//			indirizzoEmailCC = indirizzoEmailCC + separatore +mail;
//			separatore = Costanti.SEPARATORE.getCostante();
//		}

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < listaindirizzoEmailCC.size(); ++i) {
			String mail =  listaindirizzoEmailCC.get(i);
			buf.append(separatore);
			buf.append(mail);
			separatore = Costanti.SEPARATORE_COMMA.getCostante();
		}
		indirizzoEmailCC = buf.toString();

		inviaMail( mittente, oggetto, corpoMail, IndirizzoMail, indirizzoEmailCC);
	}
	
	/**
	 * 
	 * @param mittente
	 * @param oggetto
	 * @param corpoMail
	 * @param IndirizzoMail
	 * @param indirizzoEmailCC
	 * @throws MessagingException
	 */
	public  void inviaMail(String mittente,String oggetto,String corpoMail,String IndirizzoMail, String indirizzoEmailCC)throws MessagingException {
		String methodName="inviaMail";
		log.startMethod(methodName);

		//eventuale path per allegato
		String pathCv = null;
		String dest   = IndirizzoMail;
		String testo  = corpoMail;

		log.debug(methodName,"mailSmtp --> " + mailSmtp);
		log.debug(methodName,"provider --> " + provider);
		
		log.debug(methodName,"oggetto -->  " + oggetto);
		log.debug(methodName,"testo -->    " + testo);
		
		log.debug(methodName,"mittente --> " + mittente);
		log.debug(methodName,"dest -->    " + dest);
		log.debug(methodName,"cc -->    " + indirizzoEmailCC);
		
		sendMailSend(mailSmtp, provider, dest, mittente,indirizzoEmailCC, oggetto, testo,pathCv);
		log.stopMethod(methodName);
	}
	
	public  void inviaMail(String mittente,String oggetto,String corpoMail,String IndirizzoMail)throws MessagingException {
		String methodName="inviaMail";
		log.startMethod(methodName);

		//eventuale path per allegato
		String pathCv = null;
		String dest   = IndirizzoMail;
		String testo  = corpoMail;

		log.info(methodName,"mailSmtp --> " + mailSmtp);
		log.info(methodName,"provider --> " + provider);
		
		log.info(methodName,"oggetto -->  " + oggetto);
		log.info(methodName,"testo -->    " + testo);
		
		log.info(methodName,"mittente --> " + mittente);
		log.info(methodName,"dest -->    " + dest);
		
		sendMailSend(mailSmtp, provider, dest, mittente,null, oggetto, testo,pathCv);
		log.stopMethod(methodName);
	}
	
	private void sendMailSend(String mailSmtp, String provider, String dest,String mitt,String indirizzoEmailCC, String oggetto, String testo,String pathCv) throws MessagingException {
		String methodName="sendMailSend";
		log.startMethod(methodName);
			Properties props = System.getProperties();
			props.put("mail.smtp.host", mailSmtp);
			props.put(mailSmtp, provider);
			
			Session session = Session.getDefaultInstance(props);
			Message message = new MimeMessage(session);

			InternetAddress from = new InternetAddress(mitt);
			message.setFrom(from);
			
			InternetAddress to[] = InternetAddress.parse(dest);
			message.setRecipients(javax.mail.Message.RecipientType.TO, to);
			
			if(indirizzoEmailCC!=null){
				InternetAddress cc[] = InternetAddress.parse(indirizzoEmailCC);
				message.setRecipients(javax.mail.Message.RecipientType.CC, cc);
			}
			
			message.setSubject(oggetto);
			message.setSentDate(new Date());
			message.setText(testo);	
			/*
			Multipart multipart = new MimeMultipart();
			// crea la parte testuale
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText(testo);
			// crea l'allegato Word
			DataSource source = new FileDataSource(pathCv);
			*/
			log.info(methodName, "prima di transport");
			Transport.send(message);			
			log.stopMethod(methodName);
	}
	
	public static void main(String[] args){
		MailSender ms = new MailSender();
		ms.mailSmtp = "mailfarm.csi.it";
		ms.provider = "mailfarm.csi.it";
		try {
			ms.inviaMail("antonino.benedetto@csi.it","ciao ","prova messaggiodfgdfgdgdgdfg","antonino.benedetto@csi.it", ",antonino.benedetto@csi.it");
			System.out.println("fine invio   ");
		} catch (MessagingException e) {
			System.out.println("errore   " + e);
		}
	}
}

