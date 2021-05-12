CREATE TABLE products
(
    id    INTEGER PRIMARY KEY AUTO_INCREMENT,
    name  TEXT    NOT NULL,
    price INTEGER NOT NULL CHECK (price > 0),
    quantity   INTEGER NOT NULL DEFAULT 0 CHECK (quantity >= 0),
    deleted BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE buyers
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name TEXT    NOT NULL,
    year INTEGER NOT NULL
);

CREATE TABLE buys
(
    buyers_id  INTEGER NOT NULL REFERENCES buyers,
    product_id INTEGER NOT NULL REFERENCES products,
    name       TEXT    NOT NULL,
    price      INTEGER NOT NULL CHECK (price > 0),
    quantity        INTEGER NOT NULL CHECK (quantity > 0)
);

