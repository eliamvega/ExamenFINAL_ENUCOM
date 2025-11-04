CREATE TABLE CATEGORIA (
    ID_CATEGORIA NUMBER,
    NOMBRE NVARCHAR2(100),             -- Ej: Aventura, Estrategia
    GENERO NVARCHAR2(50),              -- Ej: RPG, Shooter
    EDAD_MINIMA NUMBER,                -- Edad mínima recomendada
    ES_MULTIJUGADOR NUMBER(1),        -- 1 = sí, 0 = no
    FECHA_CREACION DATE,              -- Fecha de creación o alta
    CONSTRAINT CATEGORIA_PK PRIMARY KEY(ID_CATEGORIA)
);
COMMIT;

INSERT INTO CATEGORIA VALUES(1, 'Acción Aventura', 'RPG', 12, 1, TO_DATE('2021-05-10', 'YYYY-MM-DD'));
INSERT INTO CATEGORIA VALUES(2, 'Estrategia Militar', 'RTS', 16, 0, TO_DATE('2020-09-15', 'YYYY-MM-DD'));
INSERT INTO CATEGORIA VALUES(3, 'Simulación Deportiva', 'Deportes', 3, 1, TO_DATE('2019-11-01', 'YYYY-MM-DD'));
INSERT INTO CATEGORIA VALUES(4, 'Terror y Supervivencia', 'Survival Horror', 18, 0, TO_DATE('2022-02-28', 'YYYY-MM-DD'));
INSERT INTO CATEGORIA VALUES(5, 'Mundo Abierto', 'Sandbox', 13, 1, TO_DATE('2023-07-07', 'YYYY-MM-DD'));

SELECT * FROM CATEGORIA;