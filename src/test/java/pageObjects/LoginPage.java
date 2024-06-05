package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement inputEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement inputLoginPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	public void setEmail(String email) 
	{
		inputEmail.sendKeys(email);
	}
	
	public void setPassword(String loginPwd)
	{
		inputLoginPassword.sendKeys(loginPwd); 
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
}
