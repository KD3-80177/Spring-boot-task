package com.app.service;

import java.util.List;

import com.app.entities.Student;

public interface StudentService {

	List<Student> getAllStudents();

	String addNewStudent(Student stud);

	String updateRecord(Student stud, Long id);

	String deleteStud(Long id);

}
