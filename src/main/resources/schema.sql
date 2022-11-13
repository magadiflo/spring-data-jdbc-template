CREATE TABLE course(
    id INT AUTO_INCREMENT NOT NULL,
    title VARCHAR(80) NOT NULL,
    description TEXT NOT NULL,
    link VARCHAR(255) NOT NULL,
    CONSTRAINT pk_course_id PRIMARY KEY(id)
);