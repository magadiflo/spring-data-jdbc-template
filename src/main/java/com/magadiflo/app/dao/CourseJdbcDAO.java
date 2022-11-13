package com.magadiflo.app.dao;

import com.magadiflo.app.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CourseJdbcDAO implements DAO<Course> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourseJdbcDAO.class);
    private final JdbcTemplate jdbcTemplate;

    RowMapper<Course> rowMapper = (resultSet, rowNumber) -> {
        Course course = new Course();
        course.setId(resultSet.getInt("id"));
        course.setTitle(resultSet.getString( "title"));
        course.setDescription(resultSet.getString("description"));
        course.setLink(resultSet.getString("link"));
        return course;
    };

    public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> list() {
        String sql = "SELECT id, title, description, link FROM course";
        return this.jdbcTemplate.query(sql, this.rowMapper);
    }

    @Override
    public void create(Course course) {

    }

    @Override
    public Optional<Course> get(Integer id) {
        return Optional.empty();
    }

    @Override
    public void updated(Course course, Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
