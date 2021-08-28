import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class StartSelenium {

    //before[ open www ]  --> test [ steps ] + Assert --> After [ logout ]
    // Before [open browser] --> test [open website] --> After [ close website + close browser ]

    WebDriver wd;


    @BeforeMethod
    public void precondition() {
        //open browser
        wd = new ChromeDriver();
    }

    @Test
    public void openContact() {
        //open website

        //does not save browser history
        //wd.get("https://contacts-app.tobbymarshall815.vercel.app/home");

        // does save browser history
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        WebElement element1 = wd.findElement(By.tagName("div"));

        //Collection of divs
        List<WebElement> list = wd.findElements(By.tagName("div"));
        System.out.println(list.size());

        WebElement div2 = list.get(1);

        //WebElement element2 = wd.findElement(By.id("root"));
        WebElement element2 = wd.findElement(By.cssSelector("#root"));

        WebElement element3 = wd.findElement(By.className("login_login__3EHKB"));
    }

    @Test
    public void loginTest() {
        //step 1 click on login button

        //WebElement loginA = wd.findElement(By.className("active"));
        WebElement loginA = wd.findElement(By.linkText("LOGIN"));
        loginA.click();

        //step 2 type email
        List<WebElement> listInputs = wd.findElements(By.tagName("input"));
        //WebElement emailTextBox = listInputs.get(0);

        WebElement emailTextBox = wd.findElement(By.cssSelector("[placeholder='Email']"));
        emailTextBox.click();
        emailTextBox.clear();
        emailTextBox.sendKeys("a1@b1.ru");

        //step 3 type password
        WebElement passwordTextBox = listInputs.get(1);
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys("AAbb3'$'");
        //step 4 click login button

        WebElement btnLogin = wd.findElement(By.tagName("button"));
        btnLogin.click();


    }

    @AfterMethod
    public void postCondition() {
        //close browser + close website

        //closes focused tab only
        //wd.close();

        //closes whole browser
        //wd.quit();
    }
}
