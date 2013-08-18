package com.tas.utils;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.*;

public class SendMail 
{
	  private static PropertiesLoader objPropertyLoad = new PropertiesLoader();
	  public void postMail( String recipients[ ], String subject,
	                            String message , String from) throws MessagingException, IOException,Exception
	  {
	    boolean debug = false;

	     //Set the host smtp address
	     Properties props = new Properties();
	     props.put("mail.smtp.host", objPropertyLoad.getProperty("SMTP.HOST.Name"));
	     props.put("mail.smtp.auth", "true");

	    Authenticator auth = new SMTPAuthenticator();
	    Session session = Session.getDefaultInstance(props, auth);

	    session.setDebug(debug);

	    // create a message
	    Message msg = new MimeMessage(session);

	    // set the from and to address
	    InternetAddress addressFrom = new InternetAddress(from);
	    msg.setFrom(addressFrom);
	    
	    InternetAddress[] addressTo = new InternetAddress[recipients.length];
	    for (int i = 0; i < recipients.length; i++)
	    {
	        addressTo[i] = new InternetAddress(recipients[i]);
	    }
	    msg.setRecipients(Message.RecipientType.TO, addressTo);


	    // Setting the Subject and Content Type
	    msg.setSubject(subject);
	    msg.setContent(message, "text/html");
	    Multipart multipart = attachFile(message);
	    msg.setContent(multipart);
	    Transport.send(msg);
	 }
	  
	@SuppressWarnings("static-access")
	public Multipart attachFile(String sMessage) throws Exception,MessagingException, IOException
	{
		BodyPart messageBodyPart = new MimeBodyPart();
		Multipart multipart = new MimeMultipart();
		PackFolder objpackFolder = new PackFolder();
		objpackFolder.createZipFolder(objPropertyLoad.getProperty("Src.Folder.Name"), objPropertyLoad.getProperty("Dest.FolderName"));
		messageBodyPart.setContent(sMessage, "text/html");
		multipart.addBodyPart(messageBodyPart);
		messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource(objPropertyLoad.getProperty("Dest.FolderName"));
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(objPropertyLoad.getProperty("Set.FileName"));
		multipart.addBodyPart(messageBodyPart);
		
		return multipart;
	}
}
