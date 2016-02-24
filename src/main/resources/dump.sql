--
-- PostgreSQL database dump
--


CREATE TABLE cars (
    id integer NOT NULL,
    mark text,
    model text,
    color text,
    owner_id integer
);

CREATE TABLE owner (
    id integer NOT NULL,
    fname text,
    lname text
);


INSERT INTO cars (id, mark, model, color, owner_id) VALUES (1, 'BMW', '525', 'Black', 1);
INSERT INTO cars (id, mark, model, color, owner_id) VALUES (2, 'Audi', 'A4', 'Red', 1);
INSERT INTO cars (id, mark, model, color, owner_id) VALUES (3, 'LADA', '2110', 'Blue', 2);
INSERT INTO cars (id, mark, model, color, owner_id) VALUES (4, 'Toyota', 'Camry', 'Black', 2);

INSERT INTO owner (id, fname, lname) VALUES (1, 'Petr', 'Petrov');
INSERT INTO owner (id, fname, lname) VALUES (2, 'Ivan', 'Ivanov');



ALTER TABLE ONLY cars
    ADD CONSTRAINT car_id PRIMARY KEY (id);


ALTER TABLE ONLY car
    ADD CONSTRAINT car_pkey PRIMARY KEY (id);


ALTER TABLE ONLY owner
    ADD CONSTRAINT owner_id PRIMARY KEY (id);


ALTER TABLE ONLY cars
    ADD CONSTRAINT car_fk FOREIGN KEY (owner_id) REFERENCES owner(id);

