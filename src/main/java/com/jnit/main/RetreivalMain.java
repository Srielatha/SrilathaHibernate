package com.jnit.main;

import java.util.List;
import com.jnit.entities.Course;
import com.jnit.entities.Employee;
import com.jnit.dao.CourseTopic;
import com.jnit.dao.EmployeeAddress;
import com.jnit.dao.UserCourse;
import com.jnit.dao.AuthorMain;
import com.jnit.dao.ProfessorMain;
import com.jnit.dao.StudentMain;

public class RetreivalMain {

	public static void main(String[] args) {

		CourseTopic.getCouserData();

		List<Course> courses1 = UserCourse.getCouserData();
		for (Course c1 : courses1)
			System.out.println(c1);

		List<Employee> employees = EmployeeAddress.getEmployeeData();
		for (Employee employee : employees) {
			System.out.println(employee);
		}

		EmployeeAddress.getEmployeeDataByFirstLetter("m%");

		EmployeeAddress.getEmployeeDataByName("mike");

		StudentMain.getStudentData();
		AuthorMain.getAuthorData();
		ProfessorMain.getClassesData();

	}

}
