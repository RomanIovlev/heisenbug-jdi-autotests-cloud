package cloud.autotests.tests.entities;

public class Users{
    public static LoginData DEFAULT_USER = new LoginData().set(u -> {
        u.loginInput = "some_email@qa.guru"; u.passwordInput = "aAsd123#";
    });
}
