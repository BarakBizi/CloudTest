package infrastructure.ui;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class CloudinarySelenide {

	public static final String TEXT_XPATH = "//*[text()='%s']";
	public static final String HOME_PAGE_URL = "https://staging.cloudinary.com/users/login";

	public static void click(String xpath) {
		Selenide.$x(xpath).shouldHave(Condition.enabled, Duration.ofSeconds(5)).click();
	}

	public static void clickOn(String text) throws InterruptedException {
		click(String.format(TEXT_XPATH, text));
		Thread.sleep(2000);
	}

	public static void initTest() {
		Configuration.browser = "chrome";
		Configuration.startMaximized = true;
		ChromeOptions options = new ChromeOptions();
		Configuration.browserCapabilities = new DesiredCapabilities();
		Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("screenResolution", "1920x1080x24");
		Configuration.browserCapabilities = capabilities;
		Selenide.open(HOME_PAGE_URL);
	}

}
