package day1selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;  // Import for Keys
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class GoogleSearchSimulation {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager

        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Google search page
            driver.get("https://www.google.com");

            // Locate the search box
            WebElement searchBox = driver.findElement(By.name("q"));

            // Create an instance of the Actions class
            Actions actions = new Actions(driver);

            // Type a query into the search box using the Actions class
            actions.click(searchBox)
                    .sendKeys("OpenAI")
                    .perform();

            // Wait for search suggestions to load
            Thread.sleep(2000);

            // Simulate arrow down to navigate through suggestions
            actions.sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ENTER)
                    .perform();

            // Additional wait to see the result
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
