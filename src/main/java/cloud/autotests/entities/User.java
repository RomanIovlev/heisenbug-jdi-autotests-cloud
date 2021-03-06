package cloud.autotests.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public String userName;
    public String password;
    public boolean rememberMe;
}
