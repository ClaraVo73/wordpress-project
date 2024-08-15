package pageObject;

import adminUI.AddNewPostPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddNewPostPageObject extends BasePage {
    private WebDriver driver;
    public AddNewPostPageObject(WebDriver driver){
        this.driver = driver ;
    }

    public void inputToTitleTextbox(String title) {
        switchToFrameIframe(driver, AddNewPostPageUI.POST_IFRAME);
        waitForElementPresenceAndVisible(driver, AddNewPostPageUI.TITLE_POST);
        clickToElement(driver, AddNewPostPageUI.TITLE_POST);
        sendKeyToElement(driver, AddNewPostPageUI.TITLE_TEXTBOX, title);
        switchToDefaultContents(driver);
    }

    public void clickOnPublishButton() {
        waitForElementClickable(driver, AddNewPostPageUI.PUBLISH_BUTTON);
        clickToElement(driver, AddNewPostPageUI.PUBLISH_BUTTON);
    }

    public String getAddNewSuccessMessage() {
        waitForElementVisible(driver, AddNewPostPageUI.ADD_NEW_SUCCESS_MESSAGE);
        return getElementText(driver, AddNewPostPageUI.ADD_NEW_SUCCESS_MESSAGE);
    }

    public void clickOnViewPostAtPopup() {
        waitForElementClickable(driver, AddNewPostPageUI.VIEW_POST_AT_POPUP_LINK);
        clickToElement(driver, AddNewPostPageUI.VIEW_POST_AT_POPUP_LINK);
        //switchToDefaultContents(driver);
    }
}
