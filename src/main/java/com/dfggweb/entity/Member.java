package com.dfggweb.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by jinyingfei on 2017/10/24.
 */
@Entity
@IdClass(MemberPK.class)
public class Member {
    private int id;
    private int uid;
    private String realName;
    private Byte sex;
    private Date birthday;
    private Integer loginCount;
    private Timestamp regTime;
    private Timestamp lastLoginTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "sex")
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "login_count")
    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Basic
    @Column(name = "reg_time")
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Basic
    @Column(name = "last_login_time")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (uid != member.uid) return false;
        if (realName != null ? !realName.equals(member.realName) : member.realName != null) return false;
        if (sex != null ? !sex.equals(member.sex) : member.sex != null) return false;
        if (birthday != null ? !birthday.equals(member.birthday) : member.birthday != null) return false;
        if (loginCount != null ? !loginCount.equals(member.loginCount) : member.loginCount != null) return false;
        if (regTime != null ? !regTime.equals(member.regTime) : member.regTime != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(member.lastLoginTime) : member.lastLoginTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + uid;
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (loginCount != null ? loginCount.hashCode() : 0);
        result = 31 * result + (regTime != null ? regTime.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        return result;
    }
}
