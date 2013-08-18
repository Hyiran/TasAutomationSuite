package com.tas.utils;

import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;
/**
 * @author venmaum
 *  This class is a utility class that is used to create a session and methods will provide 
 *  functionalities like creating a session,closing a session and sending status of a testtest for a report.
  */
public class Session extends SeleneseTestCase
{
	
	private PropertiesLoader objPropertyLoad = new PropertiesLoader();
	/**
	 * This method is used to set a session with server details and website url
	 * @throws Exception
	 */
	public void setSession() throws Exception 
	{
		SeleniumServer seleniumserver=new SeleniumServer();
		seleniumserver.start();
		setUp("http://localhost:4444", "*iehta");
		for (int second = 0;; second++) {
		     if (second >= 120) fail("timeout");
		     try { if (true)selenium.open(objPropertyLoad.getProperty("Input.Main.URL")); break; } catch (Exception e) {}
		     Thread.sleep(1000);
		}
	}
	/**
	 * This method is used to create a session
	 * @return session
	 */
	public Selenium getSelenium(){
		return selenium;
	}
	/**
	 * This method is used to close already  created session
	 */
	public void closeSession()
	{
		selenium.stop();
		selenium.close();
	}
	/**
	 * This method is used to send the result of teststep in generation of testcase report 
	 * @param bval
	 * @return string
	 */
	
}