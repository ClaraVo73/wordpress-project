package commons;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageGeneratorManager {
    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }
    public static DashboardPageObject getDashboardPage(WebDriver driver){
        return new DashboardPageObject(driver);
    }
    public static AddNewPostPageObject getAddNewPage(WebDriver driver){
        return new AddNewPostPageObject(driver);
    }
    public static ViewPostPageObject getViewPostPage(WebDriver driver){
        return new ViewPostPageObject(driver);
    }
    public static MyHomePageObject getMyHomePage(WebDriver driver){
        return new MyHomePageObject(driver);
    }
}
