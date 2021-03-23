CREATE TABLE ALUNO(
	Nome_Aluno varchar(60),
	ID_Aluno int,
	ID_Academia_Matriculado int,
	ID_Meu_Instrutor int,
	
	CONSTRAINT ID_Aluno_PK PRIMARY KEY (ID_Aluno),
	CONSTRAINT ID_Instrutor_FK FOREIGN KEY (ID_Meu_Instrutor) REFERENCES INSTRUTOR(ID_Instrutor),
	CONSTRAINT ID_Academia_FK FOREIGN KEY (ID_Academia_Matriculado) REFERENCES ACADEMIA(ID_Academia)
);

CREATE TABLE ACADEMIA(
	Nome_Academia varchar(60), 
	Local_Academia varchar(60), 
	Preço decimal, 
	ID_Academia int,
	CONSTRAINT ID_Academia_FK PRIMARY KEY(ID_Academia)		
);

CREATE TABLE INSTRUTOR(
	Nome_Instrutor varchar(30), 
	ID_Instrutor int,
	Salario decimal,
	
	CONSTRAINT ID_Instrutor_PK PRIMARY KEY(ID_Instrutor)
);

CREATE TABLE SUPERVISOR(
	Nome_Supervisor varchar(60),
	ID_Supervisor int,
	ID_Academia_Trabalha int,
	Salario decimal,
	
	CONSTRAINT ID_Supervisor_PK PRIMARY KEY (ID_Supervisor),
	CONSTRAINT ID_Academia_Trabalha_FK FOREIGN KEY (ID_Academia_Trabalha) REFERENCES ACADEMIA(ID_Academia)
);

select *
from SUPERVISOR

select *
from ACADEMIA

select *
from INSTRUTOR

select *
from ALUNO