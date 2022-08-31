package repository;

import dto.ArticleSaveDto;
import dto.UpdatArticleAbject;
import entity.Article;
import util.Application;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.print;

public class ArticleRepository {
    public String save(ArticleSaveDto articleSaveDto){
        try {
            return insertNewArticle(articleSaveDto);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String insertNewArticle(ArticleSaveDto articleSaveDto) throws SQLException {
        String sql = "insert into t_article (title , brief, contents, createdate,ispublished,user_id) values (?,?,?,?,?,?)";
        PreparedStatement statement= Application.getConnection().prepareStatement(sql);
        statement.setString(1,articleSaveDto.getTitle());
        statement.setString(2,articleSaveDto.getBrief());
        statement.setString(3,articleSaveDto.getContent());
        statement.setDate(4, new java.sql.Date(articleSaveDto.getCreateDate().getTime()));
        statement.setBoolean(5,articleSaveDto.isPublished());
        statement.setInt(6,articleSaveDto.getUser_id());
        int i = statement.executeUpdate();
        return "your article saved successful";
    }

    public void articleListOfUser(int id) throws SQLException {
        String sql="select * from t_article where user_id=?";
        PreparedStatement statement=Application.getConnection().prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet resultSet=statement.executeQuery();
        while (resultSet.next()){
        String title=resultSet.getString("title");
        String brief=resultSet.getString("brief");
            System.out.println("title: "+ title +"\n brief : "+ brief);
        }
    }

    public String updateArticle(String title , UpdatArticleAbject updatArticleAbject) throws SQLException {
        String sql="update t_article set title=? , brief=? , contents=? , createdate=?  where title=?";
        PreparedStatement statement=Application.getConnection().prepareStatement(sql);
        statement.setString(1,updatArticleAbject.getTitle());
        statement.setString(2,updatArticleAbject.getBrief());
        statement.setString(3,updatArticleAbject.getContent());
        statement.setDate(4, new java.sql.Date(updatArticleAbject.getCreateDate().getTime()));
        statement.setString(5,title);
        statement.executeUpdate();
        return "the update was done successfully";
    }

    public String updatePublished(String title , boolean isPublished) throws SQLException {
        String sql="update t_article set ispublished=? where title=? ";
        PreparedStatement statement=Application.getConnection().prepareStatement(sql);
        statement.setBoolean(1,isPublished);
        statement.setString(2,title);
        statement.executeUpdate();
        return "the update was done successfully";
    }

    public void showAllArticles() throws SQLException {
        String sql="select title , brief from t_article where ispublished=true";
        PreparedStatement statement=Application.getConnection().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            printArticles(resultSet);
        }
    }

    private void printArticles(ResultSet resultSet) throws SQLException {
        String title=resultSet.getString("title");
        String brief=resultSet.getString("brief");
        System.out.println("title : "+title);
        System.out.println("brief : "+brief);
        System.out.println();
    }
}
