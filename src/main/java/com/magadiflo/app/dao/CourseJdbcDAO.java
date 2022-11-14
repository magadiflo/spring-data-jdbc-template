package com.magadiflo.app.dao;

import com.magadiflo.app.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
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
        String sql = "INSERT INTO course(title, description, link) VALUES(?, ?, ?)";

        //  this.jdbcTemplate.update(...), quizás parezca que solo es para actualizar, pero en realidad también es para insertar y eliminar
        int affectedRows = this.jdbcTemplate.update(sql, course.getTitle(), course.getDescription(), course.getLink());
        if (affectedRows == 1) {
            LOGGER.info("New course created: {}", course.getTitle());
        }
    }

    @Override
    public Optional<Course> get(Integer id) {
        String sql = "SELECT id, title, description, link FROM course AS c WHERE c.id = ?";
        Course course = null;
        try{
            course = this.jdbcTemplate.queryForObject(sql, this.rowMapper, id);
        } catch (DataAccessException e) {
            LOGGER.info("Course not found: {}", id);
        }
        return Optional.ofNullable(course);
    }

    @Override
    public void updated(Course course, Integer id) {
        String sql = "UPDATE course SET title = ?, description = ?, link = ? WHERE id = ?";
        int affectedRows = this.jdbcTemplate.update(sql , course.getTitle(), course.getDescription(), course.getLink(), id);
        if(affectedRows == 1) {
            LOGGER.info("Course updated: {}", course.getTitle());
        }
    }

    @Override
    public void delete(Integer id) {
        int affectedRows = this.jdbcTemplate.update("DELETE FROM course WHERE id = ?", id);
        if(affectedRows == 1) {
            LOGGER.info("Course deleted: {}", id);
        }
    }
}
