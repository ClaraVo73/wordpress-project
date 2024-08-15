package pageObject;

import adminUI.ViewPostPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class ViewPostPageObject extends BasePage {
    private WebDriver driver;
    public ViewPostPageObject(WebDriver driver){
        this.driver = driver;
    }

    public String getTitleOfNewPost() {
        waitForElementVisible(driver, ViewPostPageUI.POST_NAME_TITLE);
        return getElementText(driver, ViewPostPageUI.POST_NAME_TITLE);
    }

    public void clickOnMyHomeLink() {
        waitForElementClickable(driver, ViewPostPageUI.MY_HOME_LINK);
        clickToElement(driver, ViewPostPageUI.MY_HOME_LINK);
    }
}
