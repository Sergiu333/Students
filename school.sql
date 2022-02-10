CREATE TABLE `users` (
  `idusers` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) NOT NULL,
  `prenume` varchar(45) NOT NULL,
  `patronimic` varchar(45) NOT NULL,
  `data` varchar(45) NOT NULL,
  `adresa` varchar(45) NOT NULL,
  `specialitate` varchar(45) NOT NULL,
  `grupa` varchar(45) NOT NULL,
  `telefon` varchar(45) NOT NULL,
  `anul` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idusers`));

CREATE TABLE `note` (
  `idnote` int NOT NULL AUTO_INCREMENT,
  `obiectul` varchar(45) ,
  `nota` varchar(45) ,
  `dataN` varchar(45) ,
   idusers int ,
  PRIMARY KEY (`idnote`));
  
  Alter Table note Add Foreign Key (idusers) references users(idusers);
  
select users.nume , note.nota from users inner join note on users.idusers =note.idusers; 

select users.nume, users.prenume, note.nota , note.dataN from users inner join note on users.idusers =note.idusers;

select users.nume, users.prenume, note.nota , note.dataN from users inner join note on users.idusers =note.idusers  ORDER BY nume ASC ; 

select users.nume, users.prenume, note.nota , note.dataN from users inner join note on users.idusers =note.idusers where grupaN='P-1932' and obiectul='Matemateca' ORDER BY nume ASC ;  /*aranjare dupa alfabet a notelor*/

select *from note where dataN BETWEEN '2021-09-01' AND '2021-09-31'; /*afiseaza datele dintr-o perioada setata*/

select obiectul, nota from note where obiectul='Matemateca'and idusers=7;

/*delete*/ 
select * from users;
delete from users where idusers=1;

DELETE users, note
FROM users
INNER JOIN note ON users.idusers = note.idusers
WHERE idusers=1;

DELETE users,note FROM users
        INNER JOIN
    note ON note.idnote = users.idusers 
WHERE
    users.idusers = 1 and note.idnote=1;


delete from note where note.idusers=1 and users.id;
delete from users where idusers=1;
	
    
    SELECT *FROM note;
SELECT  count(nota)
FROM note where nota="a" and idusers='1';
GROUP BY Continent


SELECT * FROM note where idusers='1' and nota='a' (SELECT  count(nota)FROM note);

SELECT count(nota)FROM note where nota='a' and idusers='1';
count(nota)













USE Asus-Store
GO
DROP PROCEDURE IF EXISTS GetAllProducts;
GO
DELIMITER //

CREATE PROCEDURE GetAllProducts()
BEGIN
	SELECT *  FROM note;
END //

DELIMITER ;