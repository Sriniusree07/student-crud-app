package com.flm.service;

import java.util.List;
import com.flm.entity.Student;

public interface StudentService {
	
	boolean saveStudent(Student s);
	
	List<Student> getAllStudents();
	
	Student getStudentById(Integer id);
	
	boolean deleteStudent(Integer id);
}
