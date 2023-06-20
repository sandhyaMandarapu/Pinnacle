package com.Google.Testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import google.GenericUtility.BaseClass;
import google.ObjectRepository.HomePage;


public class GoogleNavigationsTest extends BaseClass {
	@Test
	public void navTest() throws IOException, InterruptedException  
	{
		//		step 1: open the google homepage
		HomePage page=new HomePage(driver);


		//step 2:click on gmail
		page.getGmail().click();
		page.getSignin().click();

		//	step 3: validate the Gmail page is loaded 
		String Tittle=driver.getTitle();
		System.out.println(Tittle);
		String ActualTitle=pUtil.readDataFromPropertyFile("gmailexpected");
		//		Assert.assertEquals(Tittle,ActualTitle );
		Assert.assertTrue(Tittle.contains(ActualTitle));
		System.out.println("gmail page loaded successfully");


		//		step 4: Navigate back to homepage
		wUtil.navigateback(driver);
		wUtil.navigateback(driver);


		//        Step 4: click on google maps
		page.getIcon().click();
		wUtil.switchToFrame(driver, 1);
		page.maps();
wUtil.waits();
	


		//        step 5: validate the google maps page is loaded
		String title=driver.getTitle();
		System.out.println(title);
		String act=pUtil.readDataFromPropertyFile("mapsexpected");
		//		Assert.assertEquals(title,act);
		Assert.assertTrue(title.contains(act));
		System.out.println("Maps  page loaded successfully");



		//	step 6: Navigate back to google homepage
		wUtil.navigateback(driver);


		//        step 7: click on youtube
		page.getIcon().click();
		wUtil.switchToFrame(driver, 1);
		page.getYoutube().click();
wUtil.waits();
		


		//        step 8: validate the youtube page is loaded
		String youtitle=driver.getTitle();
		System.out.println(youtitle);
		String youact=pUtil.readDataFromPropertyFile("YoutubeExpected");
		//		Assert.assertEquals(youtitle,youact);
		Assert.assertTrue(youtitle.contains(youact));
		System.out.println("youtube  page loaded successfully");


		//		step 9: Navigate back to google homepage
		wUtil.navigateback(driver);
		driver.close();




	}
}
