package cloud.autotests.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static cloud.autotests.helpers.BrowserstackHelper.getBrowserstackUrl;
import static cloud.autotests.helpers.EnvironmentHelper.*;

public class CustomMobileDriver {
    private static DesiredCapabilities commonCapabilities() { // todo update for local drivers, now only browserstack
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "autotests.cloud");
        capabilities.setCapability("build", jobBaseName);
        capabilities.setCapability("name", "Tests - " + platform + " - " + buildNumber);
        capabilities.setCapability("autoGrantPermissions", "true");
        return capabilities;
    }

    public static AndroidDriver<?> AndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", androidDevice);
        capabilities.setCapability("os_version", androidVersion);
        capabilities.setCapability("app", androidBrowserstackApp);

        return new AndroidDriver<>(getBrowserstackUrl(), capabilities);
    }

    public static IOSDriver<?> IOSDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("device", iosDevice);
        capabilities.setCapability("os_version", iosVersion);
        capabilities.setCapability("autoAcceptAlerts", true);
        capabilities.setCapability("app", iosBrowserstackApp);

        return new IOSDriver<>(getBrowserstackUrl(), capabilities);
    }

}