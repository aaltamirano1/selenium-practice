package com.myseleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angel-Altamirano\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //click 'multiple windows'.
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id='content']/ul/li/a[text()='Multiple Windows']")).click();

        //click 'click here'.
        driver.findElement(By.xpath("//div[@id='content']/div/a[text()='Click Here']")).click();

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> handles = ids.iterator();
        String parentId = handles.next();
        String childId = handles.next();


        // in the new window, capture 'New Window' text
        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());

        //then go back to the parent window and capture the 'opening a new window' text.
        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.cssSelector("div#content h3")).getText());

    }
}
