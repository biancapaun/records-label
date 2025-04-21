insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (
           'Taylor Swift',
           'Taylor Alison Swift',
           to_date('1989-12-13', 'YYYY-MM-DD'),
           'USA' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (
           'Ed Sheeran',
           'Edward Christopher Sheeran',
           to_date('1991-02-17', 'YYYY-MM-DD'),
           'UK' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (
           'Beyoncé',
           'Beyoncé Giselle Knowles-Carter',
           to_date('1981-09-04', 'YYYY-MM-DD'),
           'USA' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (           'Drake',
           'Aubrey Drake Graham',
           to_date('1986-10-24', 'YYYY-MM-DD'),
           'Canada' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (           'Billie Eilish',
           'Billie Eilish Pirate',
           to_date('2001-12-18', 'YYYY-MM-DD'),
           'USA' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (           'The Weeknd',
           'Abel Makkonen Tesfaye',
           to_date('1990-02-16', 'YYYY-MM-DD'),
           'Canada' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (           'Ariana Grande',
           'Ariana Grande-Butera',
           to_date('1993-06-26', 'YYYY-MM-DD'),
           'USA' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (           'Harry Styles',
           'Harry Edward Styles',
           to_date('1994-02-01', 'YYYY-MM-DD'),
           'UK' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (           'Dua Lipa',
           'Dua Lipa',
           to_date('1995-08-22', 'YYYY-MM-DD'),
           'UK' );

insert into artist (
    nume_scena,
    nume_real,
    data_nasterii,
    tara_origine
) values (           'Olivia Rodrigo',
           'Olivia Isabel Rodrigo',
           to_date('2003-02-20', 'YYYY-MM-DD'),
           'USA' );


-- Inregistrari in tabelul gen_muzical
insert into gen_muzical (
    nume_gen
) values (           'Pop' );

insert into gen_muzical (
    nume_gen
) values (           'Rock' );

insert into gen_muzical (
    nume_gen
) values (           'Hip-Hop' );

insert into gen_muzical (
    nume_gen
) values (           'Jazz' );

insert into gen_muzical (
    nume_gen
) values (           'Classical' );

insert into gen_muzical (
    nume_gen
) values (           'Electronic' );

insert into gen_muzical (
    nume_gen
) values (           'Reggae' );

insert into gen_muzical (
    nume_gen
) values (           'Folk' );

insert into gen_muzical (
    nume_gen
) values (           'Blues' );

insert into gen_muzical (
    nume_gen
) values (           'Country' );


-- tabelul album
insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Midnights',
           to_date('2022-10-21', 'YYYY-MM-DD'),
           1,
           1 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           '÷ (Divide)',
           to_date('2017-03-03', 'YYYY-MM-DD'),
           2,
           3 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Lemonade',
           to_date('2016-04-23', 'YYYY-MM-DD'),
           3,
           4 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Scorpion',
           to_date('2018-06-29', 'YYYY-MM-DD'),
           4,
           5 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'When We All Fall Asleep, Where Do We Go?',
           to_date('2019-03-29', 'YYYY-MM-DD'),
           5,
           6 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'After Hours',
           to_date('2020-03-20', 'YYYY-MM-DD'),
           6,
           6 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Positions',
           to_date('2020-10-30', 'YYYY-MM-DD'),
           7,
           8 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'House of Harry',
           to_date('2022-05-20', 'YYYY-MM-DD'),
           8,
           2 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Future Nostalgia',
           to_date('2020-03-27', 'YYYY-MM-DD'),
           9,
           10 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'SOUR',
           to_date('2021-05-21', 'YYYY-MM-DD'),
           10,
           9 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Inocent souls',
           to_date('2020-10-30', 'YYYY-MM-DD'),
           7,
           8 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Golden stars',
           to_date('2022-05-20', 'YYYY-MM-DD'),
           7,
           2 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Future together',
           to_date('2020-03-27', 'YYYY-MM-DD'),
           7,
           10 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Wanderland',
           to_date('2021-05-21', 'YYYY-MM-DD'),
           7,
           9 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Growth',
           to_date('2020-10-30', 'YYYY-MM-DD'),
           6,
           8 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'A new beginning',
           to_date('2022-05-20', 'YYYY-MM-DD'),
           6,
           2 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'My life',
           to_date('2020-10-30', 'YYYY-MM-DD'),
           4,
           8 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Dare to cry',
           to_date('2022-05-20', 'YYYY-MM-DD'),
           4,
           2 );

insert into album (
    titlu,
    data_lansare,
    id_artist,
    id_gen
) values (           'Surrender',
           to_date('2022-05-20', 'YYYY-MM-DD'),
           4,
           2 );




-- tabelul label;
insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Global music',
           'Spain',
           1990 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Rock music',
           'Irland',
           1992 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Jazz House',
           'Germany',
           1995 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Soul Sounds',
           'Italy',
           1998 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Classic Records',
           'France',
           2000 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Electro Beats',
           'Germany',
           2002 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Reggae Studio',
           'Italy',
           2005 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Folk Legends',
           'Spain',
           2008 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Cat music',
           'Romania',
           2010 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Rotton music',
           'Romania',
           2012 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'New Age Records',
           'USA',
           2009 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Epic Records',
           'SUA',
           1985 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Island Records',
           'UK',
           1970 );

insert into label (
    nume_label,
    tara_origine,
    an_infiintare
) values (           'Universal Music',
           'UK',
           1980 );


-- tabelul producator;
insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'John Smith ',
           'Pop',
           'Spain' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'Laura Rock',
           'Rock',
           'Irland' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'July Jazz',
           'Jazz',
           'Germany' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'Anna Soul',
           'Soul',
           'Italy' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'Tedd Classical',
           'Classical',
           'France' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'David Electro',
           'Electronic',
           'Germany' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'Bob Marley',
           'Reggae',
           'Italy' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'Sara Folk',
           'Folk',
           'Spain' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'Blues King',
           'Blues',
           'Romania' );

insert into producator (
    nume,
    specializare,
    tara_origine
) values (           'Country Joe',
           'Country',
           'Romania' );


-- tabelul piesa
insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'Anti-Hero',
           interval '3:21' minute to second,
           1,
           1 );

insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'Shape of You',
           interval '3:53' minute to second,
           2,
           3 );

insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'Formation',
           interval '4:52' minute to second,
           3,
           4 );

insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'God Plan',
           interval '3:18' minute to second,
           4,
           5 );

insert into piesa (
    durata,
    id_album,
    id_gen
) values (           'Bad Guy',
           interval '3:14' minute to second,
           5,
           6 );

insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'Blinding Lights',
           interval '3:20' minute to second,
           6,
           6 );

insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'Positions',
           interval '2:52' minute to second,
           7,
           8 );

insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'As It Was',
           interval '2:47' minute to second,
           8,
           2 );

insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'Do not Start Now',
           interval '3:03' minute to second,
           9,
           1 );



insert into piesa (
    titlu,
    durata,
    id_album,
    id_gen
) values (           'Heroes',
           interval '6:02' minute to second,
           1,
           1 );


--tabelul contract
insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2015-01-01', 'YYYY-MM-DD'),
           to_date('2025-01-01', 'YYYY-MM-DD'),
           1,
           1 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2016-03-01', 'YYYY-MM-DD'),
           null,
           2,
           2 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2012-05-10', 'YYYY-MM-DD'),
           to_date('2022-05-10', 'YYYY-MM-DD'),
           3,
           3 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2017-08-15', 'YYYY-MM-DD'),
           to_date('2027-08-15', 'YYYY-MM-DD'),
           4,
           4 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2018-12-01', 'YYYY-MM-DD'),
           to_date('2028-12-01', 'YYYY-MM-DD'),
           5,
           5 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2016-10-20', 'YYYY-MM-DD'),
           null,
           6,
           6 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2014-09-25', 'YYYY-MM-DD'),
           to_date('2024-09-25', 'YYYY-MM-DD'),
           7,
           7 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2020-01-01', 'YYYY-MM-DD'),
           to_date('2030-01-01', 'YYYY-MM-DD'),
           8,
           8 );

