package com.dfggweb.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by jinyingfei on 2017/10/24.
 */
@Entity
@IdClass(AttachmentPK.class)
public class Attachment {
    private int id;
    private int articleId;
    private String name;
    private String filePath;
    private Timestamp createTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "article_id")
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "file_path")
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (id != that.id) return false;
        if (articleId != that.articleId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (filePath != null ? !filePath.equals(that.filePath) : that.filePath != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + articleId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
