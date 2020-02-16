package com.myseleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angel-Altamirano\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // avoids timeout receiving from renderer issue.
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        WebElement productTable = driver.findElement(By.id("product"));

        // print number of rows.
        System.out.println("Number of rows: "+productTable.findElements(By.tagName("tr")).size());

        // print number of columns.
        int columnsCount = productTable.findElement(By.tagName("tr")).findElements(By.tagName("th")).size();
        System.out.println("Number of columns: "+columnsCount);

        // second row of data.
        WebElement secondRowOfData = productTable.findElements(By.tagName("tr")).get(2);
        System.out.println("Getting second row data from Products table...");
        for(int i=0;i<columnsCount;i++){
            String columnName = productTable.findElement(By.tagName("tr")).findElements(By.tagName("th")).get(i).getText();
            String dataText = secondRowOfData.findElements(By.tagName("td")).get(i).getText();
            System.out.println(columnName+": "+dataText);
        }

        //that's all folks!
        driver.close();
    }
}
