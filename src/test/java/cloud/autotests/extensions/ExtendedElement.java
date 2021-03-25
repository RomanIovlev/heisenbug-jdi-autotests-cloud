package cloud.autotests.extensions;

import com.epam.jdi.light.elements.common.UIElement;
import org.openqa.selenium.By;

import static com.epam.jdi.light.elements.base.Conditions.visible;
import static org.openqa.selenium.By.cssSelector;

public class ExtendedElement extends UIElement {
    public static ExtendedElement $(String name) {
        return $(cssSelector("[data-testid='"+name+"']"));
    }
    public static ExtendedElement $(By by) {
        return new ExtendedElement(by);
    }

    public ExtendedElement(By by) {
        super(by);
    }
    public ExtendedElement fillAuthorizationForm(String login, String password) {
        shouldBe(visible);
        find("Login input").setValue(login);
        find("Password input").setValue(password);
        find("Remember me checkbox").click();
        find("Login button").click();
        return this;
    }
}
