package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StudentDao;
import com.app.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		students = studentDao.findAll();
		return students;
	}

	@Override
	public String addNewStudent(Student stud) {
		// TODO Auto-generated method stub
		Student s = studentDao.save(stud);
		if(s != null) {
			return "Record Added Succesfully";
		}else {
			return "Something went wrong";
		}
	}

	@Override
	public String updateRecord(Student stud, Long id) {
		// TODO Auto-generated method stub
		Student student = studentDao.findById(id).orElseThrow();
		if(student == null) {
			return "Student not found";
		}
		student.setName(stud.getName());
		student.setAddress(stud.getAddress());
		student.setBirthDate(stud.getBirthDate());
		student.setEmail(stud.getEmail());
		student.setMobileNo(stud.getMobileNo());
		studentDao.save(student);
		return "Details updated succesfully";
	}

	@Override
	public String deleteStud(Long id) {
		// TODO Auto-generated method stub
		Student s = studentDao.findById(id).orElseThrow();
		if(s == null) {
			return "Student with id " + id+ " not found";
		}else {
			studentDao.deleteById(id);
		}
		return "Record deleted succesfully";
	}

}
