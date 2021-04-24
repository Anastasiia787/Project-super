CREATE TABLE products
(
    id    INTEGER PRIMARY KEY AUTO_INCREMENT,
    name  TEXT    NOT NULL,
    price INTEGER NOT NULL CHECK (price > 0),
    qty   INTEGER NOT NULL DEFAULT 0 CHECK (qty >= 0)
);

CREATE TABLE buyers
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT    NOT NULL,
    year INTEGER NOT NULL
);

CREATE TABLE buys
(
    buyers_id  INTEGER PRIMARY KEY AUTO_INCREMENT,
    product_id INTEGER NOT NULL REFERENCES buyers,
    name       TEXT    NOT NULL,
    price      INTEGER NOT NULL CHECK (price > 0),
    qty        INTEGER NOT NULL CHECK (qty > 0)
);

