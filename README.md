# Projeto Final - Automação de Testes (API & Web)

Este repositório contém a automação de testes desenvolvida para avaliação da disciplina de Teste e Qualidade de Software.
##  Tecnologias Utilizadas
* **Java 17**
* **Maven** (Gerenciamento de dependências)
* **RestAssured** (Testes de API)
* **Selenium WebDriver** (Testes Web E2E)
* **JUnit 5** (Framework de testes e asserções)
* **GitHub Actions** (CI/CD Pipeline)

##  Estrutura do Projeto
* **API**: Cobertura dos endpoints `/user`, `/store` e `/pet`.
* **Web**: Fluxo E2E utilizando o padrão **Page Objects** para melhor legibilidade e reuso de código.

## Como executar localmente
1. Certifique-se de ter o Java 17 e o Maven instalados.
2. Clone o repositório: `git clone https://github.com/SEU-USUARIO/seu-repositorio.git`
3. Pelo terminal, acesse a pasta do projeto.
4. Execute o comando:
   ```bash
   mvn clean test