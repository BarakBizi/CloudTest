package sanity;

import static infrastructure.ui.CloudinarySelenide.clickOn;
import static infrastructure.ui.CloudinarySelenide.initTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.codeborne.selenide.Selenide;

import infrastructure.ui.LoginPage;
import infrastructure.ui.PageObject;

@TestMethodOrder(OrderAnnotation.class)
class TestCloudImage {

	private static final String FILE_NAME  = "barak.jpeg";
	private static final String PUBLIC_ID  = "public" +  ThreadLocalRandom.current().nextInt(1, 10000);
	
	@BeforeAll
	public static void beforeAllSetup() throws InterruptedException, URISyntaxException, FileNotFoundException {
		initTest();
		LoginPage.login();
	}

	@Test
	void TestPublicId() throws InterruptedException {
		clickOn("Media Library");
		clickOn("Upload");
		Selenide.switchTo().frame(1);
		clickOn("Advanced");
		PageObject.setPuclicId(PUBLIC_ID);
		PageObject.uploadFile(FILE_NAME);
		Selenide.switchTo().parentFrame();
		PageObject.manageImage(PUBLIC_ID);
		assertEquals(PUBLIC_ID, PageObject.getItemTitle());
	}


}
