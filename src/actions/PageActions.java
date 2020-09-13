package actions;

import org.testng.Assert;

import basetest.Basetest;
import factory.SiteFactory;

public class PageActions extends Basetest {
	SiteFactory factory;
	
	public PageActions(SiteFactory factory) {
		this.factory=factory;
	}
	
	public PageActions finishOnboarding() {
		factory.welcomePage().selectLanguage();
		factory.welcomePage().continueOnWelcomeScreen();
		return this;
	}
	
	public PageActions addNewCrop(String farmName) {
		factory.addCropPage().navigateToAddNewCropForm();
		factory.addCropPage().saveCropInformation(farmName);
		return this;
	}
	
	public PageActions navigateThroughHowToTutorial() {
		factory.leafColourSelectionPage().navigateThroughHowToTutorial();
		return this;
	}
	
	public PageActions completeLeavesColourSelection() {
		factory.leafColourSelectionPage().selectLeavesColours();
		return this;
	}
	
	public PageActions verifyThankYouTextDisplayed() {
		Assert.assertEquals(factory.leafColourSelectionPage().getThankYouText().isDisplayed(), true, "Thank You text is not displayed!");
		return this;
	}
	
	public PageActions continueAfterLeafColourSelections() {
		factory.leafColourSelectionPage().closeAfterLeafColourSelections();
		return this;
	}

}
