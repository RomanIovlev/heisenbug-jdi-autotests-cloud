package cloud.autotests.po;


import cloud.autotests.entities.User;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.MapToField;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class LoginForm extends Form<User> {
    @UI("Login input") @MapToField("userName")
    TextField loginInput;
    @UI("Password input") @MapToField("password")
    TextField passwordInput;
    @UI("Remember me checkbox")
    Checkbox rememberMe;
    @UI("Login button") Button loginButton;
}
