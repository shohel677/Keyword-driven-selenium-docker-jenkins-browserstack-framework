package Tests.Steps;

import Pages.HomePage;
import Pages.RegisterPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static AbstractComponents.FrameworkAssertionLibrary.assertionShouldBeTrue;
import static AbstractComponents.FrameworkAssertionLibrary.stepAssertionShouldBeTrue;
import static DataLoader.Reader.fieldsFiller;

public class UserRegistrationSteps extends BaseTest {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Given("User go to the NopCommerce Home page")
    public void userGoesToNopCommerceHomePage() {
        stepAssertionShouldBeTrue(homePage.isHomePageLoaded(),"User landed on NopCommerce homepage");
    }
    @When("User navigate to the Registration page")
    public void userNavigateToRegistrationPage() {
        homePage.navigateToRegistrationPage();
        stepAssertionShouldBeTrue(registerPage.isRegisterPage(),"User landed on NopCommerce registration page");
    }

    @And("User select the {gender} as gender")
    public void userSelectGender() {
        fieldsFiller("userRegistrationGender.csv");
        stepAssertionShouldBeTrue(true,"Gender field is selected");
    }

    @And("User set first name and last name")
    public void userSetFirstNameAndLastName() {
        fieldsFiller("userRegistrationFirstAndLastName.csv");
        stepAssertionShouldBeTrue(true,"Entered user last name and first name field");
    }

    @And("User set {dob} as date of birth")
    public void userSetDOB() {
        fieldsFiller("userRegistrationDOB.csv");
        stepAssertionShouldBeTrue(true,"User date of birth is selected");
    }

    @And("User set {email} as email")
    public void userSetEmail() {
        fieldsFiller("userRegistrationSetEmail.csv");
        stepAssertionShouldBeTrue(true,"User email is entered");
    }

    @And("User set {companyName} as company details")
    public void userSetCompanyName() {
        fieldsFiller("userRegistrationSetCompanyName.csv");
        stepAssertionShouldBeTrue(true,"Company name of user is set");
    }

    @And("User set Newsletter option as {Status}")
    public void userSetNewsletterOption() {
        fieldsFiller("userRegistrationNewsletter.csv");
        stepAssertionShouldBeTrue(true,"Newsletter status is set");
    }

    @And("User set {password} as password and confirm password again")
    public void userSetPassword() {
        fieldsFiller("userRegistrationSetPassword.csv");
        stepAssertionShouldBeTrue(true,"Entered value on Password and confirm password field");
    }

    @And("User click on the Register button")
    public void userClickOnRegisterButton() {
        fieldsFiller("userRegistrationRegister.csv");
        stepAssertionShouldBeTrue(true,"user register button is clicked");
    }

    @Then("Verify that the new account registration message ({message}) is displayed$")
    public void verifyRegistrationMessage() {
        stepAssertionShouldBeTrue(registerPage.isRegistrationConfirmationDisplayed(),"Registration confirmation message is displayed");
    }

}
