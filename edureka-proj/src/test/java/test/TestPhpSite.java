package test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPhpSite {
  WebDriver driver;
  WebDriverWait wait;

  @Test
  public void openAndVerifySite() {
    driver.get("http://34.66.216.241:8081/");
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
        "*[id*='About']"))).click();
    assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By
        .cssSelector("*[id*='PID']"))).getText().contains("about"),
        "The page is not containing expected text");
  }

  @BeforeMethod
  public void beforeMethod() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
    driver.quit();
  }

}
