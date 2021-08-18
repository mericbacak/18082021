package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MySteps extends Selectors {
    WebDriver driver;

    @Given("^Open the chrome and launch the application.$")
    public void open_the_Firefox_and_launch_the_application()
    {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver92.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @When("^Search Halkbank and click link$")
    public void enter_the_Username_and_Password()
    {
        GsearchBox.sendKeys("HalkBank");
        GsearchButton.click();
    }

    @Then("^Verify page title and click web channel.$")
    public void Reset_the_credential()
    {

        String PageTitle= driver.getTitle();
        Assert.assertEquals("TÜRKİYE HALK BANKASI",PageTitle);
    }
}
