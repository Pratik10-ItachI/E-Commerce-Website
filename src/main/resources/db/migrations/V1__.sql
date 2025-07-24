CREATE TABLE category
(
    id            BIGINT NOT NULL,
    created_at    datetime NULL,
    is_deleted    BIT(1) NOT NULL,
    updated_at    datetime NULL,
    `description` VARCHAR(255) NULL,
    name          VARCHAR(255) NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

CREATE TABLE category_featured_products
(
    category_id          BIGINT NOT NULL,
    featured_products_id BIGINT NOT NULL
);

CREATE TABLE product
(
    id            BIGINT NOT NULL,
    created_at    datetime NULL,
    is_deleted    BIT(1) NOT NULL,
    updated_at    datetime NULL,
    `description` VARCHAR(255) NULL,
    img_url       VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    title         VARCHAR(255) NULL,
    category_id   BIGINT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id)
);

ALTER TABLE category_featured_products
    ADD CONSTRAINT UKcj4sbgb3v7g8m1ewl62t7p1ro UNIQUE (featured_products_id);

ALTER TABLE product
    ADD CONSTRAINT FK1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE NO ACTION;

CREATE INDEX FK1mtsbur82frn64de7balymq9s ON product (category_id);

ALTER TABLE category_featured_products
    ADD CONSTRAINT FKs5otl43ovx5gm6jdrdp9xn3av FOREIGN KEY (category_id) REFERENCES category (id) ON DELETE NO ACTION;

CREATE INDEX FKs5otl43ovx5gm6jdrdp9xn3av ON category_featured_products (category_id);

ALTER TABLE category_featured_products
    ADD CONSTRAINT FKt3v7mfuesin5gey1la050lxeq FOREIGN KEY (featured_products_id) REFERENCES product (id) ON DELETE NO ACTION;

CREATE TABLE category_seq (
                              next_val BIGINT NOT NULL
);

INSERT INTO category_seq (next_val) VALUES (1);

CREATE TABLE product_seq (
                              next_val BIGINT NOT NULL
);

INSERT INTO product_seq (next_val) VALUES (2);

