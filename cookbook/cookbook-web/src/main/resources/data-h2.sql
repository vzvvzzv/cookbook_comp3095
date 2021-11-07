INSERT INTO users(username, password, firstname, lastname)
VALUES ('user', 'password', 'John', 'Doe');
INSERT INTO users(username, password, firstname, lastname)
VALUES ('user2', 'password2', 'Alice', 'White');

INSERT INTO recipes(recipe_name, ingredients, instructions, serves_how_many, cook_and_prep_time, creation_date, user_id)
    VALUES('Apple Pie',
           'Apples, Flour, Butter, Egg, Sugar, Salt, Cinnamon',
           'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ' ||
           'the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of ' ||
           'type and scrambled it to make a type specimen book. It has survived not only five centuries, but ' ||
           'also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the ' ||
           '1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with ' ||
           'desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
           '6',
           '1 hour prep, 4 hour cook time',
           '2021-11-7',
           1);
INSERT INTO recipes(recipe_name, ingredients, instructions, serves_how_many, cook_and_prep_time, creation_date, user_id)
    VALUES('Raspberry Pie',
           'Raspberries, Flour, Butter, Egg, Sugar, Salt, Lemon Juice, Nutmeg',
           'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ' ||
           'the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of ' ||
           'type and scrambled it to make a type specimen book. It has survived not only five centuries, but ' ||
           'also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the ' ||
           '1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with ' ||
           'desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
           '8',
           '1 hour prep, 4 hour cook time',
           '2021-11-7',
           2);
INSERT INTO recipes(recipe_name, ingredients, instructions, serves_how_many, cook_and_prep_time, creation_date, user_id)
    VALUES('Blueberry Pie',
           'Blueberries, Flour, Butter, Egg, Sugar, Salt, Lemon Zest, Cinnamon, Cream',
           'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been ' ||
           'the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of ' ||
           'type and scrambled it to make a type specimen book. It has survived not only five centuries, but ' ||
           'also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the ' ||
           '1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with ' ||
           'desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
           '4',
           '1 hour prep, 4 hour cook time',
           '2021-11-7',
           1);

INSERT INTO users_favorite_recipes(user_id, recipe_id) VALUES(1,2);
INSERT INTO users_favorite_recipes(user_id, recipe_id) VALUES(2,1);

INSERT INTO user_meal_recipe(meal_date, user_id, recipe_id)
    VALUES((CURRENT_DATE + 7), 1, 1);