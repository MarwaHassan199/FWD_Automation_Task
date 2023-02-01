package com.automation.step_definitions;
import com.automation.pages.AddToCart;
import com.automation.pages.SuccessfulOrder;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UserOrder {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    AddToCart addToCart = new AddToCart((ChromeDriver) Hooks.driver);
    SuccessfulOrder order = new SuccessfulOrder((ChromeDriver) Hooks.driver);

    @Given("user login")
    public void userlogin(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("User add product to cart")
    public void addToCart(){
        addToCart.chooseProductTab();
        addToCart.chooseReqProduct();
        addToCart.addCart();
        addToCart.AssertAdd();
    }
    @When("click on checkout")
    public void checkoutorder(){
        order.Checkout();
    }
    @When("completes his data")
    public void completedata(){
        order.EnterUserData("Egypt","Giza","Giza","12334","12345678910");
    }
    @When("User follow all steps")
    public void followsteps(){
        order.CompletePurchase();
    }
    @Then("Order completed successfully")
    public void ordersuccessfully(){
        order.ConfirmedOrder();
        Assert.assertTrue(order.ThankYou.isDisplayed());
        Assert.assertTrue(order.SucessOrder.isDisplayed());
    }

}
