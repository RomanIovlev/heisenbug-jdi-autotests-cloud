package cloud.autotests.helpers;

import cloud.autotests.drivers.CustomMobileDriver;
import cloud.autotests.drivers.CustomWebDriver;
import com.epam.jdi.light.elements.common.UIElement;

import static cloud.autotests.helpers.EnvironmentHelper.platform;
import static com.epam.jdi.light.driver.WebDriverFactory.useDriver;
import static com.epam.jdi.light.elements.init.JDITalk.NAME_TO_ELEMENT;
import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static com.epam.jdi.tools.StringUtils.splitFirstCapital;
import static org.openqa.selenium.By.cssSelector;


public class DriverHelper {

    public static void configureJDI() {
        switch (platform) {
            case "web":
                useDriver(CustomWebDriver::WebDriver);
                break;
            case "ios":
                useDriver(CustomMobileDriver::IOSDriver);
                break;
            case "android":
                useDriver(CustomMobileDriver::AndroidDriver);
                break;
            default:
                throw new RuntimeException("Unknown driver type");
        }
        NAME_TO_ELEMENT = name -> new UIElement(cssSelector("[data-testid='"+name+"']")).setName(name);
        ELEMENT.name = field -> splitFirstCapital(field.getName());
    }
}