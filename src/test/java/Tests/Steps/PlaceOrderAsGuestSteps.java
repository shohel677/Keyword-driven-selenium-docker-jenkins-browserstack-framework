package Tests.Steps;

import Pages.*;
import TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static AbstractComponents.AbstractComponent.waitForSeconds;
import static AbstractComponents.FrameworkAssertionLibrary.stepAssertionShouldBeTrue;
import static DataLoader.Reader.fieldsFiller;

public class PlaceOrderAsGuestSteps extends BaseTest {

    HomePage homePage = new HomePage();
    ProductsPage productsPage = new ProductsPage();
    ProductsDetailsPage productsDetailsPage = new ProductsDetailsPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    ThankYouPage thankYouPage = new ThankYouPage();

    @Given("User go to the NopCommerce Home page")
    public void userGoToTheNopCommerceHomePage() {
        stepAssertionShouldBeTrue(homePage.isHomePageLoaded(),"User landed on NopCommerce homepage");
    }

    @When("User click Cell phones option from Electronics category")
    public void userClickOptionFromCategory() {
        homePage.categoryOptionClick();
    }

    @And("User click on the Nokia Lumia 1020 for product details")
    public void userClickOnProductForDetails() {
        productsPage.clickOnProductDetails();
    }

    @And("User set the quantity number 2 in the quantity field")
    public void userSetTheQuantityNumberInQuantityField() {
        productsDetailsPage.enterProductQuantity();
    }

    @And("User click on the ADD TO CART button")
    public void userClickOnButton() {
        productsDetailsPage.clickAddToCart();
    }

    @And("User go to the shipping cart page")
    public void userGoToTheShippingCartPage() {
        productsDetailsPage.navigateToShoppingCart();
    }

    @And("User accept terms conditions and click checkout button")
    public void userAcceptTermsConditionsAndClickCheckoutButton() {
        shoppingCartPage.acceptTermsAndCondition();
        shoppingCartPage.clickCheckoutButton();
    }

    @And("User click checkout as guest button")
    public void userClickCheckoutAsGuestButton() {
        shoppingCartPage.checkoutAsGuest();
    }

    @And("User input all the billing details and click continue")
    public void userInputAllTheBillingDetailsAndClickContinue() {
        waitForSeconds(5);
        fieldsFiller("placeOrderBillingAddress.csv");
    }

    @And("User select shipping method Next Day Air and click continue")
    public void userSelectShippingMethodAndClickContinue() {
        checkoutPage.selectShippingMethodAndContinue();
          }

    @And("User select payment method Credit Card and click continue")
    public void userSelectPaymentMethodAndClickContinue() {
        checkoutPage.selectPaymentTypeAndContinue();
    }

    @And("User select Visa card and input card information")
    public void userSelectCardAndInputCardInformation() {
        checkoutPage.cardInformationAndContinue();
    }

    @And("User click confirm button to place the order")
    public void userClickConfirmButtonToPlaceTheOrder() {
        checkoutPage.clickOrderConfirm();
    }

    @Then("Verify that the order place message")
    public void verifyOrderPlaceMessage() {
        stepAssertionShouldBeTrue(thankYouPage.verifyOrderConfirmationMessage(),"Order confirmation message is displayed");
    }
}
