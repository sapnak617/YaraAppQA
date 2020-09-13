package factory;

import org.openqa.selenium.WebDriver;

import actions.PageActions;
import pages.AddCropPage;
import pages.LeafColourSelectionPage;
import pages.WelcomePage;

public class SiteFactory {
	WebDriver driver=null;
	
	public SiteFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	//pages
	public WelcomePage welcomePage() {
		return new WelcomePage(driver);
	}
	
	public AddCropPage addCropPage() {
		return new AddCropPage(driver);
	}
	
	public LeafColourSelectionPage leafColourSelectionPage() {
		return new LeafColourSelectionPage(driver);
	}
	
	//Actions
	public PageActions pageActions() {
		return new PageActions(this);
	}
}
