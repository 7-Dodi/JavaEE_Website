# JavaEE_Website

## Descrição

O projeto de Gerenciamento de Vacinas é uma aplicação Java que utiliza JDBC para gerenciar informações relacionadas à vacinação de pacientes, armazenando os dados em um banco de dados PostgreSQL, além de apresentar uma estrutura em JSP e com o servidor Tomcat, permitinndo que a aplicação seja usada na rede Web. Este sistema permite o cadastro de pacientes e suas respectivas vacinações, facilitando o acompanhamento de quais vacinas foram administradas, a data de aplicação e outros dados relevantes.

## Estrutura de Pastas

O projeto está organizado na seguinte estrutura de pastas:

- `.settings`: Contém configurações específicas do ambiente de desenvolvimento.
- `src`: Diretório principal do código fonte.
  - `com.br.JavaWeb`:
    - `connection`:
      - `ConnectionManufacture.java`: Classe responsável por estabelecer a conexão com o banco de dados PostgreSQL utilizando JDBC.
    - `dao`:
      - `PatientDAO.java`: Classe DAO para gerenciar as operações CRUD relacionadas aos pacientes no banco de dados.
      - `VaccinationDAO.java`: Classe DAO para gerenciar as operações CRUD relacionadas às vacinações no banco de dados.
    - `entities`:
      - `Patient.java`: Entidade representando um paciente.
      - `Vaccination.java`: Entidade representando uma vacinação.
    - `Controller`:
      - `Controller.java`: Classe responsável por instanciar o chamado das páginas no servidor web Tomcat.
    - `Logica`:
      - Lógica por trás de cada função do DAO de uma entidade, bem como responsável pela a determinação do acesso a uma determinada página WEB.
- `.classpath` e `.project`: Arquivos de configuração do projeto.
- `.gitignore`: Define os arquivos e diretórios ignorados pelo Git.
- `postgresql-42.5.2.jar`: Driver JDBC para conexão com o banco de dados PostgreSQL.

## Funcionalidades

- **Cadastro de Pacientes**: Permite o registro de pacientes, armazenando informações como nome, documento de identidade, data de nascimento, entre outras.
- **Registro de Vacinação**: Possibilita o cadastro de vacinações aplicadas aos pacientes, incluindo o tipo de vacina, a data de aplicação e outras notas relevantes.
- **Consulta de Dados**: Facilita a consulta de informações sobre pacientes e suas vacinações, permitindo um acompanhamento eficaz do histórico de vacinação.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada no desenvolvimento da aplicação.
- **Tomcat**: Servidor para aplicações de Java na Web.
- **JDBC (Java Database Connectivity)**: API para conexão e execução de operações em bancos de dados com Java.
- **PostgreSQL**: Sistema gerenciador de banco de dados relacional utilizado para armazenamento dos dados.

## Como Executar

1. Certifique-se de ter o Java, o Tomcat e o PostgreSQL instalados em sua máquina.
2. Crie o banco de dados e as tabelas necessárias utilizando os scripts SQL abaixo:

#### Tabela "Paciente":

```bash
ID do paciente (chave primária)
Nome do paciente
Data de nascimento
Gênero
Número de telefone
E-mail (opcional)
```

#### Tabela "Vacinação":

```bash
ID da vacinação (chave primária)
ID do paciente (chave estrangeira referenciando a tabela de pacientes)
Nome da vacina
Data da vacinação
Próxima dose (caso aplicável)
Lote da vacina
Nome do médico/enfermeiro responsável
```

#### SQL de Paciente:

```bash
CREATE TABLE Paciente (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  dataNascimento VARCHAR(10) NOT NULL,
  genre VARCHAR(10) NOT NULL,
  numTelefone VARCHAR(20) NOT NULL,
  email VARCHAR(255) NOT NULL
);
```

#### SQL de Vacinção:

```bash
CREATE TABLE Vacinacao (
  id SERIAL PRIMARY KEY,
  vacina VARCHAR(255) NOT NULL,
  dataVacinacao VARCHAR(10) NOT NULL,
  lote VARCHAR(10) NOT NULL,
  nomeMedico VARCHAR(255) NOT NULL,
	idPaciente INTEGER REFERENCES Paciente(id)
);
```

3. Atualize o arquivo `ConnectionManufacture.java` com as credenciais do seu banco de dados (URL, usuário e senha).
4. Adicione o projeto web para a execução do Tomcat.
5. Inicie a aplicação com o arquivo Index.html e seja feliz! ;)
