import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Main {
    private static String baseUrl = "http://ua.mfa.lt/ua/ua/rovochij-chas";
//    private static String s = "LookAt";

    @FindBy(linkText = "https://konsregua.urm.lt/en/visit/")
    private static WebElement linkToAsign;

    @FindBy(linkText = "register/ua1/Nacionalines_vizos_Ukraina_idarbinami_asmenys")
    private static WebElement secondLinkToAsign;

    public static void main(String[] args) throws InterruptedException {

        WebDriverHelper.openBrowser();
//        WebDriverHelper baseUrl = new WebDriverHelper(WebDriverHelper.getDriver());
        WebDriverHelper.getDriver().get(baseUrl);
        WebDriverHelper.waitUntilElementClickable(linkToAsign);
        linkToAsign.click();
        WebDriverHelper.waitUntilElementClickable(secondLinkToAsign);
        secondLinkToAsign.click();
        WebDriverHelper.waitForPage();

    }
}
