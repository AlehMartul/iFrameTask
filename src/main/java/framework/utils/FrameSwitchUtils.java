package framework.utils;

import aquality.selenium.browser.AqualityServices;

public class FrameSwitchUtils {

    public static void switchToFrame(String frame) {
        AqualityServices.getBrowser().getDriver().switchTo().frame(frame);
    }

    public static void switchToMainPage() {
        AqualityServices.getBrowser().getDriver().switchTo().defaultContent();
    }

}
