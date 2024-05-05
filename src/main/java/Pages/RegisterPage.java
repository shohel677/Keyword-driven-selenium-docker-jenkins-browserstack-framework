package Pages;

import AbstractComponents.GenericWebPage;

import static AbstractComponents.AbstractComponent.waitUntilVisible;

public class RegisterPage extends GenericWebPage {

    private final static String pageTitle = "//div[@class='page-title']/h1[normalize-space()='Register']";
    private final static String registrationConfirmation = "//div[text()='Your registration completed']";

    public boolean isRegisterPage(){
        return waitUntilVisible(pageTitle).isDisplayed();
    }
    public boolean isRegistrationConfirmationDisplayed(){
         return waitUntilVisible(registrationConfirmation).isDisplayed();
    }





}
