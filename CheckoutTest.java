package tests;

import org.junit.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest{
    public LoginPage loginPage;
    public HomePage homePage;
    public CheckoutPage checkoutPage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expextedText = "PRODUCTS";
    String expectedText2 = "CHECKOUT: OVERVIEW";
    String expectedText3 = "THANK YOU FOR YOUR ORDER";

    @Test
    public void verifyCheckoutInfoBy(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expextedText);
        homePage.verifyProductsAddedToCart();
        homePage.shoppingCart();
        cartPage.verifyCheckout();
        checkoutPage.filling();
        checkoutPage.verifyCheckoutOverview(expectedText2);
        

        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
        
    }

    @Test
    public void verifyTotal(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expextedText);
        homePage.verifyProductsAddedToCart();
        homePage.shoppingCart();
        cartPage.verifyCheckout();
        checkoutPage.filling();
        checkoutPage.verifyCheckoutOverview(expectedText2);
        checkoutPage.verifyTotalPrice();

        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
    }



    @Test
    public void verifyFinish(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expextedText);
        homePage.verifyProductsAddedToCart();
        homePage.shoppingCart();
        cartPage.verifyCheckout();
        checkoutPage.filling();
        checkoutPage.verifyCheckoutOverview(expectedText2);
        checkoutPage.verifyTotalPrice();
        checkoutPage.finish();
        checkoutPage.verifyCheckpoutComplete(expectedText3);

        
        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }

    }


    
    }
    

