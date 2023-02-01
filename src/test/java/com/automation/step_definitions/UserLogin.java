package com.automation.step_definitions;
import com.automation.pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UserLogin {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);


    @Given("User go to login page")
    public void gotologinpage()  {
    login.OpenLoginPage();
    }

    @When("enter valid user data ")
    public void validusernamepassword()
    {
        login.UserLogin("maroo1181999@gmail.com","123456");
    }

    @And("click login button")
    public void loginbutton()
    {
        login.ClickLoginBtn();
    }

    @Then("login successfully")
    public void successlogin()
    {
        String ExpectedMesg = "My account";
        String Actual = login.SuccessLogin.getText();
        Assert.assertEquals(ExpectedMesg, Actual);
    }

}
