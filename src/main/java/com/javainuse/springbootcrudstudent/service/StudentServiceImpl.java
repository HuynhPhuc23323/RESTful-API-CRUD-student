package com.javainuse.springbootcrudstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.javainuse.springbootcrudstudent.entity.Student;
import com.javainuse.springbootcrudstudent.exception.ResourceNotFoundException;
import com.javainuse.springbootcrudstudent.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> createStudents(@RequestBody List<Student> students) {
		return studentRepository.saveAll(students);
	}
	
	//find all students with sort name
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(@PathVariable(value = "id")Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
	}

	@SuppressWarnings("null")
	public List<Student> getStudentsByName(String studentName) {
//		List<Student> students = studentRepository.findAll();
//		List<Student> newListStudents = null;
//		for (Student st : students) {
//			if(st.getStudentName().contains(studentName)) {
//				newListStudents.add(st);
//			}
//		}
//		return newListStudents;
		return studentRepository.findByStudentName(studentName);
	}
	
	public Student updateStudent(@RequestBody Student student) {
		Student updatingStudent = getStudentById(student.getId());
		updatingStudent.setStudentName(student.getStudentName());		
		return studentRepository.save(updatingStudent);
	}
	
	public List<Student> deleteStudent(@PathVariable(value = "id")Long id) {
		studentRepository.deleteById(id);
		return studentRepository.findAll();
	}	

	
}
