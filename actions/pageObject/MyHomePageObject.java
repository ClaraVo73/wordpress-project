package pageObject;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyHomePageObject extends BasePage {
    private WebDriver driver;
    public MyHomePageObject(WebDriver driver){
        this.driver = driver;
    }
}
