CREATE DATABASE AnaliseFilme;
USE AnaliseFilme;

CREATE TABLE Filmes
(
   id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   titulo VARCHAR(255),
   sinopse VARCHAR(255),
   genero VARCHAR(255),
   ano_lancamento INT NOT NULL
);

CREATE TABLE Análises
(
   id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   filme INT,
   analise VARCHAR(255),
   nota INT,
   CONSTRAINT FK1ele5vktqexwkbgdclnus0348 FOREIGN KEY (filme) REFERENCES Filmes(id) 
);

SELECT * FROM Filmes;
SELECT * FROM Análises;