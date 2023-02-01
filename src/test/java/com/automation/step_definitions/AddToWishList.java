package com.automation.step_definitions;
import com.automation.pages.WishList;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddToWishList {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    WishList addToWishlist = new WishList((ChromeDriver) Hooks.driver);

    @Given("User logs")
    public void User_logs(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("clicks on product tabs")
    public void clcksproductTab(){
        addToWishlist.chooseProductTab();
    }
    @When("clicks on required product")
    public void clcksproduct(){
        addToWishlist.chooseReqProduct();
    }
    @When("click on add to wishlist")
    public void addwishlist(){
        addToWishlist.addWishList();
    }
    @Then("Related product added successfully")
    public void addsuccessfully(){
        addToWishlist.AssertAdd();
        String ExpectedMesg ="Apple MacBook Pro 13-inch";
        String Actual = addToWishlist.product.getText();
        Assert.assertTrue(addToWishlist.wishlistHeader.isDisplayed());
        Assert.assertEquals(Actual, ExpectedMesg);
    }
}
