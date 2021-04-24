INSERT INTO products (id, name, price)
VALUES (1, 'first', 300),
       (2, 'second', 1000),
       (3, 'third', 500);

INSERT INTO buyers (id, name, year)
VALUES (1, 't', 30),
       (2, 'g', 10),
       (3, 'j', 50);

INSERT INTO buys (buyers_id, product_id, name, price, qty)
VALUES (1, 1, 'first', 300, 1),
       (1, 2, 'second',1000, 2),
       (2, 3, 'third', 500, 3),
       (3, 1, 'first', 300, 1),
       (3, 2, 'second', 1000, 1),
       (3, 3, 'third', 500, 1);
