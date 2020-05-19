import org.openqa.selenium.By;

public abstract class BasePage {

    private By locator;
    private String pageName;

    protected BasePage(By locator, String pageName) {
        this.locator = locator;
        this.pageName = pageName;
    }

    public abstract boolean isMainPageLoaded();
}

