package com.spring.cruddemo;

import com.spring.cruddemo.dao.AppDAO;
import com.spring.cruddemo.entity.Instructor;
import com.spring.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			createInstructor(appDAO);
		};
	}

	private void createInstructor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstrucor = new Instructor("Leo", "Das", "leo@das.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.google.com", "Making chocolate coffee");

		// associate the objects
		tempInstrucor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: "+tempInstrucor);
		appDAO.save(tempInstrucor);

		System.out.println("Done!");
	}
}
