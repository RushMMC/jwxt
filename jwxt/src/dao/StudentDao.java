package dao;

import java.util.List;

import entity.Student;

/**
 * ѧ����DAO��ӿ�
 * @author AndrewLiu
 * @date 2021/06/21
 *
 */
public interface StudentDao {

	List<Student>FetchAllStudents();
	int AddStudent(Student stu);
	boolean DeleteStudent(int id);
	boolean UpdateStudent(Student stu);
	
}
