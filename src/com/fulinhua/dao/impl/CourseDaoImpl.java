package com.fulinhua.dao.impl;


import com.fulinhua.bean.Course;
import com.fulinhua.dao.CourseDao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by com.com.fulinhua on 2016/12/28.
 */
@Stateless
public class CourseDaoImpl implements CourseDao {
//    protected EntityManagerFactory factory=  Persistence.createEntityManagerFactory("jpa");

    @Override
    public ArrayList<Course> getCourseList() throws SQLException {

        EntityManagerFactory factory=  Persistence.createEntityManagerFactory("jpa");
   EntityManager  em=factory.createEntityManager();

        Query query = em.createQuery("select s from Course s");
        ArrayList<Course> list=new ArrayList<Course>();
         list = (ArrayList<Course>) query.getResultList();
        em.clear();//在处理大量实体的时候，如果不把已经处理过的实体从EntityManager中分离出来，将会消耗大量的内存；此方法分离内存中受管理的实体Bean，让VM进行垃圾回收
        return list;

    }

}
