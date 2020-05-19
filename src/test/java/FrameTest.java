import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{

    @Test
    public void testIFrame() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.clearTextField();
        mainPage.sendRandomText();
        Assert.assertTrue(mainPage.isSendingStringOnTheScreen(), "There is not sending text on the screen");
        mainPage.selectTextField();
        mainPage.pressBButton();
        Assert.assertTrue(mainPage.isEnteredTextAreBold(), "Entered text is not bold");
    }
}
