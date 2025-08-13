package com.mariam.sprin_jdbc2.dao;

import java.util.List;

import com.mariam.sprin_jdbc2.entity.Student;

public interface StudentDao {
	
	void insert(Student student);
	
	Student findById(int id);
	
	List<Student> findAllStudents();
	
	int updateStudent(Student student);
	
	boolean deletStudentById(int id);
	
	int deleteBynameOrAddress(String name , String address);
	
	void insert(List<Student> students);
	
	List<Student> findStudentsByName(String name);

}
