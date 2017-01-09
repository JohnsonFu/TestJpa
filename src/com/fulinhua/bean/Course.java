package com.fulinhua.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by com.com.fulinhua on 2016/12/11.
 */
@Entity
@Table(name="tb_course")
public class Course implements Serializable {
    public int getId () {
        return id;
    }

    public void setId ( int id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }
@Id
    private int id;
    private String name;
}
