package User;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.AdminLoginPageObject;

import java.util.Random;

public class Login extends BaseTest {
    private AdminLoginPageObject adminLoginPage;
    private String emailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminLoginPage.sleepInSecond(2);
        emailAddress = "ngan" + numberRandom() + "@gmail.com";
    }

    @Test
    public void TC_01_Login_Empty_UserName() {
        adminLoginPage.clickOnContinueButton();
        verifyEquals(adminLoginPage.getTextErrorMessage(), "Please enter a username or email address.");
    }

    @Test
    public void TC_02_Not_Exist_UserName() {
        adminLoginPage.inputUserNameTextbox(emailAddress);
        adminLoginPage.clickOnContinueButton();
        verifyEquals(adminLoginPage.getTextErrorMessage(), "User does not exist. Would you like to create a new account?");
    }

    @Test
    public void TC_03_Invalid_Password() {
        adminLoginPage.inputUserNameTextbox(GlobalConstants.USER_NAME);
        adminLoginPage.clickOnContinueButton();
        adminLoginPage.inputPasswordTextbox("d*4YKn68TWGhquZA7sUm");
        adminLoginPage.clickOnLoginButton();
        verifyEquals(adminLoginPage.getTextErrorMessage(), "It seems you entered an incorrect password. Want to get a login link via email?");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public int numberRandom() {
        Random rand = new Random();
        return rand.nextInt(99999);
    }

}
