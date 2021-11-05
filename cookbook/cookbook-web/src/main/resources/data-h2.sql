INSERT INTO users(username, password, firstname, lastname)
VALUES ('user', 'password', 'John', 'Doe');
INSERT INTO users(username, password, firstname, lastname)
VALUES ('user2', 'password2', 'Alice', 'White');

INSERT INTO recipes(recipename, user_id) VALUES('Apple Pie', 1);
INSERT INTO recipes(recipename, user_id) VALUES('Raspberry Pie', 2);
INSERT INTO recipes(recipename, user_id) VALUES('Blueberry Pie', 1);