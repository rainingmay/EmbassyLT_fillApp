import org.apache.poi.ss.usermodel.Hyperlink;
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

    private static final String WINDOWS_CHROME_WEBDRIVER_PATH = "src/main/resources/chromedriver(2).exe";
    private static final String WINDOWS_FIREFOX_WEBDRIVER_PATH = "geckodriver.exe";
    private static volatile WebDriver driver;

    private static void setSystemPropertiesFirefox(){
        System.setProperty(FIREFOX_WEBDRIVER, WINDOWS_FIREFOX_WEBDRIVER_PATH);
    }

    private static void setSystemPropertiesChrome(){
        System.setProperty(CHROME_WEBDRIVER, WINDOWS_CHROME_WEBDRIVER_PATH);
    }

    public static WebDriver openBrowser(){
//        setSystemPropertiesFirefox();
//        driver = new FirefoxDriver();
        setSystemPropertiesChrome();
        driver = new ChromeDriver();
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
       WebDriverWait wait = new WebDriverWait(driver, 7);
//       waitUntilElementClickable(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForPage() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public static void waitForPage(Long sec) throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.wait(2);
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public static void clickToLink(WebElement link) {
        WebDriverHelper.waitUntilElementClickable(link);
        link.click();
    }

    public static void fillTheField(WebElement field, String value) {
        WebDriverHelper.waitUntilElementClickable(field);
//        field.click();
        field.clear();
        field.sendKeys(value);
    }

    public void elementsInitialisation() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath= "//a[contains( text(),'електронним записо')]")
    private static WebElement linkToAsign1;

    @FindBy(css = "a[href*=https://konsregua.urm.lt/en/visit]")
    static WebElement linkToAsign11111;


    @FindBy(id = "site-title")
    static WebElement linkToAsi;



    @FindBy(css="[href='https://konsregua.urm.lt/en/visit/'][target='_blank']")
    static WebElement linkToAsign;


    @FindBy(css = "[href='register/ua1/Nacionalines_vizos_Ukraina_idarbinami_asmenys']")
    static WebElement secondLinkToAsign;

    public WebDriverHelper (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

//    public static void printLinkFromWebElement(WebElement webElement) {
//        System.out.println(webElement.getText());
//    }

    public static void clickToLinkFromWebElement(WebElement webElement) {
        //
        System.out.println(webElement.getAttribute("href"));
        getDriver().get(webElement.getAttribute("href"));

    }
}
