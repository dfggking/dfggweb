package com.dfggking.entity;
// Generated 2017-7-13 14:55:43 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TestLog generated by hbm2java
 */
@Entity
@Table(name = "test_log", catalog = "dfgg_db")
public class TestLog implements java.io.Serializable{
    
    private String id;
    private Date time;
    private String name;
    
    public TestLog(){
    }
    
    public TestLog(String id){
        this.id = id;
    }
    
    public TestLog(String id, Date time, String name){
        this.id = id;
        this.time = time;
        this.name = name;
    }
    
    @Id
    
    @Column(name = "id", unique = true, nullable = false, length = 30)
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time", length = 19)
    public Date getTime(){
        return this.time;
    }
    
    public void setTime(Date time){
        this.time = time;
    }
    
    @Column(name = "name", length = 6)
    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
}
