package cloud.autotests.tests;

import cloud.autotests.QASite;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.logger.AllureLogger.infoStep;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    @BeforeAll
    @Step("Tests setup")
    public static void beforeAll() {
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
