package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basetest.Basetest;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LeafColourSelectionPage extends Basetest {
	WebDriver driver=null;
	WebDriverWait wait = null;
	
	// How To Tutorial pages -->
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@content-desc,'header_slide')]")
	AndroidElement tutorialPageTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_skipButton']")
	AndroidElement skipButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_nextButton']")
	AndroidElement nextButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_startSampleButton']")
	AndroidElement startSamplingButton;
	
	//Leaf colour selection
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc,'img_mockLeafColorScreen_')]")
	List<AndroidElement> mockLeafColourIcons;
	
	@AndroidFindBy(xpath="//android.view.ViewGroup[contains(@content-desc,'circledCheck_mockLeafColorScreen')]")
	List<AndroidElement> leafColors;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_btnNextLeaf']")
	AndroidElement nextLeafButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='title_mockLeafColorScreen']")
	AndroidElement leafColourSelectionTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_btnDone']")
	AndroidElement doneButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='txt_almostdone']")
	AndroidElement thankYouText;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='navBarLeftButton_navBar']")
	AndroidElement crossIcon;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='title_alert_cancel_getResults']")
	AndroidElement alertTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnAllow_alert_cancel_getResults']")
	AndroidElement alertYes;
	
	
	public LeafColourSelectionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public AndroidElement getThankYouText() {
		return thankYouText;
	}



	public void navigateThroughHowToTutorial() {
		wait.until(ExpectedConditions.visibilityOf(tutorialPageTitle));
		log("Reached Tutorial Page: "+tutorialPageTitle.getText());
		try {
			while(tutorialPageTitle.isDisplayed()) {
				nextButton.click();
				log("Click Next On Tutorial Page");
				wait.until(ExpectedConditions.visibilityOf(tutorialPageTitle));
			}
		} catch(Exception e) {
			startSamplingButton.click();
			log("Click Start Sampling On Tutorial Page");
			log("Tutorial completed!");
		}
		
	}
	
	public void selectLeavesColours() {
		int numberOfLeafColoursToBeSelected = mockLeafColourIcons.size();
		int randomLeafColour;
		
		int currentSelectionIndex=0;
		while(currentSelectionIndex < numberOfLeafColoursToBeSelected) {
			randomLeafColour = getRandomValue(3);
			leafColors.get(randomLeafColour).click();
			log("Leaf Color selected: "+leafColourSelectionTitle.getText());
			try {
				nextLeafButton.click();
			} catch(Exception e) {
				log("Leaves colour selection Completed!");
				doneButton.click();
				break;
			}
			currentSelectionIndex+=1;
		}
	}
	
	public void closeAfterLeafColourSelections() {
		crossIcon.click();
		wait.until(ExpectedConditions.visibilityOf(alertTitle));
		log("Click YES on Alert popup: "+alertTitle.getText());
		alertYes.click();
	}
	
	

}
