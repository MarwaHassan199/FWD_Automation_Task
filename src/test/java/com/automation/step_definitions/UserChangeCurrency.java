package com.automation.step_definitions;
import com.automation.pages.ChangeCurrency;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UserChangeCurrency {

    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    ChangeCurrency changeCurrency = new ChangeCurrency((ChromeDriver) Hooks.driver);

    @Given("Logged user")
    public void loggeduser(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }

    @When("Change currency from currency menu")
    public void changecurrency(){
        changeCurrency.ChangeCurrency();
    }
    @Then("Currency changes successfully")
    public void currencychangesuccessfully(){
       Assert.assertTrue(changeCurrency.price.getText().contains("€"));
    }
}
