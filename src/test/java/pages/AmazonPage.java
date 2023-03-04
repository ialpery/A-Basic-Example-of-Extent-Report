package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {

    public AmazonPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement resultSearchingText;

    @FindBy(xpath = "(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")
    public WebElement firstSearchingResult;

    @FindBy(xpath = "//i[@title='Share']")
    public WebElement shareButton;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
    public WebElement addedToCartText;

}
