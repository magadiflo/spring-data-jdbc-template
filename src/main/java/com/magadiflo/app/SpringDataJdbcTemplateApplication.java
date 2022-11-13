package com.magadiflo.app;

import com.magadiflo.app.dao.DAO;
import com.magadiflo.app.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataJdbcTemplateApplication {

    private static DAO<Course> dao;

    public SpringDataJdbcTemplateApplication(DAO<Course> dao) {
        this.dao = dao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcTemplateApplication.class, args);
        System.out.println("Create course ------------------------------------------------\n");
        Course springAngular = new Course("Spring Boot + Angular", "New Course", "https://www.magadiflo.dev/courses");
        dao.create(springAngular);


        System.out.println("All course ------------------------------------------------\n");

        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }

}
