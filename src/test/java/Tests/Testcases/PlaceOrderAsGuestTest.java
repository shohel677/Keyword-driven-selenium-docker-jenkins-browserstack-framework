package Tests.Testcases;

import DataLoader.Reader;
import DataLoader.TestData;
import TestComponents.BaseTest;
import Tests.Steps.PlaceOrderAsGuestSteps;
import Tests.Steps.UserRegistrationSteps;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PlaceOrderAsGuestTest extends BaseTest {

    PlaceOrderAsGuestSteps placeOrderAsGuestSteps = new PlaceOrderAsGuestSteps();

    @Test(description = "User should be able to successfully place order as a guest user", dataProvider = "TestDataProviderFunction", dataProviderClass = TestData.class)
    public void testToVerifyPlaceOrderAsGuest(String testDataFromDataProvider, ITestContext testContext){

        Reader.testDataCurrentRow = testDataFromDataProvider;

        placeOrderAsGuestSteps.userGoToTheNopCommerceHomePage();
        placeOrderAsGuestSteps.userClickOptionFromCategory();
        placeOrderAsGuestSteps.userClickOnProductForDetails();
        placeOrderAsGuestSteps.userSetTheQuantityNumberInQuantityField();
        placeOrderAsGuestSteps.userClickOnButton();
        placeOrderAsGuestSteps.userGoToTheShippingCartPage();
        placeOrderAsGuestSteps.userAcceptTermsConditionsAndClickCheckoutButton();
        placeOrderAsGuestSteps.userClickCheckoutAsGuestButton();
        placeOrderAsGuestSteps.userInputAllTheBillingDetailsAndClickContinue();
        placeOrderAsGuestSteps.userSelectShippingMethodAndClickContinue();
        placeOrderAsGuestSteps.userSelectPaymentMethodAndClickContinue();
        placeOrderAsGuestSteps.userSelectCardAndInputCardInformation();
        placeOrderAsGuestSteps.userClickConfirmButtonToPlaceTheOrder();
        placeOrderAsGuestSteps.verifyOrderPlaceMessage();
    }
}
