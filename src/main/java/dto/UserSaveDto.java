package dto;

import java.util.Date;

public class UserSaveDto {
    private String userName;
    private String nationalCode;
    private Date birthDay;

    public UserSaveDto(String userName, String nationalCode, Date birthDay) {
        this.userName = userName;
        this.nationalCode = nationalCode;
        this.birthDay = birthDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
