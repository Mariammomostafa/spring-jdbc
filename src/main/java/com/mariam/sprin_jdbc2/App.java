package com.mariam.sprin_jdbc2;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mariam.sprin_jdbc2.dao.StudentDaoImpl;
import com.mariam.sprin_jdbc2.entity.Student;
import com.mariam.sprin_jdbc2.entity.StudentDaoHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext container= new ClassPathXmlApplicationContext("beans.xml");
        StudentDaoImpl studentDaoImpl= container.getBean("studentDao",StudentDaoImpl.class);
        
        //Student student = new Student(6 ,"asmaa" , "cairo");
        //studentDaoImpl.insert(student);
        
        System.out.println("*******************************");

        List<Student> students = studentDaoImpl.findAllStudents();
        
        for (Student s : students) {
        	
            System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAddress());
		}
        
        System.out.println("*******************************");
       /* 
       Student s = studentDaoImpl.findById(3);
       System.out.println(s);
        
        System.out.println("*******************************");
        
       s.setName("maha ali");
       s.setAddress("cairo");
        
        int NoOfUpdatedColumn = studentDaoImpl.updateStudent(s);
        
        if(NoOfUpdatedColumn == 1) {
        	
            System.out.println("student NO " + s.getId() +" is updated successfully...");

        }
        
        System.out.println("*******************************");
/*
        boolean deleted = studentDaoImpl.deletStudentById(12);
        if(deleted) {
        	System.out.println(" student deleted successfully... ");
        }
        
       
       
       System.out.println("*******************************");

       StudentDaoHelper studentDaohelper = container.getBean("studentDaoHelper",StudentDaoHelper.class);
        
       studentDaohelper.setStudentTable();
  */     
       System.out.println("*******************************");
       
     List<Student> students2=  studentDaoImpl.findStudentsByName("ganna");
       
     for (Student s : students2) {
     	
         System.out.println(s.getId() + " - " + s.getName() + " - " + s.getAddress());
		}
        
        
    }
}
