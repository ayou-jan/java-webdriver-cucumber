package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import support.Loggable;
import support.Screenshot;

import java.util.List;

import static support.TestContext.*;

public class RecruitList extends Page {

    @FindBy(xpath = "//div[@class='row']")
    private WebElement positionsArea;

    @FindBy(xpath = "//h4[contains(text(),'New Position')]")
    private WebElement addPosition;

    private WebElement getRemovePositionButton(String jobTitle) {
        return getDriver().findElement(By.xpath("//h4[text()='" + jobTitle + "']/../../..//i[@class='fa fa-close']"));
    }

    @FindBy(xpath = "//div[@class='row']")
    private List<WebElement> listOfPositions;

    private WebElement getPosition(String jobTitle) {
        return getDriver().findElement(By.xpath("//h4[text()='" + jobTitle + "']"));
    }

    public void removePosition(String name) {
        //clickWithJS(getRemovePositionButton(name));
        getActions().moveToElement(getPosition(name)).perform();
        getRemovePositionButton(name).click();
        getWait().until(ExpectedConditions.invisibilityOf(getPosition(name)));
    }

    public Boolean verifyExistence(String name) {
        return positionsArea.getText().contains(name);
    }

    public NewPosition goToNewPosition() {
        addPosition.click();
        takeScreenshot();
        return new NewPosition();
    }

    public void waitUpdatedList() {
        waitForVisible(listOfPositions.get(1));
    }

    public boolean checkPosition() throws InterruptedException {
        //Thread.sleep(2000);
        for (int i = 0; i < listOfPositions.size(); i++) {
            if (listOfPositions.get(i).getText().contains(getData("automation").get("Title"))) {
                return true;
            }
        }
        return false;
    }

}
