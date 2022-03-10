-- Table: users
create table users (
    id            INT          not null primary key,
    full_name     VARCHAR(255) not null,
    username      VARCHAR(255) not null,
    user_password VARCHAR(255) not null
);

-- Table: roles
CREATE TABLE roles (
    id   INT          not null primary key,
    name VARCHAR(100) not null
);

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
    user_id INT not null,
    role_id INT not null,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
);

-- --Table: products
-- create table products (
--     id            int          not null primary key,
--     owner_id      int          not null,
--     offer_id      int,
--     product_title varchar(255) not null,
--     description   varchar(255),
--     start_price   int,
--     start_date    date         not null,
--     end_date      date         not null,
--     bidInc        int          not null,
--
--     foreign key (owner_id) references users(id),
--     foreign key (offer_id) references offers(id)
-- );

-- --Table: offers
-- create table offers (
--     id          int not null primary key,
--     product_id  int not null,
--     user_id     int not null,
--     value       int,
--
--     foreign key (product_id) references products(id),
--     foreign key (user_id) references users(id)
-- );

INSERT INTO users VALUES (1, 'maksim', 'maksim', '$2a$10$DHTj0crgiI3KLjh0RTork.47c1iXXtUJOE78utlpuc61suijIj0fC');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');