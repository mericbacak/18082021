package Base;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TemelSteps {
    public WebDriver driver;

    public TemelSteps() {
        {

            System.setProperty("webdriver.chrome.driver", "Driver/chromedriver92.exe");

            driver = new ChromeDriver();

            driver.manage().window().maximize();
        }
    }

    public enum Selectors {
        id,
        className,
        name,
        xPath,
        cssSelector,
        linkText
    }

    public enum TimeOut {
        AZ(5),
        FAZLA(15),
        AYARLANABILIR(60);
        private final int value;

        public int getValue() {
            return value;
        }
        // enum bu sayfaya ait olmalıdır
        private TimeOut(int value) {

            this.value = value;
        }

    }

    public void sayfayiAC() {
        driver.get("https://www.google.com/");

    }

    public void waitElement(WebElement element, TimeOut timeOut) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut.value);
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception ex) {

        }

    }

    public void findElementClick(String ifade, Selectors cins) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeOut.FAZLA.value);
            //bu adımda sistemin ağ kalitesine göre timeoutlar low, middle, high veya custox max (60sn) seçilebilir.
            switch (cins) {
                //bu switch case yapısı ile findelementclick methodunun farkl selector ile kullanımı sağlanmıştır.
                case className:
                    wait.until(ExpectedConditions.elementToBeClickable(By.className(ifade))).click();
                    break;
                case id:
                    wait.until(ExpectedConditions.elementToBeClickable(By.id(ifade))).click();
                    break;
                case name:
                    wait.until(ExpectedConditions.elementToBeClickable(By.name(ifade))).click();
                    break;
                case xPath:
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ifade))).click();
                    break;
                case cssSelector:
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ifade))).click();
                    break;
                case linkText:
                    wait.until(ExpectedConditions.elementToBeClickable(By.linkText(ifade))).click();
                    break;
                default:
                    new NotFoundException();
            }

        } catch (Exception ex) {
        }
    }

    public WebElement findElement(String ifade, Selectors cins, String description) {
    //Bu findElement methodunda selector description tutularak başka developerlarında element ve selector okumasını kolaylaştırma niyeti güdülmüştür,
        //method içindeki timeout Enum'a bağlı olup Middle seçilmiştir, internet kallitesine göre timeout değiştirilebilir.
        try {
            WebDriverWait wait = new WebDriverWait(driver, TimeOut.FAZLA.value);
            WebElement element = null;
            switch (cins) {
                case className:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(ifade)));
                    break;
                case id:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(ifade)));
                    break;
                case name:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(ifade)));
                    break;
                case xPath:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ifade)));
                    break;
                case cssSelector:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ifade)));
                    break;
                case linkText:
                    element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(ifade)));
                    break;
                default:
                    new NotFoundException();
            }
            return element;

        } catch (Exception ex) {
            System.out.println("Element bulunamadı " + ex.getMessage());
            return null;
        }
    }


    public void PageScrolldown() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,300)","");

    }

    public void PageScrollUP() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-300)","");

    }

    public void ScrollUntilElementVisible(String Selector) {
        //element görüntülenene kadar scrol mantığı
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement Element=driver.findElement(By.xpath(Selector));
        jse.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void VerifyPageTitle(String expected){
        String actual=driver.getTitle();
        Assert.assertEquals(expected,actual);
    }


    public void DriverQuit() {

        driver.quit();
    }
}