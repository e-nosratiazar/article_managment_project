package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Article {
    private int id;
    private String title;
    private String brief;
    private String content;
    private Date createDate;
    private boolean isPublished;
    private int user_id;
    List<Article> articles=new ArrayList<>();

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Article(String title, String brief, String content, Date createDate, int user_id) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.user_id = user_id;
    }
}
