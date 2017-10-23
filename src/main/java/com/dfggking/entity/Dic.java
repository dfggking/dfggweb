package com.dfggking.entity;
// Generated 2017-7-13 14:55:43 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Dic generated by hbm2java
 */
@Entity
@Table(name = "dic", catalog = "dfgg_db")
public class Dic implements java.io.Serializable{
    
    private String id;
    private String dicName;
    private String dicCode;
    private String dicValue;
    private String parentId;
    private String remark;
    private String sort;
    
    public Dic(){}
    
    public Dic(String id){
        this.id = id;
    }
    
    public Dic(String id, String dicName, String dicCode, String dicValue, String parentId, String remark, String sort){
        this.id = id;
        this.dicName = dicName;
        this.dicCode = dicCode;
        this.dicValue = dicValue;
        this.parentId = parentId;
        this.remark = remark;
        this.sort = sort;
    }
    
    @Id
    
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public String getId(){
        return this.id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    @Column(name = "dic_name", length = 50)
    public String getDicName(){
        return this.dicName;
    }
    
    public void setDicName(String dicName){
        this.dicName = dicName;
    }
    
    @Column(name = "dic_code", length = 50)
    public String getDicCode(){
        return this.dicCode;
    }
    
    public void setDicCode(String dicCode){
        this.dicCode = dicCode;
    }
    
    @Column(name = "dic_value", length = 500)
    public String getDicValue(){
        return this.dicValue;
    }
    
    public void setDicValue(String dicValue){
        this.dicValue = dicValue;
    }
    
    @Column(name = "parent_id", length = 11)
    public String getParentId(){
        return this.parentId;
    }
    
    public void setParentId(String parentId){
        this.parentId = parentId;
    }
    
    @Column(name = "remark")
    public String getRemark(){
        return this.remark;
    }
    
    public void setRemark(String remark){
        this.remark = remark;
    }
    
    @Column(name = "sort", length = 4)
    public String getSort(){
        return this.sort;
    }
    
    public void setSort(String sort){
        this.sort = sort;
    }
    
}
