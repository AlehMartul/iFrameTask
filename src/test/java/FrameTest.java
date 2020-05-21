import framework.utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest{

    private static final int SIZE_OF_RANDOM_TEXT = 5;
    private static final String RANDOM_TEXT = StringUtils.getRandomText(SIZE_OF_RANDOM_TEXT);

    @Test
    public void testIFrame() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isMainPageLoaded(), "Main page didn't load");
        mainPage.clearTextField();
        mainPage.sendText(RANDOM_TEXT);
        Assert.assertEquals(mainPage.isSendingStringOnTheScreen(RANDOM_TEXT), "There is not sending text on the screen");
        mainPage.selectTextField();
        mainPage.pressBButton();
        Assert.assertTrue(mainPage.isEnteredTextAreBold(), "Entered text is not bold");
    }
}
