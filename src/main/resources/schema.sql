 CREATE TABLE IF NOT EXISTS ingredient
  (
     id   VARCHAR(4) NOT NULL,
     name VARCHAR(25) NOT NULL,
     type VARCHAR(10) NOT NULL
  );

CREATE TABLE IF NOT EXISTS taco
  (
     id        IDENTITY,
     name      VARCHAR(50) NOT NULL,
     createdat TIMESTAMP NOT NULL
  );

CREATE TABLE IF NOT EXISTS taco_ingredients
  (
     taco       BIGINT NOT NULL,
     ingredient VARCHAR(4) NOT NULL
  );

ALTER TABLE taco_ingredients
  ADD FOREIGN KEY (taco) REFERENCES taco(id);

ALTER TABLE taco_ingredients
  ADD FOREIGN KEY (ingredient) REFERENCES ingredient(id);

CREATE TABLE IF NOT EXISTS taco_order
  (
     id             IDENTITY,
     name   VARCHAR(50) NOT NULL,
     street VARCHAR(50) NOT NULL,
     city   VARCHAR(50) NOT NULL,
     state  VARCHAR(2) NOT NULL,
     zip    VARCHAR(10) NOT NULL,
     ccnumber       VARCHAR(16) NOT NULL,
     ccexpiration   VARCHAR(5) NOT NULL,
     cccvv          VARCHAR(3) NOT NULL,
     placedat       TIMESTAMP NOT NULL
  );

CREATE TABLE IF NOT EXISTS taco_order_tacos
  (
     tacoorder BIGINT NOT NULL,
     taco      BIGINT NOT NULL
  );

ALTER TABLE taco_order_tacos
  ADD FOREIGN KEY (tacoorder) REFERENCES taco_order(id);

ALTER TABLE taco_order_tacos
  ADD FOREIGN KEY (taco) REFERENCES taco(id);  