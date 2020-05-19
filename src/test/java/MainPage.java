import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import framework.utils.FrameSwitchUtils;
import framework.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MainPage extends BasePage {

    private static final ITextBox TEXT_BOX = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//body[@id='tinymce']"), "texBox");
    private static final IButton B_BUTTON = AqualityServices.getElementFactory()
            .getButton(By.xpath("//i[@class='mce-ico mce-i-bold']"), "bButton");
    private static final IButton STRONG = AqualityServices.getElementFactory()
            .getButton(By.xpath("//div[@id='mceu_29-1']"), "strong");
    private static final String FRAME = "mce_0_ifr";
    private final static String A = "a";
    private String randomText;
    private int sizeOfRandomText = 5;

    public MainPage() {
        super(By.xpath(String.valueOf(B_BUTTON)), "MainPage");
    }

    @Override
    public boolean isMainPageLoaded() {
        return B_BUTTON.state().waitForDisplayed();
    }

    public void clearTextField() {
        FrameSwitchUtils.switchToFrame(FRAME);
        TEXT_BOX.sendKeys(Keys.CONTROL + A + Keys.DELETE);
    }

    public void selectTextField() {
        TEXT_BOX.sendKeys(Keys.CONTROL + A);
    }

    public void pressBButton() {
        FrameSwitchUtils.switchToMainPage();
        B_BUTTON.click();
    }

    private String getRandomText() {
        return randomText = StringUtils.getRandomText(sizeOfRandomText);
    }

    public void sendRandomText() {
        TEXT_BOX.sendKeys(getRandomText());
    }

    private String getStringForComparing() {
        return TEXT_BOX.getText();
    }

    public boolean isSendingStringOnTheScreen() {
        return getStringForComparing().equals(randomText);
    }

    public boolean isEnteredTextAreBold() {
        return STRONG.state().waitForDisplayed();
    }
}
