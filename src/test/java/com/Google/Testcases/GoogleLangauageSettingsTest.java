package com.Google.Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import google.GenericUtility.BaseClass;
import google.ObjectRepository.HomePage;
import google.ObjectRepository.LanguageSettings;

public class GoogleLangauageSettingsTest extends BaseClass{
	@Test
	public void setTest() throws IOException {
		//	step 1: open the google homepage
		HomePage page=new HomePage(driver);
		//step 2:	click on settings link
		LanguageSettings lang=new LanguageSettings(driver);
		lang.getSettings().click();
		//	step 3: click on the search settings option
		lang.getSearchsettings().click();
		//	step 4: validate the searchsettings page is loaded
		String Tittle=driver.getTitle();

		System.out.println(Tittle);
		String ActualTitle=pUtil.readDataFromPropertyFile("searchsettings");
		Assert.assertEquals(Tittle,ActualTitle );
		System.out.println("searchsettings page loaded successfully");
		//	step 5:	click on languages
		lang.getLanguages().click();
		lang.getPreferredlang().click();
		lang.getSavebtn().click();
		wUtil.acceptAlert(driver);
		lang.getCurrentText();


	}
}