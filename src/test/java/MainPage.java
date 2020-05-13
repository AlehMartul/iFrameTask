import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import framework.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class MainPage extends BasePage {

    private aquality.selenium.browser.Browser browser = AqualityServices.getBrowser();
    private ITextBox textBox = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//body[@id='tinymce']"), "texBox");
    private IButton bButton = AqualityServices.getElementFactory()
            .getButton(By.xpath("//i[@class='mce-ico mce-i-bold']"), "bButton");
    private IButton strong = AqualityServices.getElementFactory()
            .getButton(By.xpath("//div[@id='mceu_29-1']"), "strong");
    private String frame = "mce_0_ifr";
    private int sizeOfRandomText = 5;
    private String sendingText;
    private String comparingString;
    private String boldText;

    public boolean isMainPageLoaded() {
        return isPageLoaded(bButton);
    }

    public void switchToFrame() {
        browser.getDriver().switchTo().frame(frame);
    }

    public void switchToMainPage() {
        browser.getDriver().switchTo().defaultContent();
    }

    public void clearTextField() {
        textBox.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
    }

    public void selectTextField() {
        textBox.sendKeys(Keys.CONTROL + "a");
    }

    public void pressBButton() {
        bButton.click();
    }

    private String randomText() {
        sendingText = StringUtils.getRandomText(sizeOfRandomText);
        return sendingText;
    }

    public void sendRandomText() {
        textBox.sendKeys(randomText());
    }

    private String stringForComparing() {
        comparingString = textBox.getText();
        return comparingString;
    }

    public boolean isSendingStringOnTheScreen() {
        return stringForComparing().equals(sendingText);
    }

    public boolean isEnteredTextAreBold() {
        return strong.state().waitForDisplayed();
    }
}
