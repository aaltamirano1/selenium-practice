package com.myseleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angel-Altamirano\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        //switch to frame context
        WebElement iframe = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iframe);

        //inistantiate actions class.
        Actions doIt = new Actions(driver);

        //drag and drop element.
        WebElement draggableElement = driver.findElement(By.id("draggable"));
        WebElement dropPoint = driver.findElement(By.id("droppable"));
        doIt.dragAndDrop(draggableElement, dropPoint).build().perform();

    }
}
