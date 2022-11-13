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
        System.out.println("------------------------------------------------\n");

        List<Course> courses = dao.list();
        courses.forEach(System.out::println);
    }

}
