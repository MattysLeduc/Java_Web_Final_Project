DROP TABLE IF EXISTS instructions;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS recipe;

CREATE TABLE recipe (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255),
                        description TEXT,
                        imageURL VARCHAR(500) NOT NULL UNIQUE
);

CREATE TABLE ingredient (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255),
                            quantity VARCHAR(100),
                            recipe_id BIGINT NOT NULL,
                            CONSTRAINT fk_ingredient_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(id) ON DELETE CASCADE
);

CREATE TABLE instructions (
                              instruction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              recipe_id BIGINT NOT NULL,
                              step_number INT NOT NULL,
                              instruction_text TEXT NOT NULL,
                              CONSTRAINT fk_instructions_recipe FOREIGN KEY (recipe_id) REFERENCES recipe(id) ON DELETE CASCADE
);
