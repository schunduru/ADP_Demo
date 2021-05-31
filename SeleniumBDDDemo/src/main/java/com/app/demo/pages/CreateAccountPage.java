package com.app.demo.pages;

import com.app.demo.base.CoreActions;
import com.app.demo.pojo.NewUserProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    private CoreActions coreActions;
    public CreateAccountPage(WebDriver driver) {
        coreActions=new CoreActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='first_name']")
    public WebElement txtFirstName;

    @FindBy(how = How.XPATH, using = "//input[@id='last_name']")
    public WebElement txtLastName;

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    public WebElement txtEmail;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    public WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//input[@value='Sign Up']")
    public WebElement btnCreateAccount;


    public void createAccount(NewUserProfile profile)
    {
        coreActions.type(txtFirstName,profile.getFirstName());
        coreActions.type(txtLastName,profile.getLastName());
        coreActions.type(txtEmail,profile.getEmail());
        coreActions.type(txtPassword,profile.getPassword());
        coreActions.click(btnCreateAccount);
    }

}
