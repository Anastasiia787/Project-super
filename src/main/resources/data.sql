INSERT INTO products (name, price)
VALUES ('first', 300),
       ('second', 1000),
       ('third', 500);

INSERT INTO buyers (name, year)
VALUES ('t', 30),
       ('g', 10),
       ('j', 50);

INSERT INTO buys (buyers_id, product_id, name, price, qty)
VALUES (1, 1),
       (2, 1),
       (3, 2);
