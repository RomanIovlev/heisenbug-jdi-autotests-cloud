package cloud.autotests.entities;

public class Users{
    public static User DEFAULT_USER = new User().set(u -> {
        u.userName = "some_email@qa.guru"; u.password = "aAsd123#"; u.rememberMe = true;
    });
}
