import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {
    private static final String FIREFOX_WEBDRIVER = "webdriver.gecko.driver";
    private static final String CHROME_WEBDRIVER = "webdriver.chrome.driver";

    private static final String WINDOWS_CHROME_WEBDRIVER_PATH = "src/main/resources/chromedriver.exe";
    private static final String WINDOWS_FIREFOX_WEBDRIVER_PATH = "src/main/resources/geckodriver.exe";
    private static volatile WebDriver driver;

    private static void setSystemPropertiesFirefox(){
        System.setProperty(FIREFOX_WEBDRIVER, WINDOWS_FIREFOX_WEBDRIVER_PATH);
    }

    private static void setSystemPropertiesChrome(){
        System.setProperty(CHROME_WEBDRIVER, WINDOWS_CHROME_WEBDRIVER_PATH);
    }

    public static WebDriver openBrowser(){
        setSystemPropertiesFirefox();
        driver = new FirefoxDriver();
//        driver = new ChromeDriver();
        return driver;
    }

    public static void close() {
        if (driver != null) {
            driver.quit();
            driver = null;
        } else {
            System.out.println("Cant close session");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void printUrl() {
        System.out.println(driver.getCurrentUrl());
    }

   public static void waitUntilElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 250);
//       waitUntilElementClickable(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPage() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.wait(2);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static void waitForPage(Long sec) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.wait(2);
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void clickToLink(WebElement link) {
//        WebDriverHelper.waitUntilElementClickable(link);
        WebDriverHelper.waitUntilElementClickable(link);
        link.click();
    }

    public static void fillTheField(WebElement field, String value) {
        WebDriverHelper.waitUntilElementClickable(field);
//        field.click();
        field.clear();
        field.sendKeys(value);
    }

    public WebDriverHelper (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
