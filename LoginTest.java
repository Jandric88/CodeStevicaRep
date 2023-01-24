package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

    public LoginPage loginPage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";
    String emptyUsername ="";
    String emptyPassword = "";
    String badUsername = "stevica";
    String badUsernameError = "Epic sadface: Username and password do not match any user in this service";
    String errorText = "Epic sadface: Username is required";
    String errorText2 = "Epic sadface: Password is required";
    @Test
    public void loging(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expectedText);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
    }

    @Test
    public void unsuccesfulLoginWithEmptyUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(emptyUsername, password);
        loginPage.verifyUnseccesfulLogin(errorText);

        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
    }

    @Test
    public void unsuccesfulLoginWithEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, emptyPassword);
        loginPage.verifyUnseccesfulLogin(errorText2);
        
        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
    }

    @Test
    public void unsuccesfulLoginWithBadUsername(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(badUsername, password);
        loginPage.verifyUnseccesfulLogin(badUsernameError);
        
        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
    }
}

    

