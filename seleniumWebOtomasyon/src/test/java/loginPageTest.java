import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginPageTest {
    public WebDriver driver;
    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\asus\\IdeaProjects\\seleniumWebOtomasyon\\chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        //Assert.assertEquals(driver.getTitle(), "Google");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void loginPage(){

        WebElement login= driver.findElement(By.xpath("//*[@id='main-header']/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]"));
        login.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url1 = "https://www.gittigidiyor.com/uye-girisi";
        driver.get(url1);

        WebElement mailbox= driver.findElement(By.id("L-UserNameField"));
        mailbox.click();
        mailbox.sendKeys("Kendi mailinizi giriniz");  ////////// örnek: abc@gmail.com /////////

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("Kendi şifrenizi giriniz"); ///////// örnek:11111 //////////
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.id("gg-login-enter")).click();
    }
    @After
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.quit();
    }
}
