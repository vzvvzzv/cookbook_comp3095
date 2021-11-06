CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255), password VARCHAR(255),
    firstname VARCHAR(255), lastname VARCHAR(255));

CREATE TABLE recipes(id INT PRIMARY KEY AUTO_INCREMENT,
    recipe_name VARCHAR(255),
    ingredients CLOB,
    instructions CLOB,
    serves_how_many VARCHAR(255),
    cook_and_prep_time VARCHAR(255),
    creation_date DATE,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id));

CREATE TABLE users_favorite_recipes(id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    recipe_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id));

CREATE TABLE user_meal_recipe(id INT PRIMARY KEY AUTO_INCREMENT,
    meal_date DATE NOT NULL,
    user_id INT NOT NULL,
    recipe_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (recipe_id) REFERENCES recipes(id));