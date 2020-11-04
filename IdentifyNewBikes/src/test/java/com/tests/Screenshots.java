package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	static Properties property;
	
	public static void Screenshot(WebDriver driver) throws IOException {
		
		FileInputStream fs=new FileInputStream(".\\config.properties");
		property = new Properties();
		property.load(fs);
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File f1=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f1, new File(property.getProperty("ScreenShot_location")+timestamp+".jpeg"));
		
	}
	

}