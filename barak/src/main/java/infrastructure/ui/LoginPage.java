package infrastructure.ui;

import static infrastructure.ui.CloudinarySelenide.clickOn;

import com.codeborne.selenide.Selenide;

public class LoginPage {
	
	private static final String EMAIL  = "felix+barak_shnaider@cloudinary.com";
	private static final String PASSWORD  = "1H2d8g&HXU3*";
	
	public LoginPage() {
	}
	
	public static void setUsername(String username){
		Selenide.$x("//input[@id='user_session_email']").sendKeys(username);
	}
	
	public static void setPassword(String password){
		Selenide.$x("//input[@id='user_session_password']").sendKeys(password);
	}
	
	public static void login() throws InterruptedException{
		setUsername(EMAIL);
		setPassword(PASSWORD);
		clickOn("sign in");
	}
	
}
