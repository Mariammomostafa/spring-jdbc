package com.mariam.sprin_jdbc2.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mariam.sprin_jdbc2.entity.Student;

public class CustomResultSetExtractor implements ResultSetExtractor<List<Student>>{

	
	
	@Override
	public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		System.out.println("extractData() called ...");
		List<Student> students = new ArrayList<>();
		
		while(rs.next()) {
			
		    Student student = new Student();
		    student.setId(rs.getInt("id"));
		    student.setName(rs.getString("name"));
		    student.setAddress(rs.getString("address"));
		    
		    students.add(student);
			
		}
		
		return students;
	}

}
