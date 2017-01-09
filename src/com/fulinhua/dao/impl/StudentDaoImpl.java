package com.fulinhua.dao.impl;

import com.fulinhua.bean.Student;
import com.fulinhua.bean.StudentCourse;
import com.fulinhua.dao.BaseDao;
import com.fulinhua.dao.StudentDao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by com.com.fulinhua on 2016/12/12.
 */
@Stateless
public class StudentDaoImpl extends BaseDao implements StudentDao {

    protected EntityManagerFactory factory= Persistence.createEntityManagerFactory("jpa");

        public List<StudentCourse> getStudentList(long sid) throws SQLException {//获得学生选择的课
            List<StudentCourse> list=new ArrayList<StudentCourse>();


            EntityManager em=factory.createEntityManager();

            Query query = em.createQuery("select s from StudentCourse s where s.student.id=?");
            query.setParameter(1,sid);
            list = (ArrayList<StudentCourse>) query.getResultList();
            em.clear();//在处理大量实体的时候，如果不把已经处理过的实体从EntityManager中分离出来，将会消耗大量的内存；此方法分离内存中受管理的实体Bean，让VM进行垃圾回收
            return list;

        }

        public Student isExistStudent(long id, String password) throws SQLException {
//

            EntityManager em=factory.createEntityManager();

            Query query = em.createQuery("select s from Student s where s.id=? and s.password=?");
            query.setParameter(1,id);
            query.setParameter(2,password);
            List list=query.getResultList();
            if(list.size()==0){
                return null;
            }
            Student student = (Student) query.getResultList().get(0);
            em.clear();//在处理大量实体的时候，如果不把已经处理过的实体从EntityManager中分离出来，将会消耗大量的内存；此方法分离内存中受管理的实体Bean，让VM进行垃圾回收
            return student;
        }

    @Override
    public boolean QuitCourse(int id) {
//
        EntityManager em=factory.createEntityManager();


        em.getTransaction().begin();
        StudentCourse course = em.find(StudentCourse.class,id);
        em.remove(course);
        em.getTransaction().commit();
        em.close();
        return true;
    }


}
