package com.fulinhua.dao;

import com.fulinhua.bean.Course;

import javax.ejb.Remote;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by com.com.fulinhua on 2016/12/28.
 */
@Remote
public interface CourseDao   {
    public ArrayList<Course> getCourseList() throws SQLException;
}
