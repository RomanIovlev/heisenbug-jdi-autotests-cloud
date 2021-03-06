package cloud.autotests.tests.web;

import cloud.autotests.tests.TestBase;
import cloud.autotests.tests.entities.LoginData;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static cloud.autotests.tests.entities.Users.DEFAULT_USER;
import static com.epam.jdi.light.elements.base.Conditions.*;
import static com.epam.jdi.light.elements.composite.WebPage.openUrl;
import static com.epam.jdi.light.elements.init.JDITalk.form;
import static com.epam.jdi.light.elements.init.UIFactory.*;
import static io.qameta.allure.Allure.step;


@Feature("Selenide-appium web, iOS and Android tests")
@Story("Login tests. Web")
@Tag("web")
@Tag("login")
class LoginTests extends TestBase {

    @Test
    @DisplayName("Successful login in Web app. Testid-strategy")
    void successfulLoginTest() {
        step("Go to login page", ()-> {
            openUrl("http://autotests.cloud:3000/");
            $("Header label").should(have(text("Not authorized")));
        });

        step("Fill the authorization form", ()-> {
            $("Authorization form").shouldBe(visible);
            form(LoginData.class).fill(DEFAULT_USER);
            $("Remember me checkbox").check();
            $("Login button").click();
        });

        step("Verify successful authorization", ()-> {
            $("Authorization form").is().disappear();
            $("Header label").has().text("Hello, " + DEFAULT_USER.loginInput + "!");
            $$("Private content")
                .has().size(2)
                .and().values("Here is your private content #1",
                            "and private content #2");
        });
    }
}
