package com.qa.util;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class OptionsManager {
	
	//get chrome options
	
	public static ChromeOptions getChromeOptions(){
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized"); //it provides to maximize browser
		//co.addArguments("--headless");
		co.addArguments("--ignore-certificate-errors");
		co.addArguments("--disable-popup-blocking");
		co.addArguments("--incognito"); //private mode
		
		return co;
		
	}
	
	public static FirefoxOptions getFireFoxOptions(){
		
		FirefoxOptions fo = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		fo.setCapability(FirefoxDriver.PROFILE, profile);
		
		return fo;
	}
}
