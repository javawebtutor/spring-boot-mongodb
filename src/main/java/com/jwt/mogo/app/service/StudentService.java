package com.jwt.mogo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jwt.mogo.app.entity.Student;
import com.jwt.mogo.app.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student getStudentById(String id) {
		return studentRepository.findById(id).get();
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "Student has been deleted.";
	}

	public List<Student> getStudentsByName(String name) {
		return studentRepository.findByName(name);
	}

	public Student studentsByNameAndMail(String name, String email) {
		return studentRepository.findByNameAndEmail(name, email);
	}

	public List<Student> studentByNameOrEmail(String name, String email) {
		return studentRepository.findByNameOrEmail(name, email);
	}

	public List<Student> getAllWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return studentRepository.findAll(pageable).getContent();
	}

	public List<Student> allWithSorting() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");

		return studentRepository.findAll(sort);
	}
	
	public List<Student> bySubjectName (String subName) {
		return studentRepository.findBySubjectsSubjectName(subName);
	}
	
	public List<Student> byDepartmentName (String deptName) {
		return studentRepository.findByDepartmentDepartmentName(deptName);
	}
	
	public List<Student> emailLike (String email) {
		return studentRepository.findByEmailIsLike(email);
	}
	
	public List<Student> nameStartsWith (String name) {
		return studentRepository.findByNameStartsWith(name);
	}

}
