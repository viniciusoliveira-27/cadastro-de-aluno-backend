CREATE TABLE alunos (

id VARCHAR (36) NOT NULL PRIMARY KEY, 
nome VARCHAR (150) NOT NULL, 
serie VARCHAR (100) NOT NULL,
escola VARCHAR(250) NOT NULL, 
periodo SMALLINT NOT NULL, 
valor DECIMAL (10,2) NOT NULL , 
data datetime (6) NOT NULL,
created_at datetime (6) NOT NULL,
updated_at datetime (6) NOT NULL
)