package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getActions;
import static support.TestContext.getDriver;

public class ListHeroku extends Page {

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@style]/li//h4[@class='position-name']")
    private List<WebElement> positionsTitle;

    private WebElement acceptanceButton(int i) {
        return getDriver().findElement(By.xpath("//li[@id='" + (i + 1) + "']//i[@class='fa fa-check']"));
    }

    public void verifyLogin() {
        assertThat(logoutButton.isEnabled()).isTrue();
    }

    public void select(String position) {
        for (int i = 0; i < positionsTitle.size(); i++) {
            if (positionsTitle.get(i).getText().contains(position)) {
                positionsTitle.get(i).click();
                break;
            }
        }
    }

    public void verifyWithdraw(String position) {
        for (int i = 0; i < positionsTitle.size(); i++) {
            if (positionsTitle.get(i).getText().contains(position)) {
                getActions().moveToElement(positionsTitle.get(i));
                assertThat(acceptanceButton(i).isEnabled()).isTrue();
                break;
            }
        }
    }

}
