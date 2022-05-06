package co.pragra.learning.databaselearning;

import co.pragra.learning.databaselearning.conf.AppConfig;
import co.pragra.learning.databaselearning.dao.CourseDAO;
import co.pragra.learning.databaselearning.dao.StudentDAO;
import co.pragra.learning.databaselearning.domain.Course;
import co.pragra.learning.databaselearning.domain.Student;
import co.pragra.learning.databaselearning.mapper.StudentMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.Instant;
import java.util.Collections;
import java.util.Random;

@SpringBootApplication
public class DatabaseLearningApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DatabaseLearningApplication.class, args);
		StudentDAO dao = context.getBean(StudentDAO.class);
		Student student = Student.builder().id(1).firstName("Shintu").lastName("Sebastian").createDate(Instant.now()).updateDate(Instant.now()).build();
		Student student2 = Student.builder().id(2).firstName("Shilpa").lastName("Rane").createDate(Instant.now()).updateDate(Instant.now()).build();
		dao.createStudent(student);
		dao.createStudent(student2);
		System.out.println(dao.getAllStudent());
		System.out.println(dao.getbyId(2));
		System.out.println(dao.updateFirstName("SHINTU", 1));
//		dao.updateStudent(student);
		//ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);// it is not a good practice
		//to pass all the classes to the configuration. So, instead we can pass the base package.
//		ApplicationContext context=new AnnotationConfigApplicationContext();
//		System.out.println(context.getBean(CourseDAO.class));


		CourseDAO bean = context.getBean(CourseDAO.class);

		Course course1 = Course.builder().id(1).courseName("Java").courseFee(1895.89D).createDate(Instant.now()).updateDate(Instant.now()).build();
		Course course2 = Course.builder().id(2).courseName("QA").courseFee(839.83D).createDate(Instant.now()).updateDate(Instant.now()).build();
		bean.createCourse(course1);
		bean.createCourse(course2);
		System.out.println(bean.getAllCourse());
		System.out.println("my changes");


	}

}
