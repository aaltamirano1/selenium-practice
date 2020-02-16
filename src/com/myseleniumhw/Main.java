package com.myseleniumhw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Angel-Altamirano\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        // avoids timeout receiving message from renderer.
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        // random number generated.
        Random rand = new Random();
        int checkboxIndex = rand.nextInt(3);
        System.out.println("Option Number "+checkboxIndex+" generated.");

        // randomly click one of the checkboxes.
        WebElement randomCheckboxLabel = driver.findElements(By.xpath("//input[@type='checkbox']/parent::label")).get(checkboxIndex);
        String checkboxLabelText = randomCheckboxLabel.getText().trim();
        randomCheckboxLabel.findElement(By.tagName("input")).click();
        System.out.println("Checkbox with text '"+checkboxLabelText+"' clicked.");

        // click dropdown.
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        dropdown.click();
        System.out.println("Dropdown menu clicked.");

        // select a dropdown option with the same text as the checkbox label.
        WebElement dropdownOption = dropdown.findElement(By.xpath("//option[contains(text(),'"+checkboxLabelText+"')]"));
        dropdownOption.click();
        System.out.println("Selected dropdown option with text '"+dropdownOption.getText()+"'.");

        // type the checkbox label text inth the alert text field.
        driver.findElement(By.id("name")).sendKeys(checkboxLabelText);
        System.out.println("Typed '"+checkboxLabelText+"' into alert text input.");

        // click alert button.
        driver.findElement(By.id("alertbtn")).click();
        System.out.println("Alert button clicked.");

        // check if alert text contains the checkbox label text.
        String alertText = driver.switchTo().alert().getText();
        boolean alertContainsCheckboxLabelText = alertText.contains(checkboxLabelText);
        Assert.assertTrue(alertContainsCheckboxLabelText);
    }
}
