CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255), password VARCHAR(255),
    firstname VARCHAR(255), lastname VARCHAR(255), email VARCHAR(255));

CREATE TABLE recipes(id INT PRIMARY KEY AUTO_INCREMENT,
    recipe_name VARCHAR(255),
    ingredients CLOB,
    instructions CLOB,
    difficulty VARCHAR(255),
    prep_time INT,
    cook_time INT,
    serving INT,
    creation_date DATE,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id));

CREATE TABLE users_favorite_recipes(id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    recipe_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id));

CREATE TABLE user_meal_recipe(id INT PRIMARY KEY AUTO_INCREMENT,
    meal_name VARCHAR(255),
    meal_date DATE NOT NULL,
    creation_date DATE NOT NULL,
    user_id INT NOT NULL,
    recipe_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id));