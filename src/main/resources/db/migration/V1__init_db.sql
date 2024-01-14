CREATE TABLE category
(
    id   BINARY(16) NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE join_mentor
(
    id     BIGINT NOT NULL,
    rating INT    NOT NULL,
    CONSTRAINT pk_join_mentor PRIMARY KEY (id)
);

CREATE TABLE join_student
(
    id  BIGINT NOT NULL,
    psp FLOAT  NOT NULL,
    CONSTRAINT pk_join_student PRIMARY KEY (id)
);

CREATE TABLE join_ta
(
    id BIGINT NOT NULL,
    CONSTRAINT pk_join_ta PRIMARY KEY (id)
);

CREATE TABLE join_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_join_user PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id     BIGINT AUTO_INCREMENT NOT NULL,
    name   VARCHAR(255) NULL,
    email  VARCHAR(255) NULL,
    rating INT NOT NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE ms_student
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp   BIGINT NOT NULL,
    CONSTRAINT pk_ms_student PRIMARY KEY (id)
);

CREATE TABLE ms_ta
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_ms_ta PRIMARY KEY (id)
);

CREATE TABLE orders
(
    id BINARY(16) NOT NULL,
    CONSTRAINT pk_orders PRIMARY KEY (id)
);

CREATE TABLE price
(
    id       BINARY(16) NOT NULL,
    currency VARCHAR(255) NULL,
    value DOUBLE NOT NULL,
    CONSTRAINT pk_price PRIMARY KEY (id)
);

CREATE TABLE product
(
    id            BINARY(16) NOT NULL,
    title         VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    price_id      BINARY(16) NOT NULL,
    image         VARCHAR(255) NULL,
    category_id   BINARY(16) NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE products_orders
(
    order_id   BINARY(16) NOT NULL,
    product_id BINARY(16) NOT NULL
);

CREATE TABLE single_user
(
    id     BIGINT NOT NULL,
    dtype  VARCHAR(31) NULL,
    name   VARCHAR(255) NULL,
    email  VARCHAR(255) NULL,
    psp    FLOAT  NOT NULL,
    rating FLOAT  NOT NULL,
    CONSTRAINT pk_single_user PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id     BIGINT NOT NULL,
    name   VARCHAR(255) NULL,
    email  VARCHAR(255) NULL,
    rating INT    NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp   BIGINT NOT NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BIGINT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE category
    ADD CONSTRAINT uc_category_name UNIQUE (name);

ALTER TABLE product
    ADD CONSTRAINT uc_product_price UNIQUE (price_id);

ALTER TABLE join_mentor
    ADD CONSTRAINT FK_JOIN_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES join_user (id);

ALTER TABLE join_student
    ADD CONSTRAINT FK_JOIN_STUDENT_ON_ID FOREIGN KEY (id) REFERENCES join_user (id);

ALTER TABLE join_ta
    ADD CONSTRAINT FK_JOIN_TA_ON_ID FOREIGN KEY (id) REFERENCES join_user (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PRICE FOREIGN KEY (price_id) REFERENCES price (id);

ALTER TABLE products_orders
    ADD CONSTRAINT fk_proord_on_order FOREIGN KEY (order_id) REFERENCES orders (id);

ALTER TABLE products_orders
    ADD CONSTRAINT fk_proord_on_product FOREIGN KEY (product_id) REFERENCES product (id);