
INSERT INTO product_management.dbo.categories
(name)
VALUES(N'C1');

INSERT INTO product_management.dbo.categories
(name)
VALUES(N'C2');

INSERT INTO product_management.dbo.products
(quantity, category_id, price, description, name)
VALUES
(21, 1, 2,  N'Description1', N'P1'),
(21, 1, 132,  N'Description1', N'P2'),
(50, 2, 5000, N'Description1', N'P3'),
(50, 1, 5000, N'Description1', N'P3'),
(500, 1, 52200, N'Description1', N'P4'),
(50, 1, 540, N'Description1', N'P5'),
(50, 2, 4500, N'Description1', N'P6'),
(50, 1, 500, N'Description1', N'P7'),
(50, 1, 600, N'Description1', N'P8'),
(50, 1, 50, N'Description1', N'P9'),
(50, 1, 90, N'Description1', N'P10'),
(50, 2, 300, N'Description1', N'P11'),
(50, 2, 5050, N'Description1', N'P12'),
(50, 2, 800, N'Description1', N'P13'),
(50, 1, 7800, N'Description1', N'P14'),
(50, 1, 300, N'Description1', N'P15'),
(50, 1, 5000, N'Description1', N'P16'),
(50, 1, 5000, N'Description1', N'P17');