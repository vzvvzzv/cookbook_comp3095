INSERT INTO users(username, password, firstname, lastname)
VALUES ('user', 'password', 'John', 'Doe');
INSERT INTO users(username, password, firstname, lastname)
VALUES ('user2', 'password2', 'Alice', 'White');

INSERT INTO recipes(recipe_name, user_id) VALUES('Apple Pie', 1);
INSERT INTO recipes(recipe_name, user_id) VALUES('Raspberry Pie', 2);
INSERT INTO recipes(recipe_name, user_id) VALUES('Blueberry Pie', 1);

INSERT INTO users_favorite_recipes(user_id, recipe_id) VALUES(1,2);
INSERT INTO users_favorite_recipes(user_id, recipe_id) VALUES(2,1);