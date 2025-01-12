CREATE TABLE course_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(50) NOT NULL -- For the Category enum
);

CREATE TABLE topic_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL, -- Lob annotation corresponds to TEXT type in MySQL
    date_time_stamp DATETIME NOT NULL,
    status VARCHAR(100) NOT NULL, -- For EnumType.STRING mapping
    author_id BIGINT, -- Foreign key for User
    course_id BIGINT, -- Foreign key for Course,
    FOREIGN KEY (author_id) REFERENCES user_table(id),
    FOREIGN KEY (course_id) REFERENCES course_table(id)
);

CREATE TABLE answer_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL, -- Lob annotation corresponds to TEXT type in MySQL
    date_time_stamp DATETIME NOT NULL,
    solution BOOLEAN NOT NULL, -- Indicates if the answer is the accepted one
    topic_id BIGINT, -- Foreign key for Topic
    author_id BIGINT, -- Foreign key for User
    FOREIGN KEY (topic_id) REFERENCES topic_table(id),
    FOREIGN KEY (author_id) REFERENCES user_table(id)
);

