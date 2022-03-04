package infrastructure.ui;

import static infrastructure.ui.CloudinarySelenide.clickOn;

import java.time.Duration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

public class PageObject {
	
	private static final String INPUT_PUBLIC_ID_XPATH  = "//input[@data-test='public-id']";
	private static final String INPUT_FILE_UPLOAD_XPATH  = "//input[@class='cloudinary_fileupload']";
	private static final String INPUT_ITEM_TITLE_XPATH  = "//input[@data-test='item-title']";
	private static final String IMAGE_XPATH  = "//img[contains(@alt, '%s')]";

	public static void setPuclicId(String text){
		Selenide.$x(INPUT_PUBLIC_ID_XPATH).sendKeys(text);
	}
	
	public static void uploadFile(String fileName){
		Selenide.$x(INPUT_FILE_UPLOAD_XPATH).uploadFromClasspath(fileName);
	}
	
	public static String getItemTitle(){
		return Selenide.$x(INPUT_ITEM_TITLE_XPATH).attr("value");
	}
	
	public static void manageImage(String imageId) throws InterruptedException{
		Selenide.$x(String.format(IMAGE_XPATH, imageId)).shouldHave(Condition.enabled, Duration.ofSeconds(5)).contextClick();
		clickOn("Manage");
	}
	
}
