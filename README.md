# University System

Este projeto foi desenvolvido para a unidade curricular **Engenharia de Software** e tem como objetivo a implementação de um sistema de gestão universitária, aplicando padrões de desenho e testes unitários. Feito por **Amilcio Monteiro**, **Diogo Costa**, **Ricardo Kanhoca** e **Rodrigo Nogueira**.

O sistema permite gerir estudantes, cursos, inscrições, horários e cálculo de notas, garantindo a validação de regras de negócio como pré-requisitos, conflitos de horários e atualização automática do GPA.

## Tecnologias Utilizadas

- **Java** (JDK 17 ou superior)
- **Apache Maven**
- **JUnit 5** – testes unitários
- **JaCoCo** – análise de cobertura de código

---

## Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Maven:

- `domain` – entidades do domínio (Student, Course, Enrollment, etc.)
- `service` – lógica de negócio e serviços do sistema
- `test` – testes unitários dos serviços principais

---

## Compilação do Projeto

Para compilar o projeto, executar no diretório university-system:

```bash
mvn clean compile
```



