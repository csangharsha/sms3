package org.csangharsha.sms3.controller;

import org.csangharsha.sms3.dao.StudentDao;
import org.csangharsha.sms3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping
	public List<Student> home() {
		return studentDao.getAll();
	}

	@RequestMapping("/{id}")
	public Student getById(@PathVariable("id") int id){
		return studentDao.getById(id);
	}

	@PostMapping
	public void add(@RequestBody Student s) {
		studentDao.save(s);
	}

	@PutMapping("/{id}")
	public void update(@RequestBody Student s, @PathVariable("id") int id) {
		if(s.getId() == 0) {
			s.setId(id);
		}
		studentDao.update(s);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id){
		studentDao.delete(id);
	}

}
