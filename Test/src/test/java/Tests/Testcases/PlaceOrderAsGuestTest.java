package Tests.Testcases;

import DataLoader.TestData;
import TestComponents.BaseTest;
import Tests.Steps.PlaceOrderAsGuestSteps;
import org.testng.ITestContext;
import org.testng.annotations.Test;



public class PlaceOrderAsGuestTest extends BaseTest {

    private final PlaceOrderAsGuestSteps placeOrderAsGuestSteps = new PlaceOrderAsGuestSteps();

    @Test(description = "User should be able to successfully place order as a guest user", dataProvider = "TestDataProviderFunction", dataProviderClass = TestData.class)
    public void testToVerifyPlaceOrderAsGuest(String testDataFromDataProvider, ITestContext testContext){

        Filler.DataReader.testDataCurrentRow = testDataFromDataProvider;

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
