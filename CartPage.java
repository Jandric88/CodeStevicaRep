package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
    super(driver);
    }
    
    By firstProductBy = By.id("item_1_title_link");
    By secondProductBy = By.id("item_5_title_link");
    By checkoutBy = By.id("checkout");
    By checkoutInformationBy = By.className("title");
    String checkoutInformation = "CHECKOUT: YOUR INFORMATION";
    String firstProduct = "Sauce Labs Bolt T-Shirt";
    String secondProduct = "Sauce Labs Fleece Jacket";


    public CartPage verifyCheckout(){
        String productOne = readText(firstProductBy);
        assertStringEquals(productOne, firstProduct);
        String productTwo = readText(secondProductBy);
        assertStringEquals(productTwo, secondProduct);
        click(checkoutBy);
        String actualText = readText(checkoutInformationBy);
        assertStringEquals(actualText, checkoutInformation);
        return this;
    }



}