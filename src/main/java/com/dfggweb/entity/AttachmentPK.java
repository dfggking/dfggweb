package com.dfggweb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by jinyingfei on 2017/10/24.
 */
public class AttachmentPK implements Serializable {
    private int id;
    private int articleId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "article_id")
    @Id
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachmentPK that = (AttachmentPK) o;

        if (id != that.id) return false;
        if (articleId != that.articleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + articleId;
        return result;
    }
}
