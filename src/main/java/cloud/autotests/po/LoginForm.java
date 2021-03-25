package cloud.autotests.po;

import cloud.autotests.entities.User;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.MapToField;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class LoginForm extends Form<User> {
    @MapToField("userName") TextField loginInput;
    @MapToField("password") TextField passwordInput;
    @MapToField("rememberMe") Checkbox rememberMeCheckbox;
    Button loginButton;
}
