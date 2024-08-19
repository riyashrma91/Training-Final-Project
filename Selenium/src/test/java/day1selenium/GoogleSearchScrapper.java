package day1selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;


public class GoogleSearchScrapper {
    public static void main(String[] args) {
        // Setup ChromeDriver (WebDriver Manager will handle the driver binary)
    
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Find the search input box by its name attribute and type a query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("example code for web scraping");
            searchBox.submit();

            // Wait for the search results to load (implicit wait)
            Thread.sleep(2000);  // Simple sleep for demonstration; replace with WebDriverWait in real code.

            // Example 1: Find code snippets using XPath
            List<WebElement> codeSnippetsUsingXPath = driver.findElements(By.xpath("//pre"));
            System.out.println("Code Snippets found using XPath:");
            for (WebElement codeSnippet : codeSnippetsUsingXPath) {
                System.out.println(codeSnippet.getText());
            }

            // Example 2: Find code snippets using CSS Selector
            List<WebElement> codeSnippetsUsingCSSSelector = driver.findElements(By.cssSelector("pre"));
            System.out.println("Code Snippets found using CSS Selector:");
            for (WebElement codeSnippet : codeSnippetsUsingCSSSelector) {
                System.out.println(codeSnippet.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
