package com.pom.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.pageObjects.Admin;
import com.pom.pageObjects.LoginPage;

import common.BaseClass;


public class AdminUserTest extends BaseClass {
	BaseClass baseObj = new BaseClass();

	@Test(priority=1)
	public void checkUsers()throws Exception{
		//LoginTest login = new LoginTest();
		LoginPage log = new LoginPage(driver);
		log.setUserName(username);
		log.setPassword(password);
		log.clickSubmit();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		Admin admin = new Admin(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		admin.clickAdmin();
		admin.clickUserManagement();
		admin.clickUsers();
		boolean sysUser = driver.findElement(By.id("systemUser-information")).isDisplayed();
		if(sysUser) {
			Assert.assertTrue(true);
			System.out.println("Users are displayed");
		}
		else {
			Assert.assertTrue(false);
			System.out.println("Users are not displayed");
		}
	}
	
	@Test(priority=2)
	public void checkUserStatus()throws Exception{
		int rowcount = driver.findElements(By.xpath("html/body/div[1]/div[3]/div[2]/div/div/form/div[4]/table/tbody/tr")).size();
		int statuscount=0;
		for(int i=1;i<=rowcount;i++) {
			String status = driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr[" + i +"]/td[5]")).getText();
			
			if(status.equals("Enabled")) {
				statuscount =statuscount +1;
			}
		}
		System.out.println("No.of Employees Enabled:" +statuscount);
	}


}
