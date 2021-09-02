import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DemoQa {

    WebDriver driver;

    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("document.querySelector('footer').style.display='none';");



    }

    @Test
    public void fillStudentForm(){
        typeTextBox(By.id("firstName"), "Lola");
        typeTextBox(By.cssSelector("#lastName"), "Smith");
        typeTextBox(By.xpath("//*[@id='userEmail']"), "email@gmail.com");
        driver.findElement(By.cssSelector(".custom-control-label")).click();
        typeTextBox(By.id("userNumber"), "2314235");
        typeTextBox(By.xpath("//*[@id='dateOfBirthInput']"), "18 Aug 2021");

        driver.findElement(By.id("close-fixedban")).click();

        driver.findElement(By.id("submit"));

    }

    public void typeTextBox(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
}
