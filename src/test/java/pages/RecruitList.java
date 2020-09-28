package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.*;

public class RecruitList extends Page {

    @FindBy(xpath = "//div[@class='row']")
    private WebElement positionsArea;

    private WebElement getRemovePositionButton(String jobTitle) {
        return getDriver().findElement(By.xpath("//div[@class='col-sm-12 col-md-4 col-lg-3']//h4[text()='" + jobTitle + "']/../../..//i[@class='fa fa-close']"));
    }

    private WebElement getPosition(String jobTitle) {
        return getDriver().findElement(By.xpath("//div[@class='col-sm-12 col-md-4 col-lg-3']//h4[text()='" + jobTitle + "']"));
    }

    public void removePosition(String name) {
        clickWithJS(getRemovePositionButton(name));
        //getActions().moveToElement(getDriver().findElement(By.xpath("//div[@class='col-sm-12 col-md-4 col-lg-3']//h4[text()='Principal Automation Engineer']"))).click();
    }

    public Boolean verifyExistence(String name) {
        return positionsArea.getText().contains(name);
    }

}
