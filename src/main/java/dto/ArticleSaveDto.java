package dto;

import java.util.Date;

public class ArticleSaveDto {
    private String title;
    private String brief;
    private String content;
    private Date createDate;
    private boolean isPublished;
    private int user_id;

    public ArticleSaveDto(String title, String brief, String content, Date createDate, boolean isPublished, int user_id) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
        this.isPublished = isPublished;
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public String getBrief() {
        return brief;
    }

    public String getContent() {
        return content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public boolean isPublished() {
        return isPublished;
    }

    public int getUser_id() {
        return user_id;
    }
}
