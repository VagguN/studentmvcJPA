package com.epam.StudentSpringMVCJPA.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.epam.StudentSpringMVCJPA.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao
{
	//ystem.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");
	EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("my-local-mysql");
	EntityManager eManager = emFactory.createEntityManager();
	
	
		@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		 TransactionMethod(eManager,student);
		 return student;
	}
		
	@Override	
	public Student getStudentId(int sid) {
		// TODO Auto-generated method stub
		Student student =eManager.find(Student.class, sid);
		return student;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		List <Student> students =eManager.createQuery("select st from  Student st").getResultList();
		return students;
	}

	@Override
	public void deleteStudentbyId(int sid) {
		// TODO Auto-generated method stub
		Student student =eManager.find(Student.class, sid);
		eManager.getTransaction().begin(); 
		 eManager.remove(student);
		 eManager.getTransaction().commit();
	}

	public void updateStudentbyId(Student stu) {
		// TODO Auto-generated method stub
		 eManager.getTransaction().begin(); 
		 eManager.merge(stu);
		 eManager.getTransaction().commit();

	}	
	private static void TransactionMethod(EntityManager eManager, Object object) {
		 eManager.getTransaction().begin(); 
		 eManager.persist(object);
		 eManager.getTransaction().commit();
	}
}