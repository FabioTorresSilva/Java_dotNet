-- ** criar tabelas **

CREATE TABLE cd (
    codCd          INTEGER CONSTRAINT pkCdCod PRIMARY KEY,
    titulo         VARCHAR(40) CONSTRAINT nnCdTitulo NOT NULL,
    dataCompra     DATE,
    valorPago      NUMERIC(5,2),
    localCompra    VARCHAR(20)
);

CREATE TABLE musica (
    nrMusica    INTEGER,
    codCd       INTEGER,    
    titulo      VARCHAR(40) CONSTRAINT nnMusicaNome NOT NULL,
    interprete  VARCHAR(30) CONSTRAINT nnMusicaInterprete NOT NULL,
    duracao     NUMERIC(4,2),
    
    CONSTRAINT pkMusicaNrMusicaCodCd  PRIMARY KEY (codCd, nrMusica)
);

ALTER TABLE musica ADD CONSTRAINT fkMusicaCodCd FOREIGN KEY (codCd) REFERENCES cd (codCd);
