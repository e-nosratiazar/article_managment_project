package dto;

import java.util.Date;

public class UpdatArticleAbject {
    private String title;
    private String brief;
    private String content;
    private Date createDate;

    public UpdatArticleAbject(String title, String brief, String content, Date createDate) {
        this.title = title;
        this.brief = brief;
        this.content = content;
        this.createDate = createDate;
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
}
