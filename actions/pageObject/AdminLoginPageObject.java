package pageObject;

import adminUI.AdminLoginPageUI;
import commons.BasePage;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;

public class AdminLoginPageObject extends BasePage {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnContinueButton() {
        waitForElementClickable(driver, AdminLoginPageUI.CONTINUE_BUTTON);
        clickToElement(driver, AdminLoginPageUI.CONTINUE_BUTTON);
    }
    public void clickOnLoginButton() {
        waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
    }

    public String getTextErrorMessage() {
        waitForElementVisible(driver, AdminLoginPageUI.ERROR_MESSAGE);
        return getElementText(driver, AdminLoginPageUI.ERROR_MESSAGE);
    }

    public void inputUserNameTextbox(String emailAddress) {
        waitForElementVisible(driver, AdminLoginPageUI.USER_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.USER_TEXTBOX, emailAddress);
    }

    public void inputPasswordTextbox(String password) {
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public void loginAdminPage() {
        inputUserNameTextbox(GlobalConstants.USER_NAME);
        clickOnContinueButton();
        inputPasswordTextbox(GlobalConstants.PASSWORD);
        clickOnLoginButton();
    }



}
