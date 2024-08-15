package User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.*;

import java.util.Random;

public class Posts extends BaseTest {
    private AdminLoginPageObject adminLoginPage;
    private DashboardPageObject dashboardPage;
    private AddNewPostPageObject addNewPostPage;
    private ViewPostPageObject viewPostPage;
    private MyHomePageObject myHomePage;
    private String titlePost;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver =  getBrowserDriver(browserName);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
        adminLoginPage.loginAdminPage();
        dashboardPage = PageGeneratorManager.getDashboardPage(driver);
        dashboardPage.sleepInSecond(2);

        titlePost = "Create a new post";
    }
    @Test
    public void TC_01_Create_Post() {
        dashboardPage.hoverOnPostsAtMenu("Posts");
        dashboardPage.clickOnAddNewPostLink();
        addNewPostPage = PageGeneratorManager.getAddNewPage(driver);
        addNewPostPage.sleepInSecond(2);
        addNewPostPage.inputToTitleTextbox(titlePost);
        addNewPostPage.clickOnPublishButton();
        addNewPostPage.clickOnPublishButton();
        verifyEquals(addNewPostPage.getAddNewSuccessMessage(),"Post published!");
        addNewPostPage.clickOnViewPostAtPopup();
        viewPostPage = PageGeneratorManager.getViewPostPage(driver);
        verifyEquals(viewPostPage.getTitleOfNewPost(),titlePost);
        viewPostPage.sleepInSecond(3);
        viewPostPage.clickOnMyHomeLink();
        myHomePage = PageGeneratorManager.getMyHomePage(driver);
        myHomePage.sleepInSecond(3);
    }
    @Test
    public void TC_02_Edit_Post() {

    }

    @Test
    public void TC_03_Search_Post() {

    }
    @Test
    public void TC_04_Delete_Post() {

    }

    @AfterClass
    public void afterClass() {
       driver.quit();
    }

public int numberRandom(){
    Random rand = new Random();
    return rand.nextInt(99999);
}


}
