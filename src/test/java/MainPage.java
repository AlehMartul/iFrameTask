import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import framework.utils.FrameSwitchUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MainPage extends BasePage {

    private final ITextBox txtMainField = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//body[@id='tinymce']"), "texBox");
    private final IButton btnBold = AqualityServices.getElementFactory()
            .getButton(By.xpath(BOLD_BUTTON_XPATH), "bButton");
    private final IButton btnStrong = AqualityServices.getElementFactory()
            .getButton(By.xpath("//div[@id='mceu_29-1']"), "strong");
    private static final String FRAME = "mce_0_ifr";
    private static final String BOLD_BUTTON_XPATH = "//i[@class='mce-ico mce-i-bold']";
    private final static String A = "a";

    public MainPage() {
        super(By.xpath(BOLD_BUTTON_XPATH), "MainPage");
    }

    @Override
    public boolean isMainPageLoaded() {
        return btnBold.state().waitForDisplayed();
    }

    public void clearTextField() {
        FrameSwitchUtils.switchToFrame(FRAME);
        txtMainField.sendKeys(Keys.CONTROL + A + Keys.DELETE);
    }

    public void selectTextField() {
        txtMainField.sendKeys(Keys.CONTROL + A);
    }

    public void pressBButton() {
        FrameSwitchUtils.switchToMainPage();
        btnBold.click();
    }

    public void sendText(String text) {
        txtMainField.sendKeys(text);
    }

    private String getStringForComparing() {
        return txtMainField.getText();
    }

    public boolean isSendingStringOnTheScreen(String text) {
        return getStringForComparing().equals(text);
    }

    public boolean isEnteredTextAreBold() {
        return btnStrong.state().waitForDisplayed();
    }
}
