package com.jnit.main;

import com.jnit.dao.AuthorMain;
import com.jnit.dao.CourseTopic;
import com.jnit.dao.EmployeeAddress;
import com.jnit.dao.ProfessorMain;
import com.jnit.dao.StudentMain;
import com.jnit.dao.UserCourse;

public class DeletionMain {

	public static void main(String[] args) {
		CourseTopic.deleteCourseTopics();
		UserCourse.deleteUsers();
		EmployeeAddress.deleteEmployee();
		StudentMain.deleteStudent();
		AuthorMain.deleteAuthorCourses();
		ProfessorMain.deleteClasses();

	}

}
