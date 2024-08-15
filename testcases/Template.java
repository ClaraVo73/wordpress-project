import commons.BaseTest;
import commons.PageGeneratorManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.AdminLoginPageObject;
import java.util.Random;

public class Template extends BaseTest {
    private AdminLoginPageObject adminLoginPage;
    private String emailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName){
        driver =  getBrowserDriver(browserName);
        adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
    }
    @Test
    public void TC_01() {

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
