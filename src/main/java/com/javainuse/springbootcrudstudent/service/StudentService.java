package com.javainuse.springbootcrudstudent.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javainuse.springbootcrudstudent.entity.Student;

@Service
public interface StudentService {
	
	Student createStudent(@RequestBody Student student);
	List<Student> createStudents(@RequestBody List<Student> students);
	List<Student> getStudents();
	Student getStudentById(@PathVariable(value = "id")Long id);
	List<Student> getStudentsByName(String studentName);
	Student updateStudent(@RequestBody Student student);
	List<Student> deleteStudent(@PathVariable(value = "id")Long id);
}
