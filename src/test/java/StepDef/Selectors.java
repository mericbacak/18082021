package StepDef;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Selectors {
    @FindBy(how = How.NAME, using = "q")
    public WebElement GsearchBox;
    @FindBy(how = How.NAME, using = "btnK")
    public WebElement GsearchButton;
}
