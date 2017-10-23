package com.dfggking.entity;
// Generated 2017-7-13 14:55:43 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserExtend generated by hbm2java
 */
@Entity
@Table(name = "user_extend", catalog = "dfgg_db")
public class UserExtend implements java.io.Serializable{
    
    private String id;
    private User user;
    private Date birth;
    
    public UserExtend(){}
    
    public UserExtend(String id, User user){
        this.id = id;
        this.user = user;
    }
    
    public UserExtend(String id, User user, Date birth){
        this.id = id;
        this.user = user;
        this.birth = birth;
    }
    
    @Id
    
    @Column(name = "id", unique = true, nullable = false, length = 36)
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser(){
        return this.user;
    }
    
    public void setUser(User user){
        this.user = user;
    }
    
    @Temporal(TemporalType.TIME)
    @Column(name = "birth", length = 8)
    public Date getBirth(){
        return this.birth;
    }
    
    public void setBirth(Date birth){
        this.birth = birth;
    }
    
}