package com.automation.step_definitions;
import com.automation.pages.ForgetPasswordPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ForgetPassword {

    ForgetPasswordPage RecoverPass = new ForgetPasswordPage((ChromeDriver) Hooks.driver);
    @When("Open login page")
    public void Openloginpage(){
        RecoverPass.OpenLoginPage();
    }

    @When("click on forget password")
    public void clkforgetpassword(){
        RecoverPass.ClickForgetPassword();
    }

    @When("valid  email")
    public void validemail(){
        RecoverPass.EnterUserEmail("maroo1181999@gmail.com");
    }

    @When("click recover button")
    public void clckrecoverbtn(){
        RecoverPass.ClickRecoverPass();
    }

    @Then("recover password successfully")
    public void recoverpasswordsuccessfully()  {
        String ExpectedMesg = "Email with instructions has been sent to you.";
        String Actual = RecoverPass.RecoverSuccessfullyMesg.getText();
        Assert.assertEquals(ExpectedMesg, Actual);
    }



}
