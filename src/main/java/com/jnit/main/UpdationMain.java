package com.jnit.main;

import com.jnit.dao.CourseTopic;
import com.jnit.dao.EmployeeAddress;
import com.jnit.dao.UserCourse;
import com.jnit.dao.AuthorMain;
import com.jnit.dao.ProfessorMain;
import com.jnit.dao.StudentMain;

public class UpdationMain {

	public static void main(String[] args) {
		CourseTopic.updateCourseTopics();
		UserCourse.updateUsers();
		EmployeeAddress.updateEmployee();
		AuthorMain.updateAuthorCourses();
		StudentMain.updateStudent();
		ProfessorMain.updateClasses();

	}
}
