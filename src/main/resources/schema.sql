CREATE TABLE products
(
    id             INTEGER PRIMARY KEY AUTO_INCREMENT,
    model          TEXT    NOT NULL,
    brand          TEXT    NOT NULL,
    wheel_diameter INTEGER NOT NULL,
    price          INTEGER NOT NULL CHECK (price > 0),
    quantity       INTEGER NOT NULL DEFAULT 0 CHECK (quantity >= 0),
    deleted        BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE buyers
(
    id           INTEGER PRIMARY KEY AUTO_INCREMENT,
    name         TEXT    NOT NULL,
    avatar       TEXT    NOT NULL DEFAULT 'noavatar.jpg',
    gender       TEXT    NOT NULL,
    age          INTEGER NOT NULL,
    phone_number TEXT    NOT NULL
);

CREATE TABLE posts
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    media   TEXT
);

CREATE TABLE buyings
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    buyer_id   INTEGER NOT NULL REFERENCES buyers,
    product_id INTEGER NOT NULL REFERENCES products,
    brand      TEXT    NOT NULL,
    quantity   INTEGER NOT NULL CHECK (quantity > 0),
    price      INTEGER NOT NULL CHECK (price > 0)
);

