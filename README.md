# Gerenciamento de Pessoas

API desenvolvida com Spring Boot para o gerenciamento de pessoas.

# Requisitos
- [x] Criar uma pessoa
- [x] Editar uma pessoa
- [x] Consultar uma pessoa
- [x] Listar pessoas
- [x] Criar endereço para uma pessoa
- [x] Listar endereços de uma pessoa
- [x] Poder informar qual endereço é o principal
    - No caso de não ser informado se o endereço é ou não o principal, o mesmo será salvao com endereço secundário.
- [x] Todas as respostas da API devem ser JSON
- [x] O banco de dados H2 deve ser usado

# Entidades
- Pessoa
    - Nome
    - Data de Nascimento
    - Endereço
- Endereço
    - Logradouro
    - CEP
    - Número
    - Cidade

# Testes
- Apenas testes unitários foram realizados. 
- Os testes foram escritos para testar PessoaRepository e PessoaService, ou seja, o repositório e o serviço de pessoa respectivamente.

# Versões usadas 
Embora o Spring boot 3 já tenha sido lançado, optei por desenvolver usando as seguintes versões: 
- Java 11
- Spring 2.7.7
