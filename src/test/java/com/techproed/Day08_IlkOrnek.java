package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day08_IlkOrnek {
    // neden burada tanımladık ?
   // çünkü, diğer merhodlardan da, yani tüm merhodlardan bu nesneye erişmek istiyoruz.
   // çünkü, findElement gibi methodları ister istemez test'lerin içerisnde kullanağız.
    static WebDriver driver;
@BeforeClass
    public static void JUnit() {

    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
 @Test
    public void test1(){
     // Google.com'a gideceğim.
     // Sayfanın title'na bakacağım. Google kelimesi geçiyorsa, testim başarılı.
    driver.get("https://google.com");


     try {
         Thread.sleep(3000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
 }

@Test
    public void test2(){
    driver.get("https://youtube.com");
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
@AfterClass
    public static void tearDown(){
    driver.quit();
}
}
