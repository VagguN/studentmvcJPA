package com.epam.StudentSpringMVCJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.StudentSpringMVCJPA.dao.StudentDaoImpl;
import com.epam.StudentSpringMVCJPA.model.Student;

@org.springframework.stereotype.Service
public class Service
{
	@Autowired    
	StudentDaoImpl studentDaoImpl;
		public Student createStudentProfile(Student student) {
		// TODO Auto-generated method stub
		studentDaoImpl.createStudent(student);
		return student;
	}

	
		public Student getStudentById(int sid) {
		// TODO Auto-generated method stub
			Student student=studentDaoImpl.getStudentId(sid);
		return student;
				
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students=studentDaoImpl.getStudents();
		return students;
	}

	public void deleteStudent(int sid) {
		// TODO Auto-generated method stub
		studentDaoImpl.deleteStudentbyId(sid);	
	}

	public void updateStudent(Student stu) {
		// TODO Auto-generated method stub
		studentDaoImpl.updateStudentbyId(stu);
			
		}	
}