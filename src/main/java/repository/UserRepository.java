package repository;

import dto.UserSaveDto;
import util.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    public String save(UserSaveDto dto) {
        try {
            return doSave(dto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String doSave(UserSaveDto dto) throws SQLException {
        String sql = "insert into t_user (username , nationalCode , birthday , password) values (?,?,?,?)";
        PreparedStatement statement = Application.getConnection().prepareStatement(sql);
        statement.setString(1, dto.getUserName());
        statement.setString(2, dto.getNationalCode());
        statement.setDate(3, new java.sql.Date(dto.getBirthDay().getTime()));
        statement.setString(4, dto.getNationalCode());
        int i = statement.executeUpdate();
        return "registration was successful" +
                "\n by default , your national code was registered on the password .if you wish , change your password after logging in ";
    }

    public boolean checkPassword(String username , String password) throws SQLException {
        String sql="select id from t_user where username=? and password=?";
        PreparedStatement statement=Application.getConnection().prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet resultSet=statement.executeQuery();
        if (resultSet.next()){
            return true;
        }
        return false;
    }
    public int getIdByUsername(String name) throws SQLException {
        int userId = 0;
        String sql="select id from t_user where username=?";
        PreparedStatement statement=Application.getConnection().prepareStatement(sql);
        statement.setString(1,name);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
          userId=  resultSet.getInt("id");
        }
        return userId;
    }

    public void savedNewPassword(int id , String newPass) throws SQLException {
        String sql="update t_user set password=? where id=?";
        PreparedStatement statement=Application.getConnection().prepareStatement(sql);
        statement.setString(1,newPass);
        statement.setInt(2,id);
        statement.executeUpdate();
        System.out.println("your new password is : "+newPass+"\n don't forget it! ");
    }
}
