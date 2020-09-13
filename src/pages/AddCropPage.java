package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basetest.Basetest;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddCropPage extends Basetest {
	WebDriver driver=null;
	WebDriverWait wait = null;
	
	//Add new crop
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='title_nav_bar_add_crop']")
	AndroidElement newCropTitle;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='btnText_add_crop']")
	AndroidElement addCropButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='title_nbNavBar']")
	AndroidElement addCropTitle;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@content-desc='textInput_txtFarmName']")
	AndroidElement nameOfFarmTextField;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='roundedButtonText_rblRiceVarieties']")
	List<AndroidElement> riceType;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='txtDisplayDate_dtSowingdate']")
	AndroidElement sowingDateField;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='img_dtSowingdate']")
	AndroidElement sowingDateFieldCalendarImage;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='roundedButtonText_rblGrowingPeriods']")
	List<AndroidElement> growingPeriod;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='roundedButtonText_rblFarmSizes']")
	List<AndroidElement> farmSize;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='roundedButtonText_nbNavBar']")
	AndroidElement saveButton;
	
	public AddCropPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, 30);
	}
	
	public void navigateToAddNewCropForm() {
		wait.until(ExpectedConditions.visibilityOf(addCropButton));
		log("Click Add Crop button");
		addCropButton.click();
	}
	public void saveCropInformation(String farmName) {
//		Rice types: Non-basmatic, Basmatic, Boro, Direct-seeded
		wait.until(ExpectedConditions.visibilityOf(nameOfFarmTextField));
		nameOfFarmTextField.click();
		nameOfFarmTextField.sendKeys(farmName);
		addCropTitle.click();
		
		// Select random rice type:
		int riceTypeIndexToBeSelected = getRandomValue(3);
		riceType.get(riceTypeIndexToBeSelected).click();
		log("Selected Rice Type: "+riceType.get(riceTypeIndexToBeSelected).getText());
		
		//Select Growing Period
		WebElement growingPeriodSelected = growingPeriod.get(getRandomValue(2));
		growingPeriodSelected.click();
		log("Selected Growing Period: "+growingPeriodSelected.getText());
		
		//Select Farm size
		WebElement farmSizeSelected = farmSize.get(getRandomValue(2));
		farmSizeSelected.click();
		log("Selected Farm Size: "+farmSizeSelected.getText());
		
		//Save the Crop details
		if(saveButton.isEnabled()) {
			log("Click Save button");
			saveButton.click();
		} else {
			log("Save button is not enabled even after filling all details of the new Crop! : "+saveButton.isEnabled());
		}
	}
}
