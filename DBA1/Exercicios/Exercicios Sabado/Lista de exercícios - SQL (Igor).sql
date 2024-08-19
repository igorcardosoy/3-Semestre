-- IGOR FILIPI CARDOSO | AQ3022587

USE EMPRESA;

-- a) Inserir 5 linhas na tabela TelefoneFunc

INSERT INTO TELEFONEFUNC (NROTELEFONE, CPF)
VALUES 
('9912345678', '1234'),
('9928367432', '1234'),
('9933942573', '3334'),
('9945732621', '9998'),
('9955673821', '9876');

SELECT * FROM TELEFONEFUNC;

-- b) Inserir 5 linhas na tabela Dependente

SELECT * FROM FUNCIONARIO;

INSERT INTO DEPENDENTE (NOME, CPF, DATANASC, SEXO, PARENTESCO)
VALUES
('Igor Cardoso', '1234', '2005-04-18', 'M', 'Primo'),
('Eduardo Pires', '3334', '2005-07-21', 'M', 'Irmão'),
('Augusto Serrano', '9998', '2004-01-04', 'M', 'Irmão'),
('Caio Lopes', '9876', '2005-06-13', 'M', 'Primo'),
('Lucas', '6668', '2003-02-11', 'M', 'Primo');

SELECT * FROM DEPENDENTE;

-- c) Atualizar valor do atributo cpfsupervisor das linhas da tabela Funcionario

SELECT * FROM FUNCIONARIO;

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '3334'
WHERE CPF = '1234';

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '4534'
WHERE CPF = '3334';

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '6668'
WHERE CPF = '4534';

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '8886'
WHERE CPF = '6668';

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '9876'
WHERE CPF = '8886';

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '9879'
WHERE CPF = '9876';

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '9998'
WHERE CPF = '9879';

UPDATE FUNCIONARIO SET CPFSUPERVISOR = '1234'
WHERE CPF = '9998';


-- d) Remover uma linha da tabela Dependente

SELECT * FROM DEPENDENTE;

DELETE FROM DEPENDENTE
WHERE CPF = '6668' AND NOME = 'Lucas';
    
SELECT * FROM DEPENDENTE;

-- 2. Escreva comandos SQL para as seguintes operações de atualização no BD empresa. Se houver erro, explique quais restrições de integridade foram violadas:

-- a) Inserir um novo funcionário com cpf = ‘999’, chamado ‘Roberto Santos’, trabalhando no departamento 1

INSERT INTO FUNCIONARIO 
(CPF, NOME, DNUMERO)
VALUES 
('999', 'Roberto Santos', 1);

SELECT * FROM FUNCIONARIO;

-- b) Inserir um novo departamento <1, ‘Produção’> 

-- Ocorre erro de chave primaria, pois ja existe um Departamento com o DNUMERO 1.
INSERT INTO DEPARTAMENTO (DNOME, DNUMERO)
VALUES
('Produção', 1);

SELECT * FROM DEPARTAMENTO;


-- c) Alocar o funcionário com cpf = ‘999’ para trabalhar no projeto de número 1 por 5,5 horas e no projeto 2 por 2,5 horas

SELECT * FROM ATRIBUICAO;

INSERT INTO ATRIBUICAO (CPF, PROJNUMERO, HORAS)
VALUES 
('999', 1, 5.5),
('999', '2', '2.5');

-- d) Excluir a tupla de FUNCIONARIO com cpf = ‘999’


-- Ocorre um erro de chave estrangeira, pois este funcionário tem uma atribuição a um projeto. 
DELETE FROM FUNCIONARIO
WHERE CPF = '999';

-- e) Modificar o departamento do funcionário com cpf = ‘999’ para departamento com dnumero = 5

UPDATE FUNCIONARIO SET DNUMERO = 5
WHERE CPF = '999';

SELECT CPF, DNUMERO AS 'Número Departamento'
FROM FUNCIONARIO
ORDER BY DNUMERO DESC;

-- 3. Escreva comandos SQL para as seguintes consultas ao banco de dados relacional EMPRESA:

-- a) Consultar pelo nome, data de nascimento e salário de todos os funcionários do sexo feminino, ordenando os resultados do maior para o menor salário.

SELECT NOME, DATANASC, SALARIO
FROM FUNCIONARIO
WHERE SEXO = 'F'
ORDER BY SALARIO DESC;

-- b) Recuperar os locais de todos os projetos, eliminando valores duplicados.

SELECT DISTINCT PROJLOCAL 
FROM PROJETO;


-- c) Consultar nome e salário dos funcionários que ganham salário entre 4000 e 6000.

SELECT NOME, SALARIO
FROM FUNCIONARIO
WHERE SALARIO BETWEEN 4000 AND 6000
ORDER BY SALARIO DESC;


-- d) Consultar CPF dos funcionários que trabalham mais de 10 horas no projeto de número 3.

SELECT CPF
FROM ATRIBUICAO
WHERE HORAS > 10 AND PROJNUMERO = 3;

-- e) Consultar nome, salário e estimativa de salário reajustado de todos os funcionários, sendo que o reajuste é um aumento de 5%.

SELECT NOME, SALARIO, (SALARIO * 1.05) AS SALARIO_REAJUSTADO
FROM FUNCIONARIO
ORDER BY SALARIO DESC;


-- f) Consultar nome e data de nascimento dos funcionários cujo nome comece com a letra A.

SELECT NOME, DATANASC
FROM FUNCIONARIO
WHERE NOME LIKE 'A%'
ORDER BY NOME;

-- g) Consultar endereço completo dos funcionários que moram na cidade de São Paulo e não forneceram dados de complemento.

SELECT NOME, RUA, NUMERO, BAIRRO, CIDADE, ESTADO, CEP, COMPL
FROM FUNCIONARIO
WHERE CIDADE IN ('SÃO PAULO') AND COMPL IS NULL
ORDER BY NOME;

-- h) Consultar nome, salário, sexo e idade de todos funcionários da empresa.

SELECT NOME, SALARIO, SEXO, TIMESTAMPDIFF(YEAR, DATANASC, NOW()) AS IDADE
FROM FUNCIONARIO
ORDER BY IDADE DESC;
