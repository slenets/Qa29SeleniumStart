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

    @Test
    public void loginXpathTest(){
        //--- Open login page ---
        WebElement loginForm = driver.findElement(By.xpath("//div/a[3]"));
        //                                                  //a[text()='LOGIN']
        //                                                  //a[3]

        //--- click on email text-box ---
        typeTextBox(By.xpath("//input[1]"), "a1@b1.ru");
        //                    //*[@placeholder='Email']

        //--- click on password text-box ---
        typeTextBox(By.xpath("//input[2]"), "AAbb3'$'");
        //                    //*[contains(@placeholder,'Password')]

        //--- click on login button ---
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(.,' Login')]"));
        loginBtn.click();
    }

    public void typeTextBox(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
