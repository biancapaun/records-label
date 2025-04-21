-- ARTIST
CREATE TABLE artist (
    id_artist INTEGER AUTO_INCREMENT PRIMARY KEY,
    nume_scena VARCHAR(50) NOT NULL,
    nume_real VARCHAR(100),
    data_nasterii DATE,
    tara_origine VARCHAR(50) DEFAULT 'Necunoscut'
);

-- GEN_MUZICAL
CREATE TABLE gen_muzical (
    id_gen INTEGER AUTO_INCREMENT PRIMARY KEY,
    nume_gen VARCHAR(50) NOT NULL
);

-- ALBUM
CREATE TABLE album (
    id_album INTEGER AUTO_INCREMENT PRIMARY KEY,
    titlu VARCHAR(100) NOT NULL,
    data_lansare DATE,
    id_artist INTEGER,
    id_gen INTEGER,
    CONSTRAINT fk_album_artist FOREIGN KEY (id_artist) REFERENCES artist(id_artist),
    CONSTRAINT fk_album_gen FOREIGN KEY (id_gen) REFERENCES gen_muzical(id_gen)
);

-- PIESE
CREATE TABLE piesa (
    id_piesa INTEGER AUTO_INCREMENT PRIMARY KEY,
    titlu VARCHAR(100) NOT NULL,
    id_album INTEGER,
    id_gen INTEGER,
    CONSTRAINT fk_piesa_album FOREIGN KEY (id_album) REFERENCES album(id_album),
    CONSTRAINT fk_piesa_gen FOREIGN KEY (id_gen) REFERENCES gen_muzical(id_gen)
);

-- PREMIU
CREATE TABLE premiu (
    id_premiu INTEGER AUTO_INCREMENT PRIMARY KEY,
    nume VARCHAR(100),
    categorie VARCHAR(100),
    an INTEGER,
    id_artist INTEGER,
    CONSTRAINT fk_premiu_artist FOREIGN KEY (id_artist) REFERENCES artist(id_artist)
);

-- LABEL
CREATE TABLE label (
    id_label INTEGER AUTO_INCREMENT PRIMARY KEY,
    nume_label VARCHAR(100) NOT NULL,
    tara_origine VARCHAR(50),
    an_infiintare INTEGER,
    id_adrese INTEGER
);

-- ADRESE_LABEL
CREATE TABLE adrese_label (
    id_adrese INTEGER AUTO_INCREMENT PRIMARY KEY,
    localitate VARCHAR(100),
    strada VARCHAR(100),
    id_label INTEGER,
    CONSTRAINT adrese_label_fk FOREIGN KEY (id_label) REFERENCES label(id_label)
);

-- CONTRACT
CREATE TABLE contract (
    id_contract INTEGER AUTO_INCREMENT PRIMARY KEY,
    id_artist INTEGER,
    id_label INTEGER,
    data_start DATE,
    data_incheiere DATE,
    CONSTRAINT fk_contract_artist FOREIGN KEY (id_artist) REFERENCES artist(id_artist),
    CONSTRAINT fk_contract_label FOREIGN KEY (id_label) REFERENCES label(id_label)
);

-- COLABORARE
CREATE TABLE colaborare (
    id_artist INTEGER,
    id_piesa INTEGER,
    PRIMARY KEY (id_artist, id_piesa),
    CONSTRAINT fk_colab_artist FOREIGN KEY (id_artist) REFERENCES artist(id_artist),
    CONSTRAINT fk_colab_piesa FOREIGN KEY (id_piesa) REFERENCES piesa(id_piesa)
);

-- UTILIZATOR
CREATE TABLE utilizator (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255),
    nume VARCHAR(255),
    prenume VARCHAR(255),
    role VARCHAR(50) NOT NULL
);

-- PRODUCATOR
CREATE TABLE producator (
    id_producator INTEGER AUTO_INCREMENT PRIMARY KEY,
    nume VARCHAR(100) NOT NULL,
    specializare VARCHAR(50),
    tara_origine VARCHAR(50) DEFAULT 'Necunoscut'
);

-- PRODUCTIE
CREATE TABLE productie (
    id_album INTEGER,
    id_producator INTEGER,
    tip_productie VARCHAR(50) NOT NULL,
    buget DECIMAL(12, 2) NOT NULL,
    CONSTRAINT productie_buget_pozitiv CHECK (buget > 0),
    CONSTRAINT productie_pk PRIMARY KEY (id_album, id_producator),
    CONSTRAINT productie_id_album_fk FOREIGN KEY (id_album) REFERENCES album(id_album),
    CONSTRAINT productie_id_producator_fk FOREIGN KEY (id_producator) REFERENCES producator(id_producator)
);
