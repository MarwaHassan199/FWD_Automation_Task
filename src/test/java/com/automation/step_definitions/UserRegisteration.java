package com.automation.step_definitions;
import com.automation.pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UserRegisteration {

    RegisterPage register = new RegisterPage((ChromeDriver) Hooks.driver);

    @Given("open registration page")
    public void clickonregisterlink(){
       register.OpenRegistrationPage();
    }

    @When("enter the user data")
    public void enteruserdata(){
        register.Registration("Marwa","hassan","maroo1181999@gmail.com","123456");
    }

    @When("click register button")
    public void clickregisterbutton() {
     register.ClickRegBtn();
    }

    @Then("Register Successfully")
    public void successfulregistration() throws InterruptedException {
        String ExpectedMesg = "Your registration completed";
        String Actual = register.SuccessMessage.getText();
        Assert.assertEquals(ExpectedMesg, Actual);
        register.Logout();

    }



}
