CREATE DATABASE clinica_db;
GO

USE clinica_db;
GO

CREATE TABLE pessoa (
    id       INT IDENTITY(1,1) PRIMARY KEY,
    nome     VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL,
    senha    VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    cpf      VARCHAR(14) NOT NULL UNIQUE,
    rg       VARCHAR(20)
);
GO

CREATE TABLE paciente (
    pessoa_id        INT PRIMARY KEY,
    endereco         VARCHAR(200),
    data_nascimento  DATE,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);
GO

CREATE TABLE secretaria (
    pessoa_id INT PRIMARY KEY,
    cargo     VARCHAR(100),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);
GO

CREATE TABLE profissional (
    pessoa_id             INT PRIMARY KEY,
    especialidade         VARCHAR(100),
    registro_profissional VARCHAR(50) NOT NULL UNIQUE,
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);
GO

CREATE TABLE status (
    id        INT IDENTITY(1,1) PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL
);
GO

CREATE TABLE consulta (
    id               INT IDENTITY(1,1) PRIMARY KEY,
    data             DATE        NOT NULL,
    horario          TIME        NOT NULL,
    observacao       VARCHAR(MAX),
    status_id        INT         NOT NULL,
    paciente_id      INT         NOT NULL,
    profissional_id  INT         NOT NULL,
    secretaria_id    INT,
    FOREIGN KEY (status_id)       REFERENCES status(id),
    FOREIGN KEY (paciente_id)     REFERENCES paciente(pessoa_id),
    FOREIGN KEY (profissional_id) REFERENCES profissional(pessoa_id),
    FOREIGN KEY (secretaria_id)   REFERENCES secretaria(pessoa_id)
);
GO

CREATE TABLE tratamento (
    id              INT IDENTITY(1,1) PRIMARY KEY,
    descricao       VARCHAR(200) NOT NULL,
    data_inicio     DATE,
    data_fim        DATE,
    status_id       INT NOT NULL,
    paciente_id     INT NOT NULL,
    profissional_id INT NOT NULL,
    FOREIGN KEY (status_id)       REFERENCES status(id),
    FOREIGN KEY (paciente_id)     REFERENCES paciente(pessoa_id),
    FOREIGN KEY (profissional_id) REFERENCES profissional(pessoa_id)
);
GO

CREATE TABLE etapa (
    id            INT IDENTITY(1,1) PRIMARY KEY,
    descricao     VARCHAR(200) NOT NULL,
    ordem         INT          NOT NULL,
    status_id     INT          NOT NULL,
    tratamento_id INT          NOT NULL,
    FOREIGN KEY (status_id)     REFERENCES status(id),
    FOREIGN KEY (tratamento_id) REFERENCES tratamento(id)
);
GO

CREATE TABLE orcamento (
    id            INT IDENTITY(1,1) PRIMARY KEY,
    valor_total   DECIMAL(10,2) NOT NULL DEFAULT 0.00,
    data_criacao  DATE          NOT NULL,
    status_id     INT           NOT NULL,
    consulta_id   INT,
    tratamento_id INT,
    FOREIGN KEY (status_id)     REFERENCES status(id),
    FOREIGN KEY (consulta_id)   REFERENCES consulta(id),
    FOREIGN KEY (tratamento_id) REFERENCES tratamento(id)
);
GO

INSERT INTO status (descricao) VALUES
('Agendada'),
('Realizada'),
('Cancelada'),
('Em Andamento'),
('Pendente'),
('Concluido'),
('Aprovado');
GO

INSERT INTO pessoa (nome, email, senha, telefone, cpf, rg) VALUES
('Ana Clara Souza',      'ana@email.com',     'senha123', '(17) 99100-0001', '111.222.333-01', '1111111'),
('Bruno Lima',           'bruno@email.com',   'senha123', '(17) 99100-0002', '111.222.333-02', '2222222'),
('Carlos Eduardo Neto',  'carlos@email.com',  'senha123', '(17) 99100-0003', '111.222.333-03', '3333333'),
('Daniela Ferreira',     'daniela@email.com', 'senha123', '(17) 99100-0004', '111.222.333-04', '4444444'),
('Eduarda Martins',      'eduarda@email.com', 'senha123', '(17) 99100-0005', '111.222.333-05', '5555555'),
('Felipe Rocha',         'felipe@email.com',  'senha123', '(17) 99100-0006', '111.222.333-06', '6666666'),
('Gabriela Alves',       'gabriela@email.com','senha123', '(17) 99100-0007', '111.222.333-07', '7777777'),
('Henrique Santos',      'henrique@email.com','senha123', '(17) 99100-0008', '111.222.333-08', '8888888'),
('Isabela Costa',        'isabela@email.com', 'senha123', '(17) 99100-0009', '111.222.333-09', '9999999'),
('Joao Pedro Oliveira',  'joao@email.com',    'senha123', '(17) 99100-0010', '111.222.333-10', '1010101'),
('Karla Mendes',         'karla@clinica.com', 'sec123',   '(17) 99100-0011', '111.222.333-11', '1111112'),
('Lucas Barbosa',        'lucas@clinica.com', 'prof123',  '(17) 99100-0012', '111.222.333-12', '1212121'),
('Mariana Gomes',        'mariana@clinica.com','prof456', '(17) 99100-0013', '111.222.333-13', '1313131'),
('Nicolas Pereira',      'nicolas@clinica.com','prof789', '(17) 99100-0014', '111.222.333-14', '1414141'),
('Olivia Carvalho',      'olivia@clinica.com','sec456',   '(17) 99100-0015', '111.222.333-15', '1515151');
GO

INSERT INTO paciente (pessoa_id, endereco, data_nascimento) VALUES
(1,  'Rua das Flores, 100',      '1990-03-15'),
(2,  'Av. Bady Bassitt, 200',    '1985-07-22'),
(3,  'Rua Sete, 310',            '1992-11-08'),
(4,  'Rua Norte-Sul, 45',        '1978-01-30'),
(5,  'Av. Getulio Vargas, 88',   '2000-05-17'),
(6,  'Rua Azaleia, 50',          '1995-09-25'),
(7,  'Rua Aracatuba, 120',       '1988-12-03'),
(8,  'Rua das Acacias, 77',      '2003-04-19'),
(9,  'Rua Progresso, 9',         '1973-08-11'),
(10, 'Av. Anisio Haddad, 310',   '1999-02-28');
GO

INSERT INTO secretaria (pessoa_id, cargo) VALUES
(11, 'Secretaria Administrativa'),
(15, 'Secretaria Recepcionista');
GO

INSERT INTO profissional (pessoa_id, especialidade, registro_profissional) VALUES
(12, 'Cirurgião-Dentista',  'CRM-SP-001234'),
(13, 'Odontopediatra',      'CRM-SP-005678'),
(14, 'Protético',           'CRM-SP-009012');
GO

INSERT INTO consulta (data, horario, observacao, status_id, paciente_id, profissional_id, secretaria_id) VALUES
('2025-01-10', '08:00', 'Dor de dente',                 2, 1,  12, 11),
('2025-01-12', '09:30', 'Cárie',                        2, 2,  12, 11),
('2025-01-15', '10:00', 'Próteses',                     2, 3,  13, 15),
('2025-02-03', '14:00', 'Limpeza',                      2, 4,  14, 11),
('2025-02-10', '08:30', 'Reabilitação Fratura',         2, 5,  12, 15),
('2025-03-01', '11:00', 'Paciente cancelou',            3, 6,  13, 11),
('2025-03-05', '15:30', NULL,                           1, 7,  14, 15),
('2025-03-08', '09:00', 'Primeira consulta',            1, 8,  12, 11),
('2025-03-12', '13:00', NULL,                           1, 9,  13, 15),
('2025-03-20', '16:00', 'Retorno apos exames',          1, 10, 14, 11),
('2025-04-02', '10:30', NULL,                           1, 1,  13, 15),
('2025-04-10', '08:00', 'Clareamento',                  1, 2,  14, 11);
GO

INSERT INTO tratamento (descricao, data_inicio, data_fim, status_id, paciente_id, profissional_id) VALUES
('Dor de dente',                    '2025-01-15', '2025-07-15', 4, 1,  14),
('Cárie',                           '2025-01-20', '2025-04-20', 4, 3,  13),
('Próteses',                        '2025-02-01', '2025-08-01', 4, 4,  12),
('Limpeza',                         '2025-02-05', NULL,         4, 4,  14),
('Reabilitação Fratura',            '2025-02-10', '2025-05-10', 4, 5,  12),
('Clareamento',                     '2025-02-15', '2025-05-15', 4, 6,  13),
('Implante',                        '2025-03-01', '2025-09-01', 4, 7,  14),
('Restauração',                     '2025-03-05', '2025-12-05', 4, 8,  12),
('Faceta',                          '2025-03-10', NULL,         4, 9,  13),
('Gengivoplastia',                  '2025-03-15', '2025-09-15', 4, 10, 14),
('Harmonização Orofacial',          '2024-10-01', '2024-12-31', 6, 2,  12),
('Acompanhamento',                  '2024-11-01', NULL,         4, 1,  12);
GO

INSERT INTO etapa (descricao, ordem, status_id, tratamento_id) VALUES
('Avaliacao inicial e anamnese',              1, 6, 1),
('Exames laboratoriais',                      2, 6, 1),
('Inicio',                                    3, 4, 1),
('Reavaliacao em 30 dias',                    4, 5, 1),
('Limpeza',                                   1, 6, 2),
('Aplicacao quimica',                         2, 4, 2),
('Manutencao mensal',                         3, 5, 2),
('Consulta de avaliacao inicial',             1, 6, 3),
('Orientacao',                                2, 4, 3),
('Retorno e ajuste',                          3, 5, 3),
('Acompanhamento',                            1, 6, 4),
('Inicio do protocolo medicamentoso',         2, 4, 4),
('Restauracao',                               1, 6, 5),
('Finalizacao',                               2, 4, 5),
('Orientacoes finais',                        3, 5, 5);
GO

INSERT INTO orcamento (valor_total, data_criacao, status_id, consulta_id, tratamento_id) VALUES
(250.00, '2025-01-10', 7, 1,  NULL),
(180.00, '2025-01-12', 7, 2,  NULL),
(320.00, '2025-01-15', 7, 3,  2),
(500.00, '2025-02-03', 7, 4,  4),
(150.00, '2025-02-10', 7, 5,  NULL),
(280.00, '2025-02-15', 5, NULL,6),
(420.00, '2025-03-01', 5, NULL,7),
(750.00, '2025-03-05', 5, NULL,8),
(380.00, '2025-03-10', 5, NULL,9),
(600.00, '2025-03-15', 5, NULL,10),
(200.00, '2025-04-02', 5, 11, NULL),
(350.00, '2025-04-10', 5, 12, 12);
GO
