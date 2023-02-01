package com.automation.step_definitions;
import com.automation.pages.FilterColor;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWithColor {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    FilterColor filterColor = new FilterColor((ChromeDriver) Hooks.driver);

    @Given("The Logged user")
    public void Logged_user(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("Choose shoes category")
    public void chooseShoes(){
        filterColor.SelectShoes();
    }
    @When("Choose blue color shoes")
    public void chooseBlueShoes(){
        filterColor.SelectColor();
    }
    @Then("Required product color appears successfully")
    public void BlueChooseappearssuccessfully(){
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("specs=16"));

    }

}
