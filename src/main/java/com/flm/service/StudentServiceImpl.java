package com.flm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flm.entity.Student;
import com.flm.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository repo;
	
	public StudentServiceImpl(StudentRepository repo) {
		this.repo = repo;
	}

	@Override
	public boolean saveStudent(Student s) {
		Student savedstudent = repo.save(s);
		return savedstudent.getSid() != null;
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public boolean deleteStudent(Integer id) {
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
