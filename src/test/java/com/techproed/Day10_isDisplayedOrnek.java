package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day10_isDisplayedOrnek {
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){

    }
    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.bestbuy.com");
    }
    @After
    public void afterMethod(){
        driver.quit();
    }
    // titleTest => Sayfa başlığının "Best" içerdiğini(contains) doğrulayın
    @Test
    public void titleTest(){
        String sayfaBasligi = driver.getTitle();
        boolean bestKelimesiniIceriyorMu = sayfaBasligi.contains("Best"); // true ya da false
        Assert.assertTrue(bestKelimesiniIceriyorMu);
    }
    // logoTest => BestBuy logosunun görüntülenip görüntülenmediğini doğrulayın
    @Test
    public void logoTest(){
        //<img src="../bby_logo-a7e90594729ed2e119331378def6c97e.png"
        // class="logo" alt="Best Buy Logo" width="80">
        WebElement logo = driver.findElement(By.className("logo"));
        //By.xpath("//img[@class='logo']")
        boolean logoGorunuyorMu = logo.isDisplayed(); // true false
        Assert.assertTrue(logoGorunuyorMu);
    }
    // mexicoLinkTest => Linkin görüntülenip görüntülenmediğini doğrulayın
    @Test
    public void mexicoLinkTest(){
        // <a href="https://www.bestbuy.com.mx/">
        // <img src="https://www.bestbuy.com/~assets/bby/_intl/landing_page/images/maps/mexico.svg" alt="Mexico">
        // <h4>Mexico</h4>
        // </a>
        WebElement mexicoLinki = driver.findElement(By.partialLinkText("Mexico"));
        boolean linkGorunuyorMu = mexicoLinki.isDisplayed();
        Assert.assertTrue(linkGorunuyorMu);
    }


}


