--OBJETO Role
CREATE TYPE Rolename AS ENUM ('Admin', 'Operator');
alter type rolename owner to postgres;

--CREAR TABLA
create table Enterprise (
                            id bigint primary key,
                            name varchar(20) unique,
                            document varchar(15) unique,
                            phone varchar(15),
                            address varchar(50),
                            createdAt date,
                            updatedAt date
);

--CREAR TABLA
create table Profile (
                         id varchar(15) primary key,
                         image text,
                         phone varchar(12),
                         createdAt date,
                         updatedAt date
);

--CREAR TABLA
create table Employee (
                          id bigint primary key,
                          email varchar(150),
                          profile varchar(15) unique not null,
                          role Rolename not null,
                          enterprise bigint,
                          createdAt date,
                          updatedAt date
);

--CREAR TABLA
create table Transaction (
                              id bigint primary key,
                              concept varchar(50),
                              amount float not null,
                              employee bigint,
                              enterprise bigint,
                              createdAt date,
                              updatedAt date
);

--AGREGAR LLAVES FORANEAS
alter table Employee
    add CONSTRAINT fk_prof_empl FOREIGN KEY (profile) REFERENCES Profile(id),
    add CONSTRAINT fk_enter_empl FOREIGN KEY (enterprise) REFERENCES Enterprise(id);

alter table Transaction
    add CONSTRAINT fk_empl_trans FOREIGN KEY (employee) REFERENCES Employee(id),
    add CONSTRAINT fk_enter_trans FOREIGN KEY (enterprise) REFERENCES Enterprise(id);


--INSERTAR DATOS EN CADA TABLA
--ENTERPRISE
insert into enterprise (id, name, document, phone, address, createdAt, updatedAt) values (1, 'Glaukos Corporation', '884300899-4', '3256792145', '91 Forest Run Court', '2021-11-12', null);
insert into enterprise (id, name, document, phone, address, createdAt, updatedAt) values (2, 'Neos Therapeutics', '698796256-1', '4633098542', '628 Memorial Place', '2021-10-31', null);

