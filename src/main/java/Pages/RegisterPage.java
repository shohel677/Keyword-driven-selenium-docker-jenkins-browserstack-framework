package Pages;

import AbstractComponents.GenericWebPage;

import static AbstractComponents.AbstractComponent.waitForSeconds;
import static AbstractComponents.AbstractComponent.waitUntilVisible;

public class RegisterPage extends GenericWebPage {

    private final String pageTitle = "//div[@class='page-title']/h1[normalize-space()='Register']";

    public boolean isRegisterPage(){
        return waitUntilVisible(pageTitle).isDisplayed();
    }





}
