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

        System.out.println("One course ------------------------------------------------\n");
        Course course = dao.get(1).orElseThrow();
        System.out.println(course);

        System.out.println("Updated course ------------------------------------------------\n");
        springAngular.setDescription("Learn tobuild Angular apps that talk to Spring Boot");
        dao.updated(springAngular, 6);

        System.out.println("Delete course ------------------------------------------------\n");
        dao.delete(4);

        System.out.println("All courses ------------------------------------------------\n");
        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }

}
