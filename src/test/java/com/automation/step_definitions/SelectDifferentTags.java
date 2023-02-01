package com.automation.step_definitions;
import com.automation.pages.SelectTag;
import com.automation.pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SelectDifferentTags {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    SelectTag selectTag = new SelectTag((ChromeDriver) Hooks.driver);
    @Given("User login")
    public void Userlog(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }

    @When("Choose any category")
    public void choosecategory(){
        selectTag.selectProduct();
    }

    @When("choose awesome tag")
    public void chooseTag(){
        selectTag.selectTag();
    }

    @Then("Related products appear successfully")
    public void relatedtagproducts(){
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("awesome"));
    }
}
