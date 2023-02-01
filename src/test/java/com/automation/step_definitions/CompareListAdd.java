package com.automation.step_definitions;
import com.automation.pages.CompareList;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CompareListAdd {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    CompareList addToComparelist = new CompareList((ChromeDriver) Hooks.driver);

    @Given("logged user")
    public void User_try_logged_in(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("click on product tabs")
    public void clck_product_Tab0(){
        CompareListAdd.chooseProductTab();
    }
    @When("click on required product")
    public void clck_product_to_open0(){
        CompareListAdd.chooseReqProduct();
    }
    @When("click on add to compare list")
    public void add_compare_List0(){
        CompareListAdd.addCompare();
    }
    @Then("related products added successfully")
    public void product_added_success0(){
        CompareListAdd.AssertAdd();
        String ExpectedMesg ="Apple MacBook Pro 13-inch";
        String Actual = CompareListAdd.product.getText();
        Assert.assertTrue(CompareListAdd.compareProducts.isDisplayed());
        Assert.assertEquals(Actual, ExpectedMesg);
    }
}
