package com.mariam.sprin_jdbc2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mariam.sprin_jdbc2.entity.Student;
import com.mariam.sprin_jdbc2.mapper.CustomResultSetExtractor;
import com.mariam.sprin_jdbc2.mapper.StudentRowMapper;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao{

	
	@Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	@Override
	public void insert(Student student) {
		
		String sql = "insert into student_details values(? ,? ,?)";
		Object[] args = {student.getId() , student.getName() , student.getAddress()};
		
		jdbcTemplate.update(sql,args);
		System.out.println("student saved successfully...");
	}

	//using custom RowMapper
	/*
	@Override
	public List<Student> findAllStudents() {

        String sql = "select * from student_details ";
        List<Student> students= jdbcTemplate.query(sql , new StudentRowMapper());
        
		return students;
	}
 */
	
     // using spring's BeanPropertyRowMapper BUT column's name in DB MUST be the property's name of java class
	
	@Override
	public List<Student> findAllStudents() {

        String sql = "select * from student_details ";
        List<Student> students= jdbcTemplate.query(sql , new BeanPropertyRowMapper<Student>(Student.class));
        
		return students;
	}
	
	// using spring's BeanPropertyRowMapper
	@Override
	public Student findById(int id) {
		
		String sql ="select * from student_details where id =?";
		Student student=  jdbcTemplate.queryForObject(sql, new  BeanPropertyRowMapper<Student>(Student.class), id);
		return student;
	}

	@Override
	public int updateStudent(Student student) {
		
		String sql = "update student_details set name=? , address =? where id=?";
		Object[]args = {student.getName() ,student.getAddress() , student.getId()};
		
		int NoOfUpdatedCol=  jdbcTemplate.update(sql, args);
		
		return NoOfUpdatedCol;
	}

	@Override
	public boolean deletStudentById(int id) {
		
		String sql ="delete from student_details where id=?";
		int NoOfUpdatedCol= jdbcTemplate.update(sql , id);
		return NoOfUpdatedCol == 1;
	}

	@Override
	public int deleteBynameOrAddress(String name, String address) {
		
		String sql = "DELETE FROM student_details WHERE  name=? OR address=?";
		Object[] args= {name , address};
		
		int NoOfDeletedCols =	jdbcTemplate.update(sql , args);
		
	     System.out.println("No of deleted rows is : "+ NoOfDeletedCols);

		
		return NoOfDeletedCols;
	}

	@Override
	public void insert(List<Student> students) {
		
		List<Object[]> argsList = new ArrayList<>();
		
		String sql = "insert into student_details values(? ,? ,?)";
		
		for (Student student : students) {
			
			Object[] args = {student.getId() , student.getName() , student.getAddress()};
			argsList.add(args);
		}
		
	   jdbcTemplate.batchUpdate(sql, argsList);
	   
	   System.out.println(" batch of rows are  inserted successfully ....");
		
	}

	@Override
	public List<Student> findStudentsByName(String name) {
		
		String sql ="select * from student_details where name =?";
	 List<Student> students=	jdbcTemplate.query(sql, new CustomResultSetExtractor() , name);
		
		System.out.println(students);
		
		return students;
	}
	
	//using custom RowMapper
	/*
	@Override
	public Student findById(int id) {
		
		String sql ="select * from student_details where id =?";
		Student student=  jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}
	*/

}
