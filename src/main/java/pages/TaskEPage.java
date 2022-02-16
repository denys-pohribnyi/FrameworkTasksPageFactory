package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TaskEPage extends BasePage {
    public TaskEPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[2]")
    WebElement itemInTheList;

    public TaskEPage checkingCart(String expectedItemName) {
        moveToElement(itemInTheList);
        Assert.assertEquals(itemInTheList.getText(), expectedItemName);
        return this;
    }
}
