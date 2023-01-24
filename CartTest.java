package tests;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public HomeTest homeTest;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expextedText = "PRODUCTS";

    @Test
    public void verifyCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.basePage();
        loginPage.login(standardUsername, password);
        homePage.verifySuccesfulLogin(expextedText);
        homePage.verifyProductsAddedToCart();
        homePage.shoppingCart();
        cartPage.verifyCheckout();
        


        try{
            Thread.sleep(5000);
        }catch(InterruptedException s){
            s.printStackTrace();
        }
        

       
    }

    
    
}
