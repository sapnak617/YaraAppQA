package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basetest.Basetest;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomePage extends Basetest {
	WebDriver driver=null;
	WebDriverWait wait = null;
	
	//Language selection screen
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='title_select_language_en']")
	AndroidElement languageTextEnglish;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_Select_select_language_en']")
	AndroidElement languageSelectButtonEn;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='title_select_language_hi']")
	AndroidElement languageTextHindi;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_Select_select_language_hi']")
	AndroidElement languageSelectButtonHi;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='title_select_language_ta']")
	AndroidElement languageTextTamil;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_Select_select_language_ta']")
	AndroidElement languageSelectButtonTa;
	
	//Welcome screen
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='rice_leaf_image_welcome_screen']")
	AndroidElement riceLeafWelcomeScreenImage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='welcomeContainer_view']")
	AndroidElement welcomeScreenTextGroup;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_welcome_screen_continue']")
	AndroidElement agreeAndContinueButton;
	
	
	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, 30);
	}
		
	public void selectLanguage() {
		//Select Random language option
		int randomLanguageIndex = getRandomValue(3);
		switch(randomLanguageIndex) {
			case 0:
				log("Language selected: "+languageTextEnglish.getText());
				languageSelectButtonEn.click();
				break;
			case 1:
				log("Language selected: "+languageTextHindi.getText());
				languageSelectButtonHi.click();
				break;
			case 2:
				log("Language selected: "+languageTextTamil.getText());
				languageSelectButtonTa.click();
				break;
		}
		
	}
	
	public void continueOnWelcomeScreen() {
		wait.until(ExpectedConditions.visibilityOf(agreeAndContinueButton));
		log("Click "+agreeAndContinueButton.getText()+" button");
		agreeAndContinueButton.click();
	}
	
}
