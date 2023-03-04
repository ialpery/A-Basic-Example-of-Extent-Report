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
        extentTest.info("Correctly navigated to the Amazon page");


        AmazonPage amazonPages = new AmazonPage();

        amazonPages.searchBox.sendKeys(ConfigReader.getProperty("searchText") + Keys.ENTER);
        extentTest.info("Java word was typed and searched");

        Assert.assertTrue(amazonPages.resultSearchingText.getText().contains("Java"));
        extentTest.info("Search results contain 'Java'");


        amazonPages.firstSearchingResult.click();
        extentTest.info("The first sample was clicked");

        Assert.assertTrue(amazonPages.shareButton.isDisplayed());
        extentTest.info("Share button is appeared");

        amazonPages.addToCartButton.click();
        extentTest.info("The sample was added to cart");

        Assert.assertEquals(amazonPages.addedToCartText.getText(), "Added to Cart");
        extentTest.info("'Added to Cart' text was appeared");

        Driver.closeDriver();
        extentTest.pass("Test Completed");

    }

}
