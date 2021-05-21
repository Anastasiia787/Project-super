INSERT INTO products (id, model, brand, wheel_diameter, price, quantity)
VALUES (1, 'comfortable', 'Forward Parma 28', 19, 17890, 15),
       (2, 'mountain', 'Cube Aim EX 29', 23, 60100, 10),
       (3, 'urban', 'Stark Terros 700 S', 28, 23690, 12);

INSERT INTO buyers (id, name, gender, age, phone_number)
VALUES (1, 'John', 'man', 30, '89376780034'),
       (2, 'Katy', 'women', 18, '89396783450'),
       (3, 'Karl', 'man', 25, '89373503450'),
       (4, 'Jane', 'women', 32, '89270003452'),
       (5, 'Klara', 'women', 45, '89170250787'),
       (6, 'Tom', 'man', 50, '89175650304');

INSERT INTO buyings (id, buyer_id, product_id, brand, quantity, price)
VALUES (1, 2, 3, 'Stark Terros 700 S', 1, 23690),
       (2, 1, 1, 'Forward Parma 28', 1, 17890),
       (3, 4, 1, 'Forward Parma 28', 1, 17890),
       (4, 3, 1, 'Forward Parma 28', 1, 17890),
       (5, 2, 2, 'Cube Aim EX 29', 1, 60100),
       (6, 6, 3, 'Stark Terros 700 S', 1, 23690);
