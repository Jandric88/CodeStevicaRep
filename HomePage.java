package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
    super(driver);
    }

    By productsTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By numberOFItemsBy = By.className("inventory_item");
    By menyBy = By.id("react-burger-menu-btn");
    By logoutBy = By.id("logout_sidebar_link");
    By tShirtBy = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    By jacketBy = By.id("add-to-cart-sauce-labs-fleece-jacket");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By shoppingCartLinkBy = By.className("shopping_cart_link");
    By firstProductBy = By.id("item_1_title_link");
    By secondProductBy = By.id("item_5_title_link");
    String firstProduct = "Sauce Labs Bolt T-Shirt";
    String secondProduct = "Sauce Labs Fleece Jacket";

    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText(productsTitleBy);
        assertStringEquals(actualText, expectedText);
        return this;
    }

    public HomePage numberOfProducts(int expectedNumberOfProducts){
        int actualNumberOfProducts = brojacItema(numberOFItemsBy);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public HomePage clickMeny(){
        click(menyBy);
        return this;
    }

    public HomePage logout(){
        click(logoutBy);
        return this;        
        
    }

    

    public HomePage verifyProductsAddedToCart(){
        click(tShirtBy);
        click(jacketBy);
        click(shoppingCartBadgeBy);
        String productOne = readText(firstProductBy);
        assertStringEquals(productOne, firstProduct);
        String productTwo = readText(secondProductBy);
        assertStringEquals(productTwo, secondProduct);
        return this;
    }

    public HomePage shoppingCart(){
        click(shoppingCartLinkBy);
        return this;
    }
}
