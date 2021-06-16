package dao;

import java.util.List;

import entity.Student;

public interface StudentDao {

	List<Student>FetchAllStudents();
	int AddStudent(Student stu);
	boolean DeleteStudent(int id);
	boolean UpdateStudent(int id);
	
	
}
