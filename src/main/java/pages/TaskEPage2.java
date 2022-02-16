package pages;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaskEPage2 extends BasePage {
    public TaskEPage2(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;
    @FindBy(xpath = "//a[@class='noo-search']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@name='s']")
    WebElement searchField;

    @FindBy(xpath = "//select[@name='filter_size']")
    WebElement filterSize;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]")  //[1] is the first product
    WebElement firstProduct;

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement chooseColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement chooseSize;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    WebElement linkToCartPage;

    public TaskEPage2 searchItem(String search) {
        searchButton.click();
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public TaskEPage2 filterSize(String size) {
        selectByText(filterSize,size);
        return this;
    }

    public TaskEPage2 chooseFirstProduct() {
        moveToElement(firstProduct);
        firstProduct.click();
        return this;
    }

    public TaskEPage2 selectColor(String color) {
        moveToElement(chooseColor);
        selectByText(chooseColor,color);
        return this;
    }

    public TaskEPage2 selectSize(String size) {
        moveToElement(chooseSize);
        selectByText(chooseSize,size);
        return this;
    }

    public TaskEPage2 addToCart() {
        moveToElement(addToCartButton);
        addToCartButton.click();
        return this;
    }

    public TaskEPage openingCartPage() {
        moveToElement(linkToCartPage);
        linkToCartPage.click();
        return new TaskEPage(driver);
    }

}
//E) в задании использовать паттерн page factory
//1. Open http://shop.demoqa.com/
//2. Search “Blue” query
//3. Select 37 size
//4. Choose first one product
//5. Choose color
//6. Choose size
//7. Add to cart
//8. Navigate to cart and verify that product present in cart