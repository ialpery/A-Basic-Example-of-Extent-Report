package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class AmazonTest extends TestBaseReport {

    @Test
    public void amazonTest(){

        extentTest = extentReports.createTest("Seaching Java","The user should be able to search and add products to the cart.");
        extentTest.info("Test Started");

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));
        extentTest.pass("Correctly navigated to the Amazon page");


        AmazonPage amazonPages = new AmazonPage();

        amazonPages.searchBox.sendKeys(ConfigReader.getProperty("searchText") + Keys.ENTER);
        extentTest.pass("Java word was typed and searched");

        Assert.assertTrue(amazonPages.resultSearchingText.getText().contains("Java"));
        extentTest.pass("Search results contain 'Java'");

        amazonPages.firstSearchingResult.click();
        extentTest.pass("The first sample was clicked");

        Assert.assertTrue(amazonPages.shareButton.isDisplayed());
        extentTest.pass("Share button is appeared");

        amazonPages.addToCartButton.click();
        extentTest.pass("The sample was added to cart");

        Assert.assertEquals(amazonPages.addedToCartText.getText(), "Added to Cart");
        extentTest.pass("'Added to Cart' text was appeared");

        Driver.closeDriver();
        extentTest.info("Test Completed");

    }

}
