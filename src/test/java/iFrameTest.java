import org.testng.Assert;
import org.testng.annotations.Test;

public class iFrameTest extends BaseTest{

    @Test
    public void TestIFrame() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.switchToFrame();
        mainPage.clearTextField();
        mainPage.sendRandomText();
        Assert.assertTrue(mainPage.isSendingStringOnTheScreen(), "There is not sending text on the screen");
        mainPage.selectTextField();
        mainPage.switchToMainPage();
        mainPage.pressBButton();
        Assert.assertTrue(mainPage.isEnteredTextAreBold(), "Entered text is not bold");
    }
}
