package cloud.autotests.po;


import cloud.autotests.entities.User;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.qameta.allure.Step;

import static cloud.autotests.QASite.homePage;

public class LoginPage extends BasePage {
    @UI("Authorization form")
    public Label authorizationForm;
    LoginForm loginForm;

    @Step("Go to login page")
    public LoginPage goToLoginPage() {
        headerLabel.has().text("Not authorized");
        return this;
    }

    @Step("Login as {0}")
    public void loginAs(User user) {
        authorizationForm.is().visible();
        loginForm.loginAs(user);
    }
}
