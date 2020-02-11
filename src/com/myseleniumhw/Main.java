package com.myseleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angel-Altamirano\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // identify 'Discount Coupons' column of links in the footer.
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        WebElement discCouponsColumn = footer.findElements(By.tagName("td")).get(0);

        // iterate over these links.
        List<WebElement> discCouponsLinks = discCouponsColumn.findElements(By.cssSelector("li>a"));
        for(int i = 0; i< ((List) discCouponsLinks).size(); i++){

            // open each link.
            String openLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
            //System.out.println((i+1)+". "+discCouponsLinks.get(i).getText()); //print a numbered list of the links opened.
            discCouponsLinks.get(i).sendKeys(openLink);
        }

        // get the title from each window/tab and print a numbered list of the titles.
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> handles = ids.iterator();
        int count = 1;
        while(handles.hasNext()){
            driver.switchTo().window(handles.next());
            System.out.println(count+". "+driver.getTitle());
            count++;
        }

    }
}
