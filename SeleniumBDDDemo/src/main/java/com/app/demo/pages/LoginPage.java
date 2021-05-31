package com.app.demo.pages;

import com.app.demo.base.CoreActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private CoreActions coreActions;
    public LoginPage(WebDriver driver) {
        coreActions=new CoreActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "customer_email")
    public WebElement txtEmail;

    @FindBy(how = How.ID, using = "customer_password")
    public WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//input[@value='Login']")
    public WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//a[text()='Sign up']")
    public WebElement linkCreateAccount;

    @FindBy(how = How.CSS, using = ".errors>ul>li")
    public WebElement labelErrorMessage;

    @FindBy(how = How.CSS, using = ".errors>ul>li")
    public List<WebElement> labelErrorMessages;

    public void login(String email, String password)
    {
        coreActions.type(txtEmail,email);
        coreActions.type(txtPassword,password);
        coreActions.click(btnLogin);
    }

    public void ClickCreateAccountLink()
    {
        coreActions.click(linkCreateAccount);
    }

    public String getLoginErrorMessage()
    {
       return coreActions.getText(labelErrorMessage);
    }

}
