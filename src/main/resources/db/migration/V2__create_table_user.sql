CREATE TABLE user_table (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    profile_id BIGINT,
    FOREIGN KEY (profile_id) REFERENCES  profile_table(id)
);