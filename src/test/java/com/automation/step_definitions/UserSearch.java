package com.automation.step_definitions;
import com.automation.pages.SearchPage;
import com.automation.pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UserSearch {
    loginPage login = new loginPage((ChromeDriver) Hooks.driver);
    SearchPage search = new SearchPage((ChromeDriver) Hooks.driver);

    @Given("Loggedin user")
    public void logged_in(){
        login.OpenLoginPage();
        login.UserLogin("maroo1181999@gmail.com","123456");
        login.ClickLoginBtn();
    }
    @When("clicks on search field")
    public void clicksonsearchfield()
    {
        search.ClickSearchBtn();
    }

    @And("search with product name")
    public void searchwithproductname()
    {
        search.SearchBox("book");
    }

    @Then("find relative results")
    public void couldfindrelatedresults()
    {
        int count=   search.ProductTitle.size();
        System.out.println(count);
        Assert.assertTrue(count > 0);
        for (int x = 0; x < count ; x++) {
            System.out.println(search.ProductTitle.get(x).getText());
            Assert.assertTrue(search.ProductTitle.get(x).getText().toLowerCase().contains("book"));
        }
    }

}
