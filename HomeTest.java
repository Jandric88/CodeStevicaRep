package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expextedText = "PRODUCTS";
    int numberOfAllItems = 6;


    @Test
    public void verifyNumberofItemsOnHomePage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expextedText);
        homePage.numberOfProducts(numberOfAllItems);
        
        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
    }

    @Test
    public void verifySucessfulLogout(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expextedText);
        homePage.clickMeny();
        homePage.logout();
        loginPage.verifyLogout();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
    }

    @Test
    public void verifyProductsAddedToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expextedText);
        homePage.verifyProductsAddedToCart();
        
        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }

    }
    
}
