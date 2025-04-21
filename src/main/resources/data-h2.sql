INSERT INTO artist (nume_scena, nume_real, data_nasterii, tara_origine)
VALUES
('Taylor Swift', 'Taylor Alison Swift', DATE '1989-12-13', 'USA'),
('Ed Sheeran', 'Edward Christopher Sheeran', DATE '1991-02-17', 'UK'),
('Beyoncé', 'Beyoncé Giselle Knowles-Carter', DATE '1981-09-04', 'USA'),
('Drake', 'Aubrey Drake Graham', DATE '1986-10-24', 'Canada'),
('Billie Eilish', 'Billie Eilish Pirate', DATE '2001-12-18', 'USA'),
('The Weeknd', 'Abel Makkonen Tesfaye', DATE '1990-02-16', 'Canada'),
('Ariana Grande', 'Ariana Grande-Butera', DATE '1993-06-26', 'USA'),
('Harry Styles', 'Harry Edward Styles', DATE '1994-02-01', 'UK'),
('Dua Lipa', 'Dua Lipa', DATE '1995-08-22', 'UK'),
('Olivia Rodrigo', 'Olivia Isabel Rodrigo', DATE '2003-02-20', 'USA');

INSERT INTO gen_muzical (nume_gen)
VALUES
('Pop'), ('Rock'), ('Hip-Hop'), ('Jazz'), ('Classical'),
('Electronic'), ('Reggae'), ('Folk'), ('Blues'), ('Country');

INSERT INTO label (nume_label, tara_origine, an_infiintare)
VALUES
('Global music', 'Spain', 1990),
('Rock music', 'Irland', 1992),
('Jazz House', 'Germany', 1995),
('Soul Sounds', 'Italy', 1998),
('Classic Records', 'France', 2000),
('Electro Beats', 'Germany', 2002),
('Reggae Studio', 'Italy', 2005),
('Folk Legends', 'Spain', 2008),
('Cat music', 'Romania', 2010),
('Rotton music', 'Romania', 2012),
('New Age Records', 'USA', 2009),
('Epic Records', 'SUA', 1985),
('Island Records', 'UK', 1970),
('Universal Music', 'UK', 1980);

INSERT INTO producator (nume, specializare, tara_origine)
VALUES
('John Smith', 'Pop', 'Spain'),
('Laura Rock', 'Rock', 'Irland'),
('July Jazz', 'Jazz', 'Germany'),
('Anna Soul', 'Soul', 'Italy'),
('Tedd Classical', 'Classical', 'France'),
('David Electro', 'Electronic', 'Germany'),
('Bob Marley', 'Reggae', 'Italy'),
('Sara Folk', 'Folk', 'Spain'),
('Blues King', 'Blues', 'Romania'),
('Country Joe', 'Country', 'Romania');

INSERT INTO adrese_label (strada, localitate, id_label)
VALUES
('Strada Muzicii 1', 'Bucuresti', 1),
('Aleea Sonoră 10', 'Cluj-Napoca', 2),
('Jazz Avenue 7', 'Timisoara', 3),
('Pop Street 99', 'Constanta', 4);

INSERT INTO album (titlu, data_lansare, id_artist, id_gen) VALUES
('Midnights', DATE '2022-10-21', 1, 1),
('÷ (Divide)', DATE '2017-03-03', 2, 3),
('Lemonade', DATE '2016-04-23', 3, 4),
('Scorpion', DATE '2018-06-29', 4, 5),
('When We All Fall Asleep, Where Do We Go?', DATE '2019-03-29', 5, 6),
('After Hours', DATE '2020-03-20', 6, 6),
('Positions', DATE '2020-10-30', 7, 8),
('House of Harry', DATE '2022-05-20', 8, 2),
('Future Nostalgia', DATE '2020-03-27', 9, 10),
('SOUR', DATE '2021-05-21', 10, 9);

INSERT INTO piesa (titlu, id_album, id_gen) VALUES
('Anti-Hero', 1, 1),
('Shape of You', 2, 3),
('Formation', 3, 4),
('God Plan', 4, 5),
('Bad Guy', 5, 6),
('Blinding Lights', 6, 6),
('Positions', 7, 8),
('As It Was', 8, 2),
('Do not Start Now', 9, 1),
('Drivers License', 10, 10);

INSERT INTO contract (data_start, data_incheiere, id_artist, id_label) VALUES
(DATE '2015-01-01', DATE '2025-01-01', 1, 1),
(DATE '2016-03-01', NULL, 2, 2),
(DATE '2012-05-10', DATE '2022-05-10', 3, 3),
(DATE '2017-08-15', DATE '2027-08-15', 4, 4),
(DATE '2018-12-01', DATE '2028-12-01', 5, 5),
(DATE '2016-10-20', NULL, 6, 6),
(DATE '2014-09-25', DATE '2024-09-25', 7, 7),
(DATE '2020-01-01', DATE '2030-01-01', 8, 8),
(DATE '2019-03-15', NULL, 9, 9);

INSERT INTO premiu (nume, categorie, an, id_artist) VALUES
('Grammy', 'Album of the Year', 2021, 1),
('Grammy', 'Song of the Year', 2018, 2),
('Grammy', 'Best R&B Performance', 2017, 3),
('Billboard', 'Top Rap Artist', 2019, 4),
('Grammy', 'Best New Artist', 2020, 5),
('MTV', 'Best Music Video', 2021, 6),
('Grammy', 'Best Pop Vocal Album', 2021, 7),
('BRIT Award', 'British Album of the Year', 2022, 8),
('Grammy', 'Best Dance Recording', 2020, 9),
('Billboard', 'Top New Artist', 2021, 10);

INSERT INTO productie (id_album, id_producator, tip_productie, buget) VALUES
(1, 1, 'Studio Album', 500000.00),
(2, 2, 'Live Performance', 300000.00),
(3, 3, 'Studio Album', 600000.00),
(4, 4, 'Studio Album', 450000.00),
(5, 5, 'EP', 200000.00),
(6, 6, 'Studio Album', 700000.00),
(7, 7, 'Single', 150000.00),
(8, 8, 'Studio Album', 500000.00),
(9, 9, 'Studio Album', 550000.00),
(10, 10, 'EP', 300000.00);

INSERT INTO colaborare (id_artist, id_piesa) VALUES
(2, 1),
(3, 2),
(4, 3),
(1, 4),
(6, 5),
(4, 5),
(5, 6),
(9, 7),
(7, 8),
(8, 9),
(10, 10);
