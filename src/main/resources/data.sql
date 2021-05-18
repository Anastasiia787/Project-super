INSERT INTO products (id, model, brand, wheel_diameter, price, quantity)
VALUES (1, 'first', 'a', 20, 300, 10),
       (2, 'second', 'v', 25, 1000, 15),
       (3, 'third', 's', 30, 500, 12);

INSERT INTO buyers (id, name, gender, age, phone_number)
VALUES (1, '', 'm', 30, '89376780034'),
       (2, 'g', 'w', 18, '89396783450'),
       (3, 'j', 'w', 50, '89175650304');



INSERT INTO buyings (id, buyer_id, product_id, brand, quantity, price)
VALUES (1, 1, 1, 'first', 1, 1),
       (2, 1, 2, 'second', 1, 2),
       (3, 2, 3, 'third', 1, 3),
       (4, 3, 1, 'first', 1, 1),
       (5, 3, 2, 'second', 1, 1),
       (6, 3, 3, 'third', 1, 1);
