package dto;

public class UserLogIn {
    private String username;
    private boolean login;

    public UserLogIn(String username, boolean login) {
        this.username = username;
        this.login = login;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLogin() {
        return login;
    }
}
