package cloud.autotests.po;

import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;
import io.qameta.allure.Step;

import static cloud.autotests.QASite.loginPage;
import static cloud.autotests.entities.Users.DEFAULT_USER;

public class HomePage extends BasePage {
    @UI("Private content") JList<Text> privateContent;

    @Step("Verify successful authorization")
    public HomePage verifySuccessfulAuthorization() {
        loginPage.authorizationForm.is().disappear();
        headerLabel.has().text("Hello, " + DEFAULT_USER.userName + "!");
        privateContent
            .has().size(2)
            .and().values("Here is your private content #1",
            "and private content #2");
        return this;
    }
}