insert into contract (
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2019-03-15', 'YYYY-MM-DD'),
           null,
           9,
           9 );




insert into contract (
    id_contract,
    data_start,
    data_incheiere,
    id_artist,
    id_label
) values (           to_date('2017-01-01', 'YYYY-MM-DD'),
           to_date('2021-01-01', 'YYYY-MM-DD'),
           12,
           12 );





--tabelul premiu
insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Grammy',
           'Album of the Year',
           2021,
           1 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Grammy',
           'Song of the Year',
           2018,
           2 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Grammy',
           'Best R&B Performance',
           2017,
           3 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Billboard',
           'Top Rap Artist',
           2019,
           4 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Grammy',
           'Best New Artist',
           2020,
           5 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'MTV',
           'Best Music Video',
           2021,
           6 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Grammy',
           'Best Pop Vocal Album',
           2021,
           7 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'BRIT Award',
           'British Album of the Year',
           2022,
           8 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Grammy',
           'Best Dance Recording',
           2020,
           9 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Billboard',
           'Top New Artist',
           2021,
           10 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'BRIT Award',
           'Top New Artist',
           2017,
           10 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Grammy',
           'Best music video',
           2017,
           10 );

insert into premiu (
    nume,
    categorie,
    an,
    id_artist
) values (           'Billboard',
           'Best New Artist',
           2017,
           7 );


-- tabelul productie (asociere album-producator)
insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 1,
           1,
           'Studio Album',
           500000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 2,
           2,
           'Live Performance',
           300000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 3,
           3,
           'Studio Album',
           600000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 4,
           4,
           'Studio Album',
           450000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 5,
           5,
           'EP',
           200000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 6,
           6,
           'Studio Album',
           700000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 7,
           7,
           'Single',
           150000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 8,
           8,
           'Studio Album',
           500000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 9,
           9,
           'Studio Album',
           550000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 10,
           10,
           'EP',
           300000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 1,
           2,
           'Remix',
           200000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 2,
           3,
           'Live Performance',
           250000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 3,
           4,
           'Collaboration',
           400000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 4,
           5,
           'Single',
           180000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 5,
           6,
           'Remix',
           220000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 6,
           7,
           'Studio Album',
           650000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 7,
           8,
           'Collaboration',
           300000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 8,
           9,
           'Live Performance',
           400000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 9,
           10,
           'Single',
           350000.00 );

insert into productie (
    id_album,
    id_producator,
    tip_productie,
    buget
) values ( 10,
           1,
           'Collaboration',
           450000.00 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES ('Anti-Hero',
           1,
           1 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Shape of You',
           2,
           3 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Formation',
           3,
           4 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'God Plan',
           4,
           5 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Bad Guy',
           5,
           6 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Blinding Lights',
           6,
           6 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Positions',
           7,
           8 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'As It Was',
           8,
           2 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Do not Start Now',
           9,
           1 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Drivers License',
           10,
           10 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Heroes',
           1,
           1 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Ocean Drive',
           2,
           1 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Skyline',
           5,
           2 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Dream Catcher',
           2,
           1 );

INSERT INTO piesa (
    titlu,
    id_album,
    id_gen
) VALUES (
           'Dream',
           7,
           1 );

INSERT INTO adrese_label (
    strada,
    localitate,
    id_label
) VALUES ( 'Strada Muzicii 1',
           'Bucuresti',
           1 );

INSERT INTO adrese_label (
    strada,
    localitate,
    id_label
) VALUES ( 'Aleea Sonoră 10',
           'Cluj-Napoca',
           2 );

INSERT INTO adrese_label (
    strada,
    localitate,
    id_label
) VALUES ( 'Jazz Avenue 7',
           'Timisoara',
           3 );

INSERT INTO adrese_label (
    strada,
    localitate,
    id_label
) VALUES ( 'Pop Street 99',
           'Constanta',
           4 );
