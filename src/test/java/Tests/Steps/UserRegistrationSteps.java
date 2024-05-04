package Tests.Steps;

import Pages.HomePage;
import Pages.RegisterPage;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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

    }

    @And("User set first name and last name")
    public void userSetFirstNameAndLastName() {
        fieldsFiller("userRegistrationFirstAndLastName.csv");
    }

    @And("User set {dob} as date of birth$")
    public void userSetDOB() {
        fieldsFiller("userRegistrationDOB.csv");
    }

    @And("User set {email} as email")
    public void userSetEmail() {

    }

    @And("User set {companyName} as company details")
    public void userSetCompanyName() {

    }

    @And("User set Newsletter option as {Status}")
    public void userSetNewsletterOption() {

    }

    @And("User set {password} as password and confirm password again")
    public void userSetPassword() {

    }

    @And("User click on the Register button")
    public void userClickOnRegisterButton() {

    }

    @Then("^Verify that the new account registration message (.*) is displayed$")
    public void verifyRegistrationMessage() {

    }

}
