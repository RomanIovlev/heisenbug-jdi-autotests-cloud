package cloud.autotests.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static cloud.autotests.helpers.EnvironmentHelper.*;

public class CustomWebDriver {
    public static WebDriver WebDriver() {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        capabilities.setCapability("enableVideo", isVideoOn);

        // todo implement for other drivers - opera, firefox, safari
        capabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
        WebDriverManager.chromedriver().setup();

        return isRemoteDriver
            ? getRemoteWebDriver(capabilities)
            : getLocalChromeDriver(capabilities);
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

        if (isWebMobile) {
            Map<String, Object> mobileDevice = new HashMap<>();
            mobileDevice.put("deviceName", webMobileDevice);
            chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
        }
        chromeOptions.addArguments("--window-size=" + screenResolution);
        if(isHeadless) chromeOptions.addArguments("headless");

        return chromeOptions;
    }

    @SuppressWarnings("deprecation")
    private static WebDriver getLocalChromeDriver(DesiredCapabilities capabilities) {
        return new ChromeDriver(capabilities);
    }

    private static WebDriver getRemoteWebDriver(DesiredCapabilities capabilities) {
        RemoteWebDriver remoteWebDriver = new RemoteWebDriver(getRemoteWebDriverUrl(), capabilities);
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        return remoteWebDriver;
    }

    private static URL getRemoteWebDriverUrl() {
        try {
            return new URL(remoteDriverUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}