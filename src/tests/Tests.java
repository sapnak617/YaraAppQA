package tests;

import org.testng.annotations.Test;

import basetest.Basetest;

public class Tests extends Basetest{
	
	@Test
	public void AddNewCropAndCompleteColourSelectionToGeneratePlantHealthReport() {
		factory.pageActions()
		.finishOnboarding()
		.addNewCrop("ABC Farm")
		.navigateThroughHowToTutorial()
		.completeLeavesColourSelection()
		.verifyThankYouTextDisplayed()
		.continueAfterLeafColourSelections();
	}
}
