-- Recipes
INSERT INTO recipe (name, description, imageURL) VALUES
                                                     ('Chocolate Cake', 'A rich and moist chocolate cake', 'https://example.com/chocolate-cake.jpg'),
                                                     ('Margherita Pizza', 'Classic pizza with tomatoes, mozzarella, and basil', 'https://example.com/margherita-pizza.jpg'),
                                                     ('Spaghetti Bolognese', 'Traditional Italian pasta with meat sauce', 'https://example.com/spaghetti-bolognese.jpg'),
                                                     ('Lemon Meringue Pie', 'Sweet and tangy pie with fluffy meringue topping', 'https://example.com/lemon-meringue-pie.jpg'),
                                                     ('Caesar Salad', 'Crisp romaine lettuce with creamy Caesar dressing', 'https://example.com/caesar-salad.jpg'),
                                                     ('Beef Tacos', 'Mexican-style tacos with seasoned beef and toppings', 'https://example.com/beef-tacos.jpg'),
                                                     ('Pancakes', 'Fluffy breakfast pancakes with maple syrup', 'https://example.com/pancakes.jpg'),
                                                     ('Chicken Curry', 'Spicy chicken curry with aromatic spices', 'https://example.com/chicken-curry.jpg'),
                                                     ('Caprese Salad', 'Tomatoes, mozzarella, and basil with olive oil', 'https://example.com/caprese-salad.jpg'),
                                                     ('Grilled Salmon', 'Salmon fillet grilled with lemon and herbs', 'https://example.com/grilled-salmon.jpg');

-- Ingredients
INSERT INTO ingredient (name, quantity, recipe_id) VALUES
-- Chocolate Cake (1)
('Flour', '2 cups', 1),
('Sugar', '1.5 cups', 1),
('Cocoa Powder', '0.5 cup', 1),
('Eggs', '3 large', 1),
('Butter', '1 cup', 1),

-- Margherita Pizza (2)
('Pizza Dough', '1 base', 2),
('Tomato Sauce', '0.5 cup', 2),
('Mozzarella Cheese', '200g', 2),
('Fresh Basil', '5 leaves', 2),

-- Spaghetti Bolognese (3)
('Spaghetti', '300g', 3),
('Ground Beef', '250g', 3),
('Tomato Sauce', '1 cup', 3),
('Onion', '1 chopped', 3),
('Garlic', '2 cloves', 3),

-- Lemon Meringue Pie (4)
('Pie Crust', '1 base', 4),
('Lemon Juice', '0.5 cup', 4),
('Sugar', '1 cup', 4),
('Egg Whites', '3 large', 4),

-- Caesar Salad (5)
('Romaine Lettuce', '1 head', 5),
('Croutons', '1 cup', 5),
('Caesar Dressing', '0.5 cup', 5),
('Parmesan Cheese', '0.25 cup', 5),

-- Beef Tacos (6)
('Taco Shells', '6', 6),
('Ground Beef', '250g', 6),
('Lettuce', '1 cup shredded', 6),
('Cheddar Cheese', '0.5 cup', 6),
('Salsa', '0.25 cup', 6),

-- Pancakes (7)
('Flour', '1.5 cups', 7),
('Milk', '1 cup', 7),
('Egg', '1 large', 7),
('Sugar', '2 tbsp', 7),
('Butter', '2 tbsp', 7),

-- Chicken Curry (8)
('Chicken Breast', '500g', 8),
('Onion', '1 chopped', 8),
('Garlic', '2 cloves', 8),
('Curry Powder', '2 tbsp', 8),
('Coconut Milk', '1 cup', 8),

-- Caprese Salad (9)
('Tomatoes', '3 sliced', 9),
('Mozzarella Cheese', '200g', 9),
('Fresh Basil', '6 leaves', 9),
('Olive Oil', '2 tbsp', 9),

-- Grilled Salmon (10)
('Salmon Fillet', '2 pieces', 10),
('Lemon', '1 sliced', 10),
('Olive Oil', '2 tbsp', 10),
('Garlic', '2 cloves', 10);

-- Instructions
INSERT INTO instructions (recipe_id, step_number, instruction_text) VALUES
-- Chocolate Cake
(1, 1, 'Preheat oven to 350°F (175°C).'),
(1, 2, 'Mix dry ingredients together.'),
(1, 3, 'Add eggs and butter, mix until smooth.'),
(1, 4, 'Pour into pan and bake for 30 minutes.'),

-- Margherita Pizza
(2, 1, 'Preheat oven to 475°F (245°C).'),
(2, 2, 'Spread tomato sauce over dough.'),
(2, 3, 'Add cheese and basil.'),
(2, 4, 'Bake for 10–12 minutes.'),

-- Spaghetti Bolognese
(3, 1, 'Boil spaghetti until al dente.'),
(3, 2, 'Cook onion and garlic, add beef.'),
(3, 3, 'Pour in tomato sauce and simmer.'),
(3, 4, 'Serve over spaghetti.'),

-- Lemon Meringue Pie
(4, 1, 'Bake pie crust until golden.'),
(4, 2, 'Prepare lemon filling with juice and sugar.'),
(4, 3, 'Beat egg whites into stiff peaks.'),
(4, 4, 'Spread meringue on top and bake until golden.'),

-- Caesar Salad
(5, 1, 'Chop lettuce and place in bowl.'),
(5, 2, 'Add croutons and cheese.'),
(5, 3, 'Toss with dressing.'),

-- Beef Tacos
(6, 1, 'Cook beef with seasoning.'),
(6, 2, 'Warm taco shells.'),
(6, 3, 'Fill with beef, lettuce, cheese, and salsa.'),

-- Pancakes
(7, 1, 'Mix flour, sugar, milk, and egg.'),
(7, 2, 'Heat skillet and add butter.'),
(7, 3, 'Pour batter and cook until golden on both sides.'),

-- Chicken Curry
(8, 1, 'Cook onion and garlic in pan.'),
(8, 2, 'Add chicken and curry powder, stir well.'),
(8, 3, 'Pour coconut milk and simmer until thick.'),

-- Caprese Salad
(9, 1, 'Slice tomatoes and mozzarella.'),
(9, 2, 'Arrange alternately on plate.'),
(9, 3, 'Top with basil and olive oil.'),

-- Grilled Salmon
(10, 1, 'Preheat grill.'),
(10, 2, 'Season salmon with oil, garlic, and lemon.'),
(10, 3, 'Grill salmon for 6–8 minutes per side.');
