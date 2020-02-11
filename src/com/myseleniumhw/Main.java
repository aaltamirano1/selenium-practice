package com.myseleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angel-Altamirano\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // one way to get all links in footer:
        //System.out.println(driver.findElements(By.cssSelector("div#gf-BIG a")).size());

        // other way to get all links in footer: (limiting webdriver scope)
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        int linkCount = footer.findElements(By.tagName("a")).size();
        System.out.println(linkCount);
        driver.close();
    }
}
