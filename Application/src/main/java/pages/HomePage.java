package pages;

import abstractComponents.GenericWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static abstractComponents.AbstractComponent.waitForSeconds;
import static abstractComponents.AbstractComponent.waitUntilVisible;

public class HomePage extends GenericWebPage {
    private enum homeText{
        logo("nopCommerce demo store"),
        register("Register"),
        category("Electronics"),
        categoryOption("Cell phones");

        private final String text;

        homeText(String text) {
            this.text = text;

        }

    }
    private final static String nopCommerceLogo = "//a/img[@alt='%s']";
    private final static String registerButton = "//a[text()='%s']";
    private final static String categoryXpath = "//div[@class='header-menu']/ul[contains(@class, 'notmobile')]/li/a[normalize-space()='%s']";
    private final static String categoryOptionXpath = "//div[@class='header-menu']/ul[contains(@class, 'notmobile')]/li/a[normalize-space()='%1s']/following-sibling::ul//a[contains(text(), '%2s')]";

    private WebElement category(){
        return instanceDriver.findElement(By.xpath(String.format(categoryXpath, homeText.category.text)));
    }
    private WebElement categoryOption(){
        return instanceDriver.findElement(By.xpath(String.format(categoryOptionXpath, homeText.category.text,  homeText.categoryOption.text)));
    }

    public void categoryOptionClick(){
        Actions actions = new Actions(instanceDriver);
        category().isDisplayed();
        actions.moveToElement(category()).build().perform();
        actions.moveToElement(categoryOption()).click().build().perform();
       logger.info("Clicking cell phones category option");
        waitForSeconds(3);
    }
    public boolean isHomePageLoaded(){
        return waitUntilVisible(nopCommerceLogo,homeText.logo.text).isDisplayed();

    }
    public void navigateToRegistrationPage(){
        instanceDriver.findElement(By.xpath(String.format(registerButton, homeText.register.text))).click();
        logger.info("user clicked on register button");

    }

}
