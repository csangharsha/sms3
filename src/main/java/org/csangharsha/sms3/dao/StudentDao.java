package org.csangharsha.sms3.dao;

import org.csangharsha.sms3.model.Student;

import java.util.List;

public interface StudentDao {

	List<Student> getAll();
	void save(Student student);
	Student getById(int id);
	void update(Student student);
	void delete(int id);

}
