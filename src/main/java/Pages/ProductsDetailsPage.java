package Pages;

import AbstractComponents.GenericWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static AbstractComponents.AbstractComponent.waitUntilVisible;

public class ProductsDetailsPage extends GenericWebPage {

    private final static String productQuantityXpath = "//div[@class='add-to-cart-panel']/label/following-sibling::input";
    private final static String addToCartXpath = "//div[@class='add-to-cart-panel']/button[text()='Add to cart']";
    private final static String shoppingCartButton = "//a[text()='shopping cart']";

    private WebElement productQuantity(){
        return instanceDriver.findElement(By.xpath(productQuantityXpath));
    }
    private WebElement addToCart(){
        return instanceDriver.findElement(By.xpath(addToCartXpath));
    }

    public void enterProductQuantity(){
        waitUntilVisible(productQuantityXpath).click();
        productQuantity().clear();
        productQuantity().sendKeys("2");
        logger.info("Enter quantity of product");

    }
    public void clickAddToCart(){
        addToCart().click();
        logger.info("Click add to cart button");

    }
    public void navigateToShoppingCart(){
        waitUntilVisible(shoppingCartButton).click();
        logger.info("Navigating to shopping cart");

    }

}
