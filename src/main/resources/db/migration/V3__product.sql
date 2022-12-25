CREATE TABLE IF NOT EXISTS product(
    id SERIAL NOT NULL,
    description VARCHAR (100),
    brand VARCHAR (100),
    stock INT,
    PRIMARY KEY(id)
    );