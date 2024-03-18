use master
go

drop database AccShop;
go

create database AccShop;
go

use AccShop;
go

-- Tạo bảng role
CREATE TABLE roles (
    id INT PRIMARY KEY,
    role_name VARCHAR(50)
);

-- Tạo bảng accounts
CREATE TABLE accounts (
	username VARCHAR(50) PRIMARY KEY NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    acc_status INT,
    wl VARCHAR(225),
);

-- Tạo bảng Authority
CREATE TABLE authorities (
	id INT PRIMARY KEY NOT NULL,
	acc_user VARCHAR(50),
	role_id INT,
	FOREIGN KEY (acc_user) REFERENCES accounts(username),
	FOREIGN KEY (role_id) REFERENCES roles(id)
);

-- Tạo bảng categories
CREATE TABLE categories (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

-- Tạo bảng product
CREATE TABLE product (
    product_id INT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    status INT,
	image VARCHAR(255),
    price DECIMAL(10, 2),
    rental_duration INT,
    type VARCHAR(50),
    acc_user VARCHAR(100),
    acc_pass VARCHAR(100),
    date_create DATE,
    cate_id INT,
    FOREIGN KEY (cate_id) REFERENCES categories(id)
);

-- Tạo bảng order
CREATE TABLE orders (
    id INT PRIMARY KEY,
	order_status INT,
	createDate DATE,
    acc_user VARCHAR(50),
    FOREIGN KEY (acc_user) REFERENCES accounts(username)
);

-- Tạo bảng order_details
CREATE TABLE order_details (
    id INT PRIMARY KEY,
	price float,
	product_id INT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Chèn dữ liệu vào bảng account
INSERT INTO accounts (username, email, password, acc_status, wl)
VALUES ('daole123', 'daole123@example.com', '12345', 1, 0),
       ('ledao132', 'ledao132@example.com', '12345', 1, 0),
       ('zolao123', 'zolao123@example.com', '12345', 1, 0),
	   ('minhloc123', 'minhloc123@example.com', '12345', 0, 0),
	   ('xinhao123', 'xinhao123@example.com', '12345', 1, 0),
	   ('xichao123', 'xichao123@example.com', '12345', 1, 0),
	   ('linchao123', 'linchao123@example.com', '12345', 1, 0),
	   ('lichao123', 'lichao123@example.com', '12345', 1, 0),
	   ('xuho123', 'xuho123@example.com', '12345', 1, 0),
	   ('inchao123', 'inchao123@example.com', '12345', 1, 0);

-- Chèn dữ liệu vào bảng roles
INSERT INTO roles (id, role_name)
VALUES (1, 'Admin'),
       (2, 'User'),
	   (3, 'Manager');

-- Chèn dữ liệu vào bảng authorities
INSERT INTO authorities (id, acc_user, role_id)
VALUES (1, 'daole123', 1),
(2, 'ledao132', 1),
(3, 'zolao123', 2),
(4, 'minhloc123', 2),
(5, 'xinhao123', 2),
(6, 'xichao123', 3),
(7, 'linchao123', 2),
(8, 'lichao123', 3),
(9, 'xuho123', 2),
(10, 'inchao123', 2);

-- Chèn dữ liệu vào bảng categories
INSERT INTO categories (id, name)
VALUES (1, 'Valorant'),
	   (2, 'League of Legends'),
	   (3, 'Dota 2'),
	   (4, 'PlayerUnknowns Battlegrounds'),
	   (5, 'Counter-Strike: Global Offensive');

-- Chèn dữ liệu vào bảng product
INSERT INTO product (product_id, name, description, status, image, price, rental_duration, type, acc_user, acc_pass, date_create, cate_id)
VALUES 
(1, 'Valorant', 'Rare weapon and high rank', 1, 'valorant1.jpg', 49.99, NULL, 'Buy', 'user1', 'pass1', '2023-01-01', 1),
(2, 'League of Legends', 'Full skin and high rank', 1, 'league_of_legends1.jpg', 99.99, NULL, 'Sell', 'user2', 'pass2', '2023-01-02', 2),
(3, 'Dota 2', 'Full skin and high rank', 1, 'dota2_1.jpg', 29.99, NULL, 'Buy', 'user3', 'pass3', '2023-01-03', 3),
(4, 'PUBG', 'Rare skin and high rank', 1, 'pubg1.jpg', 39.99, NULL, 'Buy', 'user4', 'pass4', '2023-01-04', 4),
(5, 'CS:GO', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(6, 'Dota 2', 'Full skin and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 3),
(7, 'CS:GO', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(8, 'Dota 2', 'Full skin and high rank', 1, 'dota2_1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 3),
(9, 'CS:GO', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Rent', 'user5', 'pass5', '2023-01-05', 5),
(10, 'Valorant', 'Rare weapon and high rank', 1, 'valorant1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 1),
(11, 'CS:GO', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(12, 'League of Legends', 'Full skin and high rank', 1, 'league_of_legends1.jpg', 19.99, NULL, 'Rent', 'user5', 'pass5', '2023-01-05', 2),
(13, 'CS:GO', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(14, 'League of Legends', 'Full skin and high rank', 1, 'league_of_legends1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 2),
(15, 'League of Legends', 'Full skin and high rank', 1, 'league_of_legends1.jpg', 19.99, NULL, 'Rent', 'user5', 'pass5', '2023-01-06', 2),
(16, 'League of Legends', 'Full skin and high rank', 1, 'league_of_legends1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 2),
(17, 'CS:GO', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 5),
(18, 'Dota 2', 'Full skin and high rank', 1, 'dota2_1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 3),
(19, 'CS:GO', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-06', 5),
(20, 'PUBG', 'Rare skin and high rank', 1, 'pubg1.jpg', 39.99, NULL, 'Rent', 'user4', 'pass4', '2023-01-04', 4),
(21, 'CS:GO', 'Rare skin and high rank', 1, 'pubg1.jpg', 39.99, NULL, 'Buy', 'user4', 'pass4', '2023-01-06', 5),
(22, 'Valorant', 'Rare weapon and high rank', 1, 'valorant1.jpg', 39.99, NULL, 'Buy', 'user4', 'pass4', '2023-01-07', 1),
(23, 'CS:GO', 'Rare skin and high rank', 1, 'pubg1.jpg', 39.99, NULL, 'Rent', 'user4', 'pass4', '2023-01-04', 5),
(24, 'PUBG', 'Rare weapon and high rank', 1, 'pubg1.jpg', 39.99, NULL, 'Rent', 'user4', 'pass4', '2023-01-04', 4),
(25, 'PUBG', 'Rare weapon and high rank', 1, 'csgo1.jpg', 19.99, NULL, 'Sell', 'user5', 'pass5', '2023-01-05', 4);


-- Chèn dữ liệu vào bảng orders
INSERT INTO orders (id, order_status, createDate, acc_user)
VALUES 
(1, 1, '2024-01-15', 'daole123'),
(2, 0, '2024-01-17', 'daole123'),
(3, 0, '2024-02-01', 'ledao132'),
(4, 1, '2024-02-06', 'ledao132'),
(5, 1, '2024-01-02', 'inchao123'),
(6, 1, '2024-01-23', 'zolao123'),
(7, 0, '2024-02-15', 'minhloc123'),
(8, 1, '2024-02-26', 'minhloc123'),
(9, 0, '2024-02-15', 'xinhao123'),
(10, 1, '2024-02-26', 'linchao123'),
(11, 0, '2024-02-15', 'lichao123'),
(12, 1, '2024-02-26', 'xuho123'),
(13, 1, '2024-01-29', 'xinhao123'),
(14, 1, '2024-02-20', 'xichao123');

-- Chèn dữ liệu vào bảng order_details
INSERT INTO order_details (id, price, product_id, order_id)
VALUES
(1, 60, 1, 1),
(2, 70, 2, 4),
(3, 50, 1, 5),
(4, 50, 6, 6),
(5, 60, 7, 8),
(6, 40, 1, 10),
(7, 40, 9, 12),
(8, 70, 10, 13),
(9, 90, 3, 14);

select * from accounts;
select * from roles;
select * from categories;
select * from product;
select * from orders;
select * from order_details;