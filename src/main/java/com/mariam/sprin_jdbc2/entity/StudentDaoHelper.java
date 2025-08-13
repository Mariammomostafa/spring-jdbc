package com.mariam.sprin_jdbc2.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mariam.sprin_jdbc2.dao.StudentDaoImpl;

@Service
public class StudentDaoHelper {
	
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	public void setStudentTable() {
		
		Student student1 = new Student(3,"ganna","fayoum");
		Student student2 = new Student(4,"somaa","fayoum");
		Student student3 = new Student(5,"doaa","cairo");
		Student student4 = new Student(6,"asmaa","cairo");
		Student student5 = new Student(7,"ahmed","alex");
		
		List<Student> students = new ArrayList<>();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
	

		studentDaoImpl.insert(students);
		
	}

}
