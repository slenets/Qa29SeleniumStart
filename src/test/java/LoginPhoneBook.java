import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginPhoneBook {

    WebDriver driver;

    @BeforeMethod
    public void init(){
        driver = new ChromeDriver();
        driver.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        driver.manage().window().maximize();
    }

    @Test
    public void loginTest(){
        //1 open login page
        WebElement loginForm = driver.findElement(By.cssSelector("[href='/login']"));
        loginForm.click();

        //2 click on email text-box
        typeTextBox(By.cssSelector("[placeholder='Email']"), "a1@b1.ru");

        //3 click on password text-box
        typeTextBox(By.cssSelector("[placeholder='Password']"), "AAbb3'$'");

        //4 click on login button
        WebElement loginBth = driver.findElement(By.cssSelector("button:nth-child(4)"));
        loginBth.click();

    }

    public void typeTextBox(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
