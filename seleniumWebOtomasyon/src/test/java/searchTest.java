import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchTest {
    public WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\asus\\IdeaProjects\\seleniumWebOtomasyon\\chromedriver.exe");

        //////////////////////// "https://www.gittigidiyor.com/" anasayfasının açılması /////////////////////
        driver = new ChromeDriver();
        String url = "https://www.gittigidiyor.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testSearch() {

        //////////////////////// 'Bilgisayar' ifadesinin aratılması ////////////////////////////
        WebElement searchBox = driver.findElement(By.tagName("input"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.tagName("button")).click();

        ////////////////////// Arama sonuç sayfalarında 2. sayfanın açılması //////////////////
        //driver.findElement(By.xpath(".//*[@id='best-match-right']/div[5]/ul/li[2]/a"));
        String url = "https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=Bilgisayar&sf=2");

        //////////////////// Rastgele bir ürünün seçilmesi ///////////////////////////////////
        driver.findElement(By.xpath("//*[@id='product_id_680233923']/a")).click();

        /*
        Çıkan ekrana göre aşağıdaki ürün kodlarından birini girin.
        product_id_680233923
        product_id_682191994
        product_id_619297476
        product_id_664242536
        */

        //////////////////// Seçilen ürünün sepete eklenmesi /////////////////////////////////
        WebElement buyButton = driver.findElement(By.id("add-to-basket"));
        buyButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        //////////////////// Sepete gidilmesi ////////////////////////////////////////////////
        WebElement basket = driver.findElement(By.className("header-cart-hidden-link"));
        basket.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        ////////////////// Ürünün sepetten silinmesi /////////////////////////
        driver.findElement(By.className("btn-delete btn-update-item")).click();
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        //driver.quit();
    }
}
