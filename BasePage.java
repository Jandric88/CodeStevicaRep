package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitVisability(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    public void click (By elementBy){
        waitVisability(elementBy);
        driver.findElement(elementBy).click();
    }
    
    public void writeText(By elementBy, String text){
        waitVisability(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public String readText(By elementBy){
        waitVisability(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void assertStringEquals(String actualText, String expectedText){
        Assert.assertEquals(actualText, expectedText);
    }

    public int brojacItema(By elementBy){
        waitVisability(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void assertIntegerEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public void writeNumber(By elementBy){
        
         
    }

    
}
