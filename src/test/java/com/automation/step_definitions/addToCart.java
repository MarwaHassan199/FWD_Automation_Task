package com.automation.step_definitions;

import com.automation.pages.AddToCart;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class addToCart {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    AddToCart addToCart = new AddToCart((ChromeDriver) Hooks.driver);

    @Given("User log")
    public void User_log(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("clck product tabs")
    public void clckproductTab(){
        addToCart.chooseProductTab();
    }
    @When("clck on required product")
    public void chooseproduct(){
        addToCart.chooseReqProduct();
    }
    @When("clck on add to cart")
    public void addproduct(){
        addToCart.addCart();
    }
    @Then("Related products added successfully")
    public void addingsuccessfully(){
        addToCart.AssertAdd();
        String ExpectedMesg ="Apple MacBook Pro 13-inch";
        String Actual = addToCart.product.getText();
        Assert.assertTrue(addToCart.shoppingCart.isDisplayed());
        Assert.assertEquals(Actual, ExpectedMesg);
    }
}
