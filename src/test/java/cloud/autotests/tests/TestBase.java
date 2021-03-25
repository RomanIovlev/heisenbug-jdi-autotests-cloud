package cloud.autotests.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import static cloud.autotests.helpers.DriverHelper.configureJDI;
import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.logger.AllureLogger.infoStep;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TestBase {

    @BeforeAll
    @Step("Tests setup")
    public static void beforeAll() {
        configureJDI();
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
