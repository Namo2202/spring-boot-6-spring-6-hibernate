package com.spring.cruddemo;

import com.spring.cruddemo.dao.AppDAO;
import com.spring.cruddemo.entity.*;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourse(appDAO);
//			addMoreCOursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting student id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void addMoreCOursesForStudent(AppDAO appDAO) {
		int theId=3;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		Course tempCourse = new Course("Java");
		Course tempCourse2 = new Course("Python");
		tempStudent.addCourse(tempCourse);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Updating student: "+tempStudent);
		System.out.println("associated courses: "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("Done!");
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId=3;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("loaded student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId=10;
		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("loaded course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How To Score One Million Points");
		Student student = new Student("Leo", "Das", "leo@das.com");
		Student student2 = new Student("Namo", "JD", "JD@gmail.com");
		Student student3 = new Student("Tasmia", "Tahmid", "tasmia@tahmid.com");
		// add students to the course
		tempCourse.addStudent(student);
		tempCourse.addStudent(student2);
		tempCourse.addStudent(student3);
		// save the course and associated students
		System.out.println("Saving the course: "+ tempCourse);
		System.out.println("associated students: "+ tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Pacman - How to Score One Million Points");

		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course, job well done."));
		tempCourse.addReview(new Review("What a dumb course, uo are an idiot!"));

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deleting course id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;

		System.out.println("Finding course id: "+ theId);
		Course tempCourse = appDAO.findCourseById(theId);

		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Python");

		appDAO.updateCourse(tempCourse);

		System.out.println("Done !");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;

		System.out.println("Finding instructor id: "+ theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("Updating instructor id: "+theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("Done !");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done !");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId= 1;

		// find the instructor
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);

		// find courses for instructor
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done !");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done !");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Leo", "Das", "leo@das.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.google.com", "killing it");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create courses instances
		Course tempCourse1 = new Course("Java Spring Boot");
		Course tempCourse2 = new Course("JavaScript React");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//NOTE: this will also save the courses because of CascadeType.PERSIST
		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done !");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor detail id: "+ theId);

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructor: "+tempInstructorDetail);
		System.out.println("the associated instructorDetail only: "+tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done !");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Leo", "Das", "leo@das.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.google.com", "killing it");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
