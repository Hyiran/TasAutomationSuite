package com.tas.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.mail.PasswordAuthentication;
import com.tej.utils.*;
public class SMTPAuthenticator extends javax.mail.Authenticator
{
	  private static PropertiesLoader objPropertyLoad = new PropertiesLoader();
 	  public PasswordAuthentication getPasswordAuthentication() 
    {
        try 
        {
			return new PasswordAuthentication(objPropertyLoad.getProperty("Authentication.UserName"), objPropertyLoad.getProperty("Authentication.Password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}