package Pages;

import AbstractComponents.GenericWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static AbstractComponents.AbstractComponent.waitUntilVisible;

public class ShoppingCartPage extends GenericWebPage {

    private final static String termsCheckBoxXpath = "//div[@class='terms-of-service']/input[@type='checkbox']";
    private final static String checkoutXpath = "//button[normalize-space()='Checkout']";
    private final static String checkOutAsGuestXpath = "//button[text()='Checkout as Guest']";

    private WebElement termsCheckBox(){
        return instanceDriver.findElement(By.xpath(termsCheckBoxXpath));
    }
    private WebElement checkout(){
        return instanceDriver.findElement(By.xpath(checkoutXpath));
    }

    public void acceptTermsAndCondition(){
        waitUntilVisible(termsCheckBoxXpath);
        termsCheckBox().click();
        logger.info("Accept terms and condition");

    }
    public void clickCheckoutButton(){
        checkout().click();
        logger.info("Click checkout button");

    }
    public void checkoutAsGuest(){
        waitUntilVisible(checkOutAsGuestXpath).click();
        logger.info("Click checkout as guest button");
    }


}
