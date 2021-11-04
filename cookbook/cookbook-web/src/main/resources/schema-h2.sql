CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255), password VARCHAR(255),
    firstname VARCHAR(255), lastname VARCHAR(255));

CREATE TABLE recipes(id INT PRIMARY KEY AUTO_INCREMENT,
    recipename VARCHAR(255),
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id));