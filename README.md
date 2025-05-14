# 🧪 Projeto de Testes com Selenium e JUnit

Este é um projeto de exemplo utilizando **Selenium WebDriver** com **JUnit 5** para testar interações em uma página HTML simples contendo diversos tipos de campos.

## 📋 Funcionalidades testadas

A página `formulario.html` contém os seguintes elementos:
- Campo de texto (`input`)
- Lista suspensa (`select`)
- Caixas de seleção (`checkbox`)
- Botões de rádio (`radio`)
- Botão de envio (`submit`)

Os testes automatizados validam:
- Preenchimento correto de campos
- Seleção e marcação de elementos
- Exclusividade entre botões de rádio
- Verificações de visibilidade e estado de elementos

## 🛠 Tecnologias utilizadas

- Java 11+
- Maven
- Selenium WebDriver 4.21.0
- JUnit 5.10.2
- IntelliJ IDEA

## ▶️ Executando o projeto

1. **Clone ou extraia** este repositório em sua máquina.
2. **Abra o projeto no IntelliJ** como um projeto Maven.
3. Certifique-se de que o **driver do Chrome (chromedriver)** está disponível no seu PATH.
4. Execute os testes normalmente pela IDE ou via terminal:

```bash
mvn test
```

## 🗂 Estrutura do projeto

```
formulario-selenium/
├── pom.xml
├── src
│   ├── main
│   │   └── resources
│   └── test
│       ├── java
│       │   └── FormularioTest.java
│       └── resources
│           └── formulario.html
```

## 💡 Dicas

- O formulário é carregado localmente usando o caminho absoluto do arquivo HTML.
- Os testes usam `assertAll` para validar múltiplos comportamentos de uma vez.
- Ideal para quem está aprendendo automação de testes com Selenium.

---

Feito com 💻 para fins educacionais e laboratoriais.
