package com.app.demo.stepdef;
import com.app.demo.base.BaseUtil;
import com.app.demo.base.CoreActions;
import com.app.demo.pages.CreateAccountPage;
import com.app.demo.pojo.NewUserProfile;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;

public class CreateAccountStepDef extends BaseUtil{

    private  BaseUtil base;
    private CreateAccountPage createAccountPage;
    public CreateAccountStepDef(BaseUtil base) {
        this.base = base;
    }

    @When("I create a new profile without accepting captcha challenge")
    public void i_create_a_new_profile() {
        Random r = new Random();
        int number = r.nextInt(1000);
        userProfile = NewUserProfile.builder()
                .firstName("Test"+ number)
                .lastName("Tester"+number)
                .email("tester"+number+"@gmail.com")
                .password("Hello$$6243")
                .birthMonth("February")
                .birthDay("20").build();
        createAccountPage= new CreateAccountPage(BaseUtil.Driver);
        createAccountPage.createAccount(userProfile);
        assertThat("Account creation failed",BaseUtil.Driver.getTitle().equals("(1) New Message!")||BaseUtil.Driver.getTitle().equals("Challenge"));

    }

}
