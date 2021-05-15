INSERT INTO products (id, name, price, quantity)
VALUES (1, 'first', 300, 10),
       (2, 'second', 1000,15),
       (3, 'third', 500, 12);

INSERT INTO buyers (buyer_id, buyer_name, gender_person, year, phone_number)
VALUES (1, 't', 'm', 30, '89376780034'),
       (2, 'g', 'w', 18, '89396783450'),
       (3, 'j', 'w', 50, '89175650304');

INSERT INTO buys (buyer_id, product_id, name, price, quantity)
VALUES (1, 1, 'first', 300, 1),
       (1, 2, 'second',1000, 2),
       (2, 3, 'third', 500, 3),
       (3, 1, 'first', 300, 1),
       (3, 2, 'second', 1000, 1),
       (3, 3, 'third', 500, 1);
