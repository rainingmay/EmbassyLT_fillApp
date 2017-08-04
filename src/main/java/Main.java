import java.io.IOException;

public class Main {
    private static String baseUrl = "http://ua.mfa.lt/ua/ua/rovochij-chas";

    private static WebDriverHelper browser;
//    private static String s = "LookAt";

////    @FindBy(linkText = "https://konsregua.urm.lt/en/visit/")
////    private static WebElement linkToAsign;
//
//    @FindBy(linkText = "Як нас знайти")
//    private static WebElement linkToAsign;
//
//    @FindBy(xpath= "//a[contains( text(),'електронним записо')]")
//    private static WebElement linkToAsign1;
//
//
//
//    @FindBy(linkText = "pro-nas/posol-jstbo")
//    private static WebElement linkToAsi;
//
//
////    @FindBy(css="a:contains('електронним записом')")
////    private static WebElement linkToAsign2;
//
//
//    @FindBy(linkText = "register/ua1/Nacionalines_vizos_Ukraina_idarbinami_asmenys")
//    private static WebElement secondLinkToAsign;

    public static void main(String[] args) throws InterruptedException, IOException {
//        WebDriverHelper.openBrowser();
//        WebDriverHelper browser = new WebDriverHelper(WebDriverHelper.getDriver());
        browser = new WebDriverHelper(WebDriverHelper.openBrowser());
//        WebDriverHelper.getDriver().get(baseUrl);

        browser.getDriver().get(baseUrl);
        WebDriverHelper.waitForPage(4L);
        WebDriverHelper.clickToLinkFromWebElement(WebDriverHelper.linkToAsign);
//        WebDriverHelper.clickToLink(WebDriverHelper.linkToAsign2);
        WebDriverHelper.clickToLink(WebDriverHelper.secondLinkToAsign);
//        WebDriverHelper.clickToLinkFromWebElement(WebDriverHelper.secondLinkToAsign);
        ExcelHelper.methodFillApp();
    }
}
