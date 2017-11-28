package com.dfggweb.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by jinyingfei on 2017/10/24.
 */
@Entity
public class Article {
    private int id;
    private int uid;
    private String title;
    private String content;
    private String imgName;
    private String keyword;
    private Integer viewCount;
    private Integer visitCount;
    private Timestamp createTime;
    private Timestamp updateTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "img_name")
    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Basic
    @Column(name = "keyword")
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Basic
    @Column(name = "view_count")
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    @Basic
    @Column(name = "visit_count")
    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (uid != article.uid) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (imgName != null ? !imgName.equals(article.imgName) : article.imgName != null) return false;
        if (keyword != null ? !keyword.equals(article.keyword) : article.keyword != null) return false;
        if (viewCount != null ? !viewCount.equals(article.viewCount) : article.viewCount != null) return false;
        if (visitCount != null ? !visitCount.equals(article.visitCount) : article.visitCount != null) return false;
        if (createTime != null ? !createTime.equals(article.createTime) : article.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(article.updateTime) : article.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + uid;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (imgName != null ? imgName.hashCode() : 0);
        result = 31 * result + (keyword != null ? keyword.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (visitCount != null ? visitCount.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
