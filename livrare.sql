-- domeniu: livrare
-- tema: gestiunea pachetelor companiei DHL
-- 


CREATE DATABASE comp_livrare;
DROP DATABASE IF EXISTS comp_livrare;
USE comp_livrare;


drop table if exists client;
drop table if exists colete;
drop table if exists tara;
drop table if exists oras;

--clientii companiei noastre
create table clienti(
    idClient int PRIMARY KEY,
    idColet int,
    numeClient varchar(20),
    prenumeClient varchar(20),
    sex char(1),
    idnp varchar(13),

);


--coletele care sunt livrate clientilor

CREATE TABLE colete (
    idColet int PRIMARY KEY,
    tipColet VARCHAR(20),
    zileLivrare int,
    pretLivrare decimal(8,2),
    idTara int
)


--tarile in care se livreaza coletele

CREATE TABLE tari(
    idTara int PRIMARY KEY,
    numeTara VARCHAR(20)

)

CREATE TABLE orase(
    idOras int PRIMARY KEY,
    idTara int,
    numeOras VARCHAR(20)
)

-- relatii
ALTER TABLE orase
   ADD CONSTRAINT FK_oras_idTara
      FOREIGN KEY (idTara) REFERENCES tari (idTara)

ALTER TABLE colete
    ADD CONSTRAINT FK_colete_idTara
        FOREIGN KEY (idTara) REFERENCES tari(idTara)

ALTER TABLE clienti
    ADD CONSTRAINT FK_client_idColet
        FOREIGN KEY (idColet) REFERENCES colete(idColet)


INSERT INTO tari(idTara, numeTara)
VALUES(1, 'Brazilia'),
        (2, 'Franta'),
        (3, 'Anglia'),
        (4, 'Belarus')

INSERT INTO orase(idOras, idTara, numeOras)
    VALUES(1, 1, 'Peru'),
            (2, 2, 'Paris'),
            (3, 3, 'London'),
            (4, 4, 'Minsk')

INSERT INTO colete(idColet, tipColet, zileLivrare, pretLivrare, idTara)
VALUES (1, 'Haine gusi', 30, 50, 1),
        (2, 'Google pixel 4xl', 10, 300, 3),
        (3, 'Mercedes Benz SCLASS', 50, 1500, 4)

INSERT INTO clienti(idClient, idColet, numeClient, prenumeClient, sex, idnp)
VALUES (6, 2, 'Vasilescu', 'Andrei', 'M', '2222555566666'),
       (7, 3, 'Donici', 'Vasile', 'M', '3222555566666'),
       (8, 1, 'Dariu', 'Dan', 'M', '2224555566666'),
       (9, 2, 'Valomic', 'Sergiu', 'M', '2252555566666'),
       (10, 2, 'Felomn', 'Anatol', 'M', '2622555566666')


	   -- de elaborat 2 interogari utilizind viziuni si functii (procedura stocata cu delete) 

-- CLIENTI CU SEX MASCULIN
SELECT numeClient, prenumeClient, sex
FROM client
WHERE sex = 'M'

-- COLETE CAROR LIVRARE DUREAZA MAI MULT DE 30 ZILE
SELECT * FROM colete WHERE zileLivrare >= 30

-- ORASE DESTINATARE
SELECT * FROM oras


-- procedura stocata care arata toti clientii cu numele Andrei
CREATE PROCEDURE prenumeAndrei AS
SELECT * FROM client WHERE prenumeClient = 'Andrei'

exec prenumeAndrei





--procedura care adauga o inregistrare in tabela [tari] 

DROP PROCEDURE IF EXISTS test3;
GO
CREATE PROCEDURE test3
@idTara int ,
@numeTara varchar(10)

AS

BEGIN
insert into tari(idTara, numeTara)values(
@idTara, @numeTara);
END

select *from tari;
execute test3 @idTara=5,@numeTara='Moldova';
select *from tari;



--o procedura care sterge o inregistrare din tabela [tari]

DROP PROCEDURE IF EXISTS p_drop
GO
CREATE PROCEDURE p_drop
@Conditia int
AS

DELETE  from tari where idTara =@Conditia;


select *from tari;
EXECUTE p_drop @Conditia=5;
select *from tari;



