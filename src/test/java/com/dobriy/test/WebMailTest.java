package com.dobriy.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class WebMailTest {
  private WebDriver driver;
  private String siteurl;
  private String login;
  private String password;
	
  @Test
  public void LoginTest(){
	  (driver.findElement(By.id("username"))).sendKeys(login);
	  (driver.findElement(By.id("password"))).sendKeys(password);
	  (driver.findElement(By.id("SubmitCreds"))).click();
	  (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[contains(@aria-label,'menu with submenu')]"))).click();
	  WebElement elem = driver.findElement(By.xpath(".//span[contains(text(),'@a1qa.com')]"));
	  assertEquals(elem.getText(), login+"@a1qa.com");
  }
  
  @Parameters({"siteurl", "login","password"})
  @BeforeTest
  public void beforeTest(String siteurl,String login, String password) {
	  this.siteurl = siteurl;
	  this.login = login;
	  this.password = password;
	  driver = new ChromeDriver();;
	  driver.get(this.siteurl);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
