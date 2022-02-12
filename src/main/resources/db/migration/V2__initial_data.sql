INSERT INTO role VALUES
    (0, 'ROLE_USER'),
    (1, 'ROLE_ADMIN')
;

INSERT INTO account VALUES
    (0, 'admin', '$2y$12$bRzgIgSedb05g0SOSGh5FOicEtoiXLPCUaOMnrT24ZjT3RWYME2bC', true)
;

INSERT INTO account_role VALUES
    (0, 0, 1)
;

INSERT INTO book VALUES
    (0,'Harry Potter','fantasy',1996,'wizard',6,true),
    (1,'War and Peace','fantasy',1700,'world war',5,true),
    (2,'Death souls','roman',1841,'Gogol just dumb',3,true),
    (3,'Harry Potter3','fantasy',1996,'wizard3',0,false),
    (4,'Fight Club','fantasy',1996,'best book',6,true),
    (5,'Stalker','fantasy',1984,'interesting book',8,true),
    (6,'NLP','psychology',1965,'about psychology',6,true),
    (7,'Encyclopedia','science',1923,'wizard',7,true),
    (8,'Dictionary','learning',1900,'English',4,true),
    (9,'Harry Potter 2','fantasy',1998,'wizard2',7,true)
;

INSERT INTO reader VALUES
    (0,'John','Lennon','j-lennon@mail.ru',000001,5485695,100,'1980-02-08'),
    (1,'Kurt','Cobain','kurt-cob@mail.ru',000002,5485695,90,'1994-01-07'),
    (2,'Karl','First','k-first@mail.ru',000003,5485695,50,'1980-02-08'),
    (3,'Freddy','Cruger','f-cruggy@mail.ru',000004,3485695,50,'1980-02-08'),
    (4,'Victor','Tsoi','kino@mail.ru',000005,5385695,50,'1980-02-08'),
    (5,'Bill','Gates','billy@mail.ru',000006,5485295,50,'1980-03-08'),
    (6,'Brad','Pitt','brad-pit@mail.ru',000007,5485495,50,'1645-02-08'),
    (7,'Alex','Ivanov','a-ivanov@mail.ru',000008,5485695,50,'1945-02-08'),
    (8,'Vladimir','Ruiner','ruin@mail.ru',000009,5485696,50,'1998-03-06'),
    (9,'Radio','Head','radiohead@mail.ru',000010,5485695,50,'1988-04-05')
;

INSERT INTO record VALUES
    (0, 1, 1, '2020-01-20','2021-04-22','2021-04-22'),
    (1, 3, 1, '2020-01-20','2021-04-22','2021-04-22'),
    (2, 4, 2, '2018-02-02','2021-10-22','2022-01-12'),
    (3, 7, 5, '2020-01-08','2021-04-22','2021-04-16'),
    (4, 7, 6, '2020-01-09','2021-07-22','2021-06-12'),
    (5, 6, 3, '2021-01-20','2017-04-22','2021-04-22'),
    (6, 8, 3, '2020-01-20','2016-04-22','2021-07-22'),
    (7, 5, 3, '2020-01-20','2019-03-22','2021-04-20'),
    (8, 3, 1, '2020-01-20','2021-02-22','2021-04-15'),
    (9, 1, 1, '2020-01-20','2021-04-22','2021-02-27')
;

INSERT INTO author VALUES
    (0,'Usual','Teacher'),
    (1,'Alex','Pushkin'),
    (2,'Nikolay','Gogol'),
    (3,'Chuck','Palanack'),
    (4,'Joan','Roalling'),
    (5,'Brothers','Strugatsckie'),
    (6,'Lev','Tolstoy')
;

INSERT INTO author_book VALUES
    (0,0,6),
    (1,0,7),
    (2,2,2),
    (3,3,4),
    (4,4,0),
    (5,4,9),
    (6,5,5),
    (7,6,1),
    (8,0,8),
    (9,4,3)
;

INSERT INTO reader_book VALUES
    (0,0,6),
    (1,1,7),
    (2,2,2),
    (3,3,4),
    (4,5,0),
    (5,5,9),
    (6,5,5),
    (7,6,1),
    (8,7,8),
    (9,4,3)
;

