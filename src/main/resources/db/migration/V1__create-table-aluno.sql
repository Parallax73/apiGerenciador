create table alunos(

                        id bigint not null auto_increment,
                        nome varchar(100) not null,
                        ra varchar(8) not null unique,
                        e_genero varchar(50) not null,
                        e_estado_civil varchar(50) not null,
                        logradouro varchar(100) not null,
                        numero varchar(20),
                        cidade varchar(500) not null,
                        email varchar(100) not null unique,
                        cod_Curso varchar (3) not null,
                        nome_Curso varchar (50) not null,
                        e_situacao varchar(100) not null,
                        telefone varchar(10) not null ,


                        primary key(id)

);