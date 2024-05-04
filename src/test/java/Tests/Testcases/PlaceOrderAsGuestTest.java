package Tests.Testcases;

import TestComponents.BaseTest;
import Tests.Steps.UserRegistrationSteps;
import org.testng.annotations.Test;

public class PlaceOrderAsGuestTest extends BaseTest {

    UserRegistrationSteps userRegistrationSteps = new UserRegistrationSteps();

    @Test(description = "Nopcommerce registration feature Test1")
    public void testToVerifyRegistration1(){
        userRegistrationSteps.userGoesToNopCommerceHomePage();

    }
}
