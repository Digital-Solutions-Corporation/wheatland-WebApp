-- drop tables comentados, para caso de necessidade de delecao das tabelas
DROP TABLE TB_TRANSACAO CASCADE CONSTRAINTS;
DROP TABLE TB_ONG CASCADE CONSTRAINTS;
DROP TABLE TB_USUARIO CASCADE CONSTRAINTS;

CREATE TABLE TB_TRANSACAO (
    ID_TRANSACAO NUMBER(12) NOT NULL,
    ID_ONG NUMBER(12) NOT NULL,
    ID_USUARIO NUMBER(12) NOT NULL,
    NM_USUARIO VARCHAR2(200 CHAR) NOT NULL,
    NM_ONG VARCHAR2(200 CHAR) NOT NULL,
    VL_DOACAO NUMBER(6, 2) NOT NULL,
    DT_DOACAO TIMESTAMP NOT NULL,
    DS_MENSAGEM VARCHAR2(1000 CHAR)
);

ALTER TABLE TB_TRANSACAO 
        ADD CONSTRAINT PK_TRANSACAO PRIMARY KEY (ID_TRANSACAO);

CREATE TABLE TB_ONG (
    ID_ONG NUMBER(12) NOT NULL,
    CNPJ_ONG NUMBER(14) NOT NULL,
    NM_ONG VARCHAR2(200 CHAR) NOT NULL,
    DS_EMAIL_ONG VARCHAR2(200 CHAR) NOT NULL,
    DS_SENHA_ONG VARCHAR2(20 CHAR) NOT NULL,
    DS_URL_FOTO_ONG VARCHAR2 (500 CHAR) 
);

ALTER TABLE TB_ONG 
        ADD CONSTRAINT PK_ONG PRIMARY KEY (ID_ONG);

CREATE TABLE TB_USUARIO (
    ID_USUARIO NUMBER(12) NOT NULL,
    CPF_USUARIO NUMBER(11) NOT NULL,
    NM_USUARIO VARCHAR2(200 CHAR) NOT NULL,
    DS_EMAIL_USUARIO VARCHAR2(200 CHAR) NOT NULL,
    DS_SENHA_USUARIO VARCHAR2(20 CHAR) NOT NULL,
    DS_URL_FOTO_USUARIO VARCHAR2 (500 CHAR),
    NR_IDADE_USUARIO NUMBER(3),
    DS_GENERO VARCHAR2(2 CHAR)
);
ALTER TABLE TB_USUARIO 
        ADD CONSTRAINT PK_USUARIO PRIMARY KEY (ID_USUARIO);

ALTER TABLE TB_USUARIO
        ADD CONSTRAINT UN_USUARIO UNIQUE (   CPF_USUARIO,
                                                                                    DS_EMAIL_USUARIO,
                                                                                    DS_SENHA_USUARIO );

ALTER TABLE TB_ONG
        ADD CONSTRAINT UN_ONG UNIQUE (   CNPJ_ONG,
                                                                            DS_EMAIL_ONG,
                                                                            DS_SENHA_ONG );      
                                                                         
ALTER TABLE TB_TRANSACAO
        ADD CONSTRAINT FK_TRANSACAO_ONG FOREIGN KEY ( ID_ONG )
        REFERENCES TB_ONG ( ID_ONG )
        ON DELETE CASCADE;                                                            
                                                                                
ALTER TABLE TB_TRANSACAO
        ADD CONSTRAINT FK_TRANSACAO_USUARIO FOREIGN KEY ( ID_USUARIO )
        REFERENCES TB_USUARIO ( ID_USUARIO )
        ON DELETE CASCADE;    
                                                                                