package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    By FirstNameBy = By.id("first-name");
    By LastNameBy = By.id("last-name");
    By ZIPCodeBy = By.id("postal-code");
    By ContiniouButtonBy = By.id("continue");
    By productPrice = By.className("summary_subtotal_label");
    By taxPrice = By.className("summary_tax_label");
    By totalPrice = By.className("summary_total_label");
    By checkoutOverview = By.className("title");
    By finishBy = By.id("finish");
    By checkoutComplete = By.className("complete-header");
    String FirstName = "Stevica";
    String LastName = "Jandric";
    String Postal = "26314";
    String overview = "CHECKOUT: OVERVIEW";
    String complete = "THANK YOU FOR YOUR ORDER";

    public CheckoutPage checkoutPage() {
        click(ContiniouButtonBy);
        return this;
    }

    public CheckoutPage filling() {
        writeText(FirstNameBy, FirstName);
        writeText(LastNameBy, LastName);
        writeText(ZIPCodeBy, Postal);
        click(ContiniouButtonBy);
        return this;
    }

    public CheckoutPage verifyTotalPrice(){
        double c1 = Double.parseDouble(readText(productPrice).substring(13));
        double c2 = Double.parseDouble(readText(taxPrice).substring(6));
        double c3 = Double.parseDouble(readText(totalPrice).substring(8));
        double summ = c1 + c2;
        Assert.assertEquals(c3, summ, 0.01);
        return this;
    }



    public CheckoutPage verifyCheckoutOverview(String overview) {
        String actualText = readText(checkoutOverview);
        assertStringEquals(actualText, overview);
        return this;

    }

    public CheckoutPage finish() {
        click(finishBy);
        return this;
    }

    public CheckoutPage verifyCheckpoutComplete(String complete) {
        String actualText = readText(checkoutComplete);
        assertStringEquals(actualText, complete);
        return this;
    }

   
}
