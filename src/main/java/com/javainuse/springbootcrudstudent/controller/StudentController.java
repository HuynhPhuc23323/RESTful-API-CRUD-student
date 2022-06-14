package com.javainuse.springbootcrudstudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.springbootcrudstudent.service.StudentServiceImpl;
import com.javainuse.springbootcrudstudent.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentServiceImpl.createStudent(student);
	}
	
	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studentServiceImpl.createStudents(students);
	}
	
	@GetMapping("/students")
	public List<Student> findAllStudent(){
		return studentServiceImpl.getStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student findStudentById(@PathVariable(value = "id") Long id) {
		return studentServiceImpl.getStudentById(id);
	}
	
	@GetMapping("/students/{name}")
	public List<Student> findStudentByName(@PathVariable(value = "name")String studentName) {
		return studentServiceImpl.getStudentsByName(studentName);
	}
	
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		return studentServiceImpl.updateStudent(student);
	}
	
	@DeleteMapping("/student/{id}")
	public List<Student> deleteStudent(@PathVariable(value = "id")Long id){			
		return studentServiceImpl.deleteStudent(id);
	}
}
