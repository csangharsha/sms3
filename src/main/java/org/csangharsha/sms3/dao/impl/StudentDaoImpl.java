package org.csangharsha.sms3.dao.impl;

import org.csangharsha.sms3.dao.StudentDao;
import org.csangharsha.sms3.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(){


	}

	public List<Student> getAll() {
		String sql = "SELECT * FROM students;";
		List<Student> students = jdbcTemplate.query(sql, (resultSet, i) -> getStudentFromResultSet(resultSet));

		return students;

	}

	public void save(Student student) {
		String sql = "INSERT INTO students (name, college) VALUES(?, ?);";
		jdbcTemplate.update(sql, student.getName(), student.getCollege());
	}

	public Student getById(int id) {
		String sql = "SELECT * FROM students WHERE id = ?;";
		Student s = jdbcTemplate.queryForObject(sql, (resultSet, i) -> getStudentFromResultSet(resultSet), id);
		return s;
	}

	public void update(Student student) {
		String sql = "UPDATE students SET name=?, college=? WHERE id=?;";
		jdbcTemplate.update(sql, student.getName(), student.getCollege(), student.getId());
	}

	public void delete(int id) {
		String sql = "DELETE FROM students WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}

	private Student getStudentFromResultSet(ResultSet resultSet) throws SQLException {
		Student s = new Student();
		s.setId(resultSet.getInt("id"));
		s.setName(resultSet.getString("name"));
		s.setCollege(resultSet.getString("college"));
		return s;
	}
}
