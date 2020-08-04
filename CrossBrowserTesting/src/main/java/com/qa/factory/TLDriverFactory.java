package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TLDriverFactory {
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	//set the driver --used to generate the driver
	//get the driver -- is used to get the same driver
	
	public synchronized static void setTLDriver(String browser){
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			tldriver =ThreadLocal.withInitial(()-> new ChromeDriver(OptionsManager.getChromeOptions()));
			
		
		}else if(browser.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			tldriver = ThreadLocal.withInitial(()-> new FirefoxDriver(OptionsManager.getFireFoxOptions()));
		
		}
	}
	
	public synchronized static WebDriver getTLDriver(){
		return tldriver.get();
	}

}
