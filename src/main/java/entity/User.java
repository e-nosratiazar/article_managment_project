package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String username;
    private long nationalCode;
    private Date birthday;
    private String password;
    List<Article> articleListOfAnyUser=new ArrayList<>();

    public User(String username, long nationalCode, Date birthday, String password) {
        this.username = username;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.password = password;
    }
}
