package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {

    private WebDriver driver;
    private Test1 formsPage;

    @BeforeClass
    public void setUp() {
        System.out.println("Demo QA form(POM)");
//        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        formsPage = new Test1(driver);
    }

    @Test
    public void testFormSubmission() throws InterruptedException {
        formsPage.setFirstName("Riya");
        formsPage.setLastName("Sharma");
        formsPage.setEmail("riyasharma@gmail.com");
        formsPage.selectGender();
        formsPage.setUserNumber("7626978560");
//        formsPage.setDateOfBirth("June", "2003", "07");
        formsPage.setSubjects("Maths");
        formsPage.selectHobbies();
//        formsPage.uploadPicture("C:\\Users\\Asus\\Pictures\\trip\\IMG_1417.jpg");
        formsPage.setAddress(" PG, Gurugram, Haryana");
        formsPage.selectState("Haryana");
        formsPage.selectCity("Panipat");
        formsPage.submitForm();
        Thread.sleep(7000);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}