package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TaskEPage;
import pages.TaskEPage2;

public class TaskEPgFactoryTest extends BaseTest {
    TaskEPage2 taskEPageFactory;
    TaskEPage taskECartPage;

    @BeforeMethod
    public void setUp() {
        taskECartPage = new TaskEPage(getDriver());
        taskEPageFactory = new TaskEPage2(getDriver());
    }

    @Test
    public void test() {
        openURL("http://shop.demoqa.com/");
        taskEPageFactory
                .searchItem("Blue")
                .filterSize("37")
                .chooseFirstProduct()
                .selectColor("Blue")
                .selectSize("37")
                .addToCart()
                .openingCartPage();
        taskECartPage.checkingCart("BLUE SINNER RIPPED KNEE HIGH WAIST SKINNY JEANS - BLUE\n" +
                "SIZE:\n" +
                "37");
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