package com.jwt.mogo.app.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jwt.mogo.app.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	List<Student> findByName(String name);

	Student findByNameAndEmail(String name, String email);

	List<Student> findByNameOrEmail(String name, String email);

	List<Student> findBySubjectsSubjectName(String subjectName);

	List<Student> findByDepartmentDepartmentName(String departMentName);
	
    List<Student> findByEmailIsLike(String email);
    
    List<Student> findByNameStartsWith (String name);

}
