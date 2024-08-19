package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Test1 {

    WebDriver driver;
    JavascriptExecutor js;

    Test1(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);

    }



    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(xpath = "//label[text()='Female']")
    WebElement genderFemale;

    @FindBy(id = "userNumber")
    WebElement userNumber;

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__month-select")
    WebElement monthDropdown;

    @FindBy(className = "react-datepicker__year-select")
    WebElement yearDropdown;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day') and text()='24']")
    WebElement day;

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    @FindBy(xpath = "//label[text()='Music']")
    WebElement musicCheckbox;

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    @FindBy(id = "react-select-3-input")
    WebElement state;

    @FindBy(id = "react-select-4-input")
    WebElement city;

    @FindBy(id = "submit")
    WebElement submitButton;

    // Methods to interact with the form fields
    public void setFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void setEmail(String email) {
        userEmail.sendKeys(email);
    }

    public void selectGender() {
        js.executeScript("arguments[0].click();", genderFemale);
    }

    public void setUserNumber(String number) {
        userNumber.sendKeys(number);
    }

    public void setDateOfBirth(String month, String year, String dayText) {
        js.executeScript("arguments[0].click();", dateOfBirthInput);
        new Select(monthDropdown).selectByVisibleText(month);
        new Select(yearDropdown).selectByVisibleText(year);
        js.executeScript("arguments[0].click();", driver.findElement(
                By.xpath("//div[contains(@class, 'react-datepicker__day') and text()='" + dayText + "']")));
    }

    public void setSubjects(String subject) {

        subjectsInput.sendKeys(subject);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void selectHobbies() {
        js.executeScript("arguments[0].click();", musicCheckbox);
    }

    public void uploadPicture(String filePath) {
        uploadPicture.sendKeys(filePath);
    }

    public void setAddress(String address) {
        currentAddress.sendKeys(address);
    }

    public void selectState(String stateName) {

        state.sendKeys(stateName);
        state.sendKeys(Keys.ENTER);
    }

    public void selectCity(String cityName) {

        city.sendKeys(cityName);
        city.sendKeys(Keys.ENTER);
    }

    public void submitForm() {
        js.executeScript("arguments[0].click();", submitButton);
    }

    public static void main(String[] args) {



        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");

        try {

            driver.get("https://demoqa.com/automation-practice-form");

            driver.manage().window().maximize();

            Test1 formPage = new Test1(driver);

            formPage.setFirstName("Riya");
            formPage.setLastName("Sharma");
            formPage.setEmail("riyasharma@gmail.com");
            formPage.selectGender();
            formPage.setUserNumber("7626945618");
            formPage.setDateOfBirth("Jan", "2002", "09");
            formPage.setSubjects("Science");
            formPage.selectHobbies();
            formPage.uploadPicture("C:\\Users\\Asus\\Pictures\\trip\\IMG_1417.jpg");
            formPage.setAddress("Ganga PG, Gurugram, Haryana");
            formPage.selectState("Haryana");
            formPage.selectCity("Panipat");
            formPage.submitForm();
            Thread.sleep(30000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }
    }


}