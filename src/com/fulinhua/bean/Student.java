package com.fulinhua.bean;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by com.com.fulinhua on 2016/12/12.
 */
@Entity
@Table(name="tb_student")
public class Student implements Serializable {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
@Id
    private long id;
    private String name;
    private String password;
}
