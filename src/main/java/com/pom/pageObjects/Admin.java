package com.pom.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;


public class Admin {
	WebDriver driver;
	
	public Admin(WebDriver driver)
	{
	this.driver = driver;
	}

	private By adminSection = By.id("menu_admin_viewAdminModule");
	private By manegmetSection = By.id("menu_admin_UserManagement");
	private By systemSection = By.id("menu_admin_viewSystemUsers");

	public void clickAdmin()throws Exception{
	findElement(adminSection).click();
	}
	public void clickUserManagement()throws Exception{
	driver.findElement(manegmetSection).click();
	}
	public void clickUsers()throws Exception{
	driver.findElement(systemSection).click();
	}

	public WebElement findElement(By by) throws Exception
	{



	WebElement element = driver.findElement(by);

	if (driver instanceof JavascriptExecutor)
	{
	((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);

	}
	return element;
	}
	
}