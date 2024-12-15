package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			/*createStudent(studentDAO);*/
			createMultipleStudents(studentDAO);
			/*readStudent(studentDAO);*/
			/*queryForStudents(studentDAO);*/
			/*queryForStudentsByLastName(studentDAO);*/
			/*updateStudent(studentDAO);*/
			/*deleteStudent(studentDAO);*/
			/*deleteAllStudents(studentDAO);*/
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+ numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// delete the student
		int studentId = 4;

		System.out.println("Deleting student id: "+studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve students based on the id: primary key
		int studentId = 4;

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student...");

		// change first name to "Scooby"
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		// display updated student
		System.out.println("Updated student: "+myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Tahmid");
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("Leo", "Das", "namo@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

		// retrieve based on the id:primary key
		System.out.println("retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("found the student: "+ myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("creating 3 student objects ...");
		Student tempStudent1 = new Student("Nafise", "Salime", "namo@gmail.com");
		Student tempStudent2 = new Student("Tasmia", "Tahmid", "ta@gmail.com");
		Student tempStudent3 = new Student("Courchite", "Fairos", "namo@gmail.com");

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("Namo", "Salime", "namo@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}


}
