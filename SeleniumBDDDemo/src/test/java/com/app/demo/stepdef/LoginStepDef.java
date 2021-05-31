package com.app.demo.stepdef;

import com.app.demo.base.BaseUtil;
import com.app.demo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class LoginStepDef extends BaseUtil {

    private BaseUtil base;
    private LoginPage loginPage;

    public LoginStepDef(BaseUtil base) {
        this.base = base;
    }


    @Given("I am on the login page")
    public void i_am_to_the_login_page() {
        BaseUtil.Driver.navigate().to("https://www.iwdagency.com/account/login");
        loginPage = new LoginPage(BaseUtil.Driver);
        assertThat("Login page filed to load", BaseUtil.Driver.getTitle().equals("(1) New Message!") || BaseUtil.Driver.getTitle().equals("Account"));
    }

    @When("I click on 'create account' link")
    public void i_click_on_create_account_link() {
        loginPage.ClickCreateAccountLink();
    }

    @When("I login with new user details")
    public void i_login_with_new_user_details() {
        loginPage.login(userProfile.getEmail(), userProfile.getPassword());
    }

    @Then("I see user unable to login with error message {string}")
    public void i_see_user_unable_to_login_with_error_message(String string) {
        if (loginPage.labelErrorMessages.size() > 0)
            assertThat("Message verification failed", loginPage.getLoginErrorMessage(), equalTo(string));
        else
            assertThat("Login page filed to load", BaseUtil.Driver.getTitle().equals("(1) New Message!") || BaseUtil.Driver.getTitle().equals("Challenge"));


    }
}