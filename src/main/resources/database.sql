-- Table: users
create table users (
    id            INT          not null primary key ,
    user_name     VARCHAR(255) not null,
    user_login    varchar(255) not null,
    user_password VARCHAR(255) not null
);

--Table: products
create table products (
    id            int          not null primary key,
    owner_id      int          not null,
    offer_id      int,
    product_title varchar(255) not null,
    description   varchar(255),
    start_price   int,
    start_date    date         not null,
    end_date      date         not null,
    bidInc        int          not null,

    foreign key (owner_id) references users(id),
    foreign key (offer_id) references offers(id)
);

--Table: offers
create table offers (
    id          int not null primary key,
    product_id  int not null,
    user_id     int not null,
    value       int,

    foreign key (product_id) references products(id),
    foreign key (user_id) references users(id)
);

--Create test users

insert into users values (1, 'maksim', 'maksim', '123');
insert into users values (2, 'anton', 'anton', '456');


insert into products values (1, 1, null, 'Tomato', 'this is tomato', 10, '2022-10-25', '2022-10-28', 1.5);

insert into offers values (1, 1, 2, 44);

update products set offer_id = 1 where id = 1;