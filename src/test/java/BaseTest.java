import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import framework.helpers.ReadPropertyUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private static final String RESOURCES_PATH = "src/main/resources/";
    private static final String NAME = "frame.properties";
    private static final String MAIN_URL = ReadPropertyUtil.getData("mainUrl", RESOURCES_PATH, NAME);

    @BeforeMethod
    protected void beforeMethod() {
        getBrowser().maximize();
        getBrowser().goTo(MAIN_URL);
    }

    @AfterMethod
    public void afterTest() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}