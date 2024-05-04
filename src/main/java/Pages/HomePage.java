package Pages;

import AbstractComponents.GenericWebPage;
import org.openqa.selenium.By;

import static AbstractComponents.AbstractComponent.waitUntilVisible;

public class HomePage extends GenericWebPage {

    private final String nopCommerceLogo = "//a/img[@alt='nopCommerce demo store']";
    private final String registerButton = "//a[text()='Register']";



    public boolean isHomePageLoaded(){
        return waitUntilVisible(nopCommerceLogo).isDisplayed();

    }
    public void navigateToRegistrationPage(){
        instanceDriver.findElement(By.xpath(registerButton)).click();
        logger.info("user clicked on register button");
    }




}
