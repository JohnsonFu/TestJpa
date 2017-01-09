package com.fulinhua.dao.impl;

import com.fulinhua.dao.CourseDao;
import com.fulinhua.dao.StudentDao;

import java.sql.SQLException;

/**
 * Created by com.fulinhua on 2017/1/9.
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        CourseDao courseDao=new CourseDaoImpl();
  //     ArrayList<Course> list= courseDao.getCourseList();
//System.out.println(list.get(0).getName());
        StudentDao studentDao=new StudentDaoImpl();
        studentDao.QuitCourse(12);
       // System.out.println(l.getName());
    }
}
