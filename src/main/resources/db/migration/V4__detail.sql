CREATE TABLE IF NOT EXISTS detail(
    id SERIAL NOT NULL,
    invoice_id INT,
    product_id INT,
    quantity INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(invoice_id) REFERENCES invoice(id),
    FOREIGN KEY(product_id) REFERENCES product(id)
    );



































