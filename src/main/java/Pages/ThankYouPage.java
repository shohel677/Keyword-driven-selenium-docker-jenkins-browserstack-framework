package Pages;

import AbstractComponents.GenericWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static AbstractComponents.AbstractComponent.waitForSeconds;
import static AbstractComponents.AbstractComponent.waitUntilVisible;

public class ThankYouPage extends GenericWebPage {

    private final static String orderConfirmationMessageXpath = "//div/strong[text()='Your order has been successfully processed!']";

    private WebElement orderConfirmationMessage(){
        return instanceDriver.findElement(By.xpath(orderConfirmationMessageXpath));
    }

    public boolean verifyOrderConfirmationMessage(){
        waitForSeconds(3);
        return orderConfirmationMessage().isDisplayed();

    }




}
