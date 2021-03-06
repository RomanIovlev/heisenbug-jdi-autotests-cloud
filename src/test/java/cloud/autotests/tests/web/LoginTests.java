package cloud.autotests.tests.web;

import cloud.autotests.entities.Users;
import cloud.autotests.tests.TestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.QASite.homePage;
import static cloud.autotests.QASite.loginPage;

@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("login")
class LoginTests extends TestBase {

    @Test
    @DisplayName("Successful login in Web app. Testid-strategy")
    void successfulLoginTest() {
        loginPage.goToLoginPage();
        loginPage.loginAs(Users.DEFAULT_USER);
        homePage.verifySuccessfulAuthorization();
    }
}
