package cloud.autotests.tests;

import cloud.autotests.QASite;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;

import static com.epam.jdi.light.driver.WebDriverByUtils.NAME_TO_LOCATOR;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.logger.AllureLogger.infoStep;
import static java.lang.String.format;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    @BeforeAll
    @Step("Tests setup")
    public static void beforeAll() {
        NAME_TO_LOCATOR = name -> By.cssSelector(format("[data-testid='%s']", name));
        openSite(QASite.class);
    }

    @AfterEach
    public void afterEach() {
        infoStep();
    }
    @AfterAll
    public static void tearDown() {
        killAllSeleniumDrivers();
    }
}
