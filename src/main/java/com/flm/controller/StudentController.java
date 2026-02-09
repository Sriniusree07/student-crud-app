package com.flm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flm.entity.Student;
import com.flm.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;
	
	public StudentController(StudentService service) {
		this.service = service;
	}

	// Load form
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("student", new Student());
		return mav;
	}

	// Save or update
	@PostMapping("/saveStudent")
	public ModelAndView handleSubmit(Student student) {

	    ModelAndView mav = new ModelAndView("index");

	    boolean issaved = service.saveStudent(student);

	    if (issaved)
	        mav.addObject("smsg", "Student saved");
	    else
	        mav.addObject("emsg", "Save failed");

	    mav.addObject("student", new Student());
	    return mav;
	}

	// View all students
	@GetMapping("/students")
	public ModelAndView getAllStudent() {
		List<Student> stulist = service.getAllStudents();
		ModelAndView mav = new ModelAndView("students");
		mav.addObject("students", stulist);
		return mav;
	}

	// Edit
	@GetMapping("/edit")
	public ModelAndView editStudent(Integer id) {
		Student student = service.getStudentById(id);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("student", student);
		return mav;
	}

	// Delete
	@GetMapping("/delete")
	public String deleteStudent(Integer id) {
		service.deleteStudent(id);
		return "redirect:/students";
	}
}