--PROFILE
insert into profile (id, image, phone, createdAt, updatedAt) values ('sspering0', 'https://robohash.org/nonmagniomnis.jpg?size=50x50&set=set1', '9229193390', '2021-10-20', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('malger1', 'https://robohash.org/eaeoshic.jpg?size=50x50&set=set1', '6542216361', '2022-04-04', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('hmccolm2', 'https://robohash.org/quianihilsequi.jpg?size=50x50&set=set1', '4266071065', '2022-01-17', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('rstansell3', 'https://robohash.org/vitaequaenecessitatibus.jpg?size=50x50&set=set1', '5125428405', '2021-11-10', '2021-11-03');
insert into profile (id, image, phone, createdAt, updatedAt) values ('rmackness4', 'https://robohash.org/necessitatibusdelenitiquasi.jpg?size=50x50&set=set1', '7945364670', '2022-05-30', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('rpellamont5', 'https://robohash.org/quiavoluptatibuset.jpg?size=50x50&set=set1', '3615467746', '2022-08-18', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('gricciardo6', 'https://robohash.org/hicvoluptasomnis.jpg?size=50x50&set=set1', '8094825802', '2022-08-23', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('kjanodet7', 'https://robohash.org/eiusquiaveniam.jpg?size=50x50&set=set1', '7425511286', '2021-12-27', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('gbollis8', null, '5041988912', '2022-03-16', null);
insert into profile (id, image, phone, createdAt, updatedAt) values ('hstapforth9', null, '9893067267', '2021-12-20', null);

--EMPLOYEE
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (1, 'ncoppen0@freewebs.com', 'sspering0', 'Operator', null, '2022-01-22', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (2, 'dnorcop1@cbsnews.com', 'malger1', 'Operator', null, '2022-04-04', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (3, 'idalligan2@hibu.com', 'hmccolm2', 'Admin', null, '2022-05-24', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (4, 'pjeffery3@bloomberg.com', 'rstansell3', 'Admin', null, '2021-12-15', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (5, 'hdanelet4@ca.gov', 'rmackness4', 'Admin', null, '2021-12-02', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (6, 'hgeikie5@narod.ru', 'rpellamont5', 'Admin', null, '2022-04-03', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (7, 'lhedling6@csmonitor.com', 'gricciardo6', 'Admin', null, '2021-10-11', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (8, 'slegrand7@gov.uk', 'kjanodet7', 'Operator', null, '2022-01-03', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (9, 'tmcgrorty8@youtu.be', 'gbollis8', 'Operator', null, '2021-10-12', null);
insert into employee (id, email, profile, role, enterprise, createdAt, updatedAt) values (10, 'scolleymore9@google.fr', 'hstapforth9', 'Admin', null, '2022-08-08', null);

--TRANSACTION
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (1, 'Coriander - Ground', 172.15, 7, 2, '2021-11-21', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (2, 'Godiva White Chocolate', 4336.11, 4, 2, '2022-08-11', '2021-10-31');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (3, 'Mushroom - Trumpet, Dry', -176.78, 6, 2, '2021-09-02', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (4, 'Sobe - Berry Energy', 3608.65, 7, 2, '2021-09-21', '2022-03-05');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (5, 'Sponge Cake Mix - Chocolate', 6658.08, 6, 2, '2021-11-25', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (6, 'Filter - Coffee', 7413.06, 2, 1, '2022-06-20', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (7, 'Bread - Malt', 970.17, 4, 2, '2021-11-27', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (8, 'Straw - Regular', 5761.11, 8, 1, '2022-03-15', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (9, 'Sugar - Brown, Individual', 7763.78, 8, 1, '2022-01-08', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (10, 'Sesame Seed Black', 1842.95, 7, 1, '2022-03-15', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (11, 'Coffee - Colombian, Portioned', 6366.25, 3, 1, '2022-03-25', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (12, 'Chocolate Bar - Oh Henry', 6348.05, 8, 2, '2022-01-17', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (13, 'Plastic Arrow Stir Stick', 2409.44, 9, 1, '2021-08-31', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (14, 'Pepper - Black, Whole', 188.54, 7, 2, '2021-10-05', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (15, 'Tabasco Sauce, 2 Oz', 5273.59, 6, 2, '2022-02-08', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (16, 'Sage - Fresh', 7408.94, 5, 1, '2022-05-07', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (17, 'Pie Filling - Cherry', 8937.73, 4, 1, '2022-07-17', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (18, 'Yogurt - Peach, 175 Gr', 9817.25, 3, 2, '2021-12-02', '2022-08-22');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (19, 'Appetizer - Spring Roll, Veg', 769.38, 10, 1, '2022-06-06', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (20, 'Pork Ham Prager', 9858.94, 7, 1, '2021-09-28', '2021-09-07');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (21, 'Cheese - Cheddar, Old White', 5178.02, 3, 1, '2022-07-06', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (22, 'Lobster - Baby, Boiled', 1007.45, 1, 2, '2022-04-21', '2021-09-25');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (23, 'Beer - Creemore', -669.2, 10, 1, '2022-08-12', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (24, 'Wine - George Duboeuf Rose', 6560.58, 10, 1, '2022-06-01', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (25, 'Flower - Commercial Spider', 6554.83, 3, 2, '2022-04-11', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (26, 'French Pastry - Mini Chocolate', 4147.87, 2, 2, '2022-05-14', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (27, 'Cucumber - English', 6596.98, 8, 2, '2022-04-10', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (28, 'Shallots', 5929.29, 5, 1, '2022-02-24', '2021-11-11');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (29, 'Veal - Bones', 5367.86, 1, 1, '2022-08-12', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (30, 'Cheese - Parmesan Cubes', 8391.14, 1, 1, '2022-04-20', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (31, 'Cookie - Oatmeal', 6190.37, 4, 1, '2021-10-16', '2022-04-02');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (32, 'Catfish - Fillets', 6917.65, 2, 1, '2022-01-21', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (33, 'Tuna - Yellowfin', 8510.85, 5, 1, '2022-08-04', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (34, 'Shrimp - Black Tiger 13/15', 8619.04, 5, 1, '2022-05-25', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (35, 'Black Currants', 7810.5, 5, 2, '2021-11-29', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (36, 'Snails - Large Canned', 1141.72, 8, 1, '2021-09-28', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (37, 'Vinegar - Raspberry', 2339.07, 8, 1, '2022-08-07', '2022-07-14');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (38, 'Seedlings - Clamshell', 862.87, 6, 1, '2022-07-28', '2021-08-26');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (39, 'Tuna - Sushi Grade', 4701.14, 8, 1, '2022-07-02', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (40, 'Bread - Burger', 572.97, 7, 1, '2021-09-09', '2022-05-19');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (41, 'Soup Campbells - Tomato Bisque', 6389.12, 5, 2, '2022-06-09', '2022-01-18');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (42, 'Cheese - Cheddar With Claret', 3698.88, 10, 1, '2022-08-14', '2021-10-26');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (43, 'Soup Campbells', 6477.63, 8, 2, '2021-12-03', '2022-05-26');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (44, 'Sauce - Fish 25 Ozf Bottle', 7556.64, 10, 1, '2021-12-29', '2022-06-07');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (45, 'Nori Sea Weed', 5288.3, 8, 2, '2022-02-19', '2022-04-30');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (46, 'Lamb - Bones', 39.17, 2, 2, '2021-09-17', '2022-03-16');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (47, 'Oil - Margarine', 7598.33, 4, 1, '2022-06-17', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (48, 'Appetizer - Escargot Puff', 558.65, 9, 1, '2021-10-02', '2022-08-07');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (49, 'Muffin - Mix - Creme Brule 15l', 267.97, 3, 1, '2021-08-26', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (50, 'Yeast Dry - Fleischman', 6095.59, 10, 1, '2022-07-24', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (51, 'Wine - Zinfandel California 2002', 719.88, 3, 2, '2021-11-01', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (52, 'Island Oasis - Strawberry', 9669.72, 6, 1, '2022-02-04', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (53, 'Appetizer - Assorted Box', 4949.73, 8, 1, '2021-12-05', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (54, 'Bread - Hot Dog Buns', 3544.65, 2, 2, '2021-10-13', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (55, 'Alize Gold Passion', 5372.8, 9, 2, '2022-05-12', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (56, 'Sping Loaded Cup Dispenser', 685.84, 10, 1, '2022-04-20', '2022-07-23');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (57, 'Beer - Camerons Auburn', 7828.4, 2, 1, '2022-04-16', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (58, 'Mcgillicuddy Vanilla Schnap', 6127.79, 4, 2, '2022-07-12', '2021-09-06');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (59, 'Hersey Shakes', 4329.98, 10, 1, '2021-11-01', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (60, 'Cucumber - Pickling Ontario', 9975.57, 3, 1, '2022-06-11', '2022-03-12');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (61, 'Lamb - Leg, Diced', 2104.48, 3, 1, '2021-10-04', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (62, 'Oneshot Automatic Soap System', 146.41, 7, 2, '2021-09-21', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (63, 'Salad Dressing', 7523.94, 8, 1, '2022-07-13', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (64, 'Mousse - Mango', 3403.53, 3, 2, '2022-06-04', '2022-06-15');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (65, 'Mints - Striped Red', 6818.34, 10, 2, '2021-10-17', '2022-02-26');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (66, 'Snapple - Iced Tea Peach', -326.31, 9, 2, '2022-07-14', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (67, 'Chocolate - Milk, Callets', 4004.03, 5, 2, '2021-12-08', '2022-08-21');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (68, 'Napkin Colour', 705.25, 7, 1, '2022-03-21', '2021-10-18');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (69, 'Capicola - Hot', 9626.53, 3, 2, '2021-10-10', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (70, 'Cheese - Roquefort Pappillon', 9346.02, 4, 1, '2022-07-26', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (71, 'Pasta - Lasagna, Dry', 2450.45, 6, 2, '2022-06-18', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (72, 'Pepper - Chipotle, Canned', 5364.02, 6, 1, '2022-03-24', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (73, 'Wine - Saint - Bris 2002, Sauv', 6540.19, 9, 2, '2022-07-26', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (74, 'Napkin - Cocktail,beige 2 - Ply', 1626.99, 3, 1, '2021-12-01', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (75, 'Chip - Potato Dill Pickle', 9081.82, 5, 2, '2021-11-13', '2022-07-15');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (76, 'Beef - Eye Of Round', 3367.61, 6, 2, '2022-06-09', '2021-09-01');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (77, 'Squid Ink', 6576.32, 8, 1, '2021-11-28', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (78, 'Peas Snow', -347.55, 8, 2, '2022-06-15', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (79, 'Nantucket - Orange Mango Cktl', 5891.73, 1, 2, '2022-06-04', '2022-06-28');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (80, 'Sauce Bbq Smokey', 3697.06, 4, 2, '2022-04-13', '2022-06-23');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (81, 'Kiwi', 6111.2, 10, 2, '2022-07-16', '2022-06-26');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (82, 'Avocado', 5011.81, 9, 1, '2021-12-06', '2021-11-24');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (83, 'Cake - Mini Potato Pancake', 5988.72, 8, 1, '2021-11-28', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (84, 'Nut - Pistachio, Shelled', -404.81, 4, 1, '2022-04-06', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (85, 'Pepper - White, Whole', 8171.71, 3, 2, '2022-06-10', '2022-03-14');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (86, 'Chips - Assorted', 8542.52, 2, 1, '2021-10-14', '2022-05-01');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (87, 'Sun - Dried Tomatoes', 279.37, 7, 2, '2022-04-12', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (88, 'Rosemary - Dry', 5267.03, 6, 2, '2022-04-06', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (89, 'Wine - Clavet Saint Emilion', 2016.61, 1, 2, '2022-02-02', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (90, 'Island Oasis - Pina Colada', 3341.92, 10, 2, '2022-04-15', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (91, 'Table Cloth 54x72 Colour', 525.63, 4, 1, '2022-04-18', '2022-03-29');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (92, 'Puff Pastry - Sheets', -886.65, 10, 1, '2022-08-22', '2022-08-19');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (93, 'Bacon Strip Precooked', -161.55, 5, 2, '2021-09-11', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (94, 'Cucumber - English', 3069.32, 2, 2, '2021-11-17', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (95, 'Papayas', 682.08, 10, 1, '2022-08-23', '2022-08-18');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (96, 'Mushroom - Porcini, Dry', 9151.63, 10, 2, '2021-11-08', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (97, 'Beans - Fava Fresh', 154.28, 6, 1, '2021-09-30', '2021-08-31');
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (98, 'Longos - Lasagna Veg', 3445.09, 7, 1, '2021-11-22', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (99, 'Sauce - Ranch Dressing', 4318.65, 6, 1, '2021-11-05', null);
insert into Transaction (id, concept, amount, employee, enterprise, createdAt, updatedAt) values (100, 'Vegetable - Base', 7279.75, 1, 1, '2022-06-10', null);