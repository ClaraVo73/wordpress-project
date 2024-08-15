package pageObject;

import adminUI.BasePageUI;
import adminUI.DashboardPageUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage {
    private WebDriver driver;
    public DashboardPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void hoverOnPostsAtMenu(String menuName) {
        waitForElementClickable(driver, BasePageUI.ADMIN_MENU_LINK, menuName);
        hoverMouseToElement(driver, BasePageUI.ADMIN_MENU_LINK, menuName);
    }

    public void clickOnAddNewPostLink() {
        waitForElementClickable(driver, BasePageUI.ADD_NEW_POST_LINK);
        clickToElement(driver, BasePageUI.ADD_NEW_POST_LINK);
    }
}
