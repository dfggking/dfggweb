package com.dfggweb.entity;

import javax.persistence.*;

/**
 * Created by jinyingfei on 2017/10/24.
 */
@Entity
@Table(name = "hit_counter", schema = "dfgg", catalog = "")
public class HitCounter {
    private int id;
    private int pageViews;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "page_views")
    public int getPageViews() {
        return pageViews;
    }

    public void setPageViews(int pageViews) {
        this.pageViews = pageViews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HitCounter that = (HitCounter) o;

        if (id != that.id) return false;
        if (pageViews != that.pageViews) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + pageViews;
        return result;
    }
}
