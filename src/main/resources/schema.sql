create table if not exists product(
    productId int primary key AUTO_INCREMENT,
    productName varchar(255),
    price double
);

create table if not exists review(
    reviewId int primary key AUTO_INCREMENT,
    reviewContent varchar(255),
    rating int,
    productId int,
    foreign key (productId) References product(productId)
);




-- create table book (
-- id INT PRIMARY KEY AUTO_INCREMENT,
-- name varchar(255),
-- imageUrl varchar(255)
--   );