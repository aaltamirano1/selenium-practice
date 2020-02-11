package com.myseleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angel-Altamirano\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        //click on 'nested frames'
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

        //switch to frame context
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
        String text = driver.findElement(By.id("content")).getText();
        System.out.println(text);
    }
}
