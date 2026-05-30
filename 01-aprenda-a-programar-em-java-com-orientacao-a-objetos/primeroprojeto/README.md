# Primeiro Projeto Java - Aprenda a Programar com OO

Este repositório contém um projeto didático em Java criado durante o curso "Aprenda a programar em Java com Orientação a Objetos". O objetivo é demonstrar conceitos básicos da linguagem (variáveis, tipos primitivos, estruturas de controle, pacotes e execução de um programa Java simples).

## O que este projeto faz

O programa principal (`com.company.Main`) imprime informações sobre um filme (título, ano de lançamento), calcula a média de notas e exibe uma sinopse. É um exemplo simples para iniciantes.

Exemplo de saída esperada:

````
Esse é o Screen Match
Filme: Tog Gun: Maverick
Ano de lançamento: 2022
8.033333333333333
Filme top Gun
Filme de aventura com galã dos anos 80
Muito bom!
Ano de lançamento
2022
4
````

> Observação: a saída pode variar ligeiramente dependendo das alterações no código.

## Requisitos

- Java Development Kit (JDK) 15 ou superior (o projeto usa text blocks `"""`, que exigem Java 15+).
- Variável de ambiente `JAVA_HOME` configurada e `javac`/`java` disponíveis no `PATH`.

## Como compilar e executar (Windows PowerShell)

1. Abra o PowerShell na pasta raiz do projeto (onde está este `README.md`).

2. Compile os arquivos Java para a pasta `out`:

```powershell
javac -d out src\*.java src\com\company\*.java
```

3. Execute a aplicação principal:

```powershell
java -cp out com.company.Main
```

Se preferir compilar todos os arquivos Java recursivamente (caso adicione subpastas), você pode usar este comando no PowerShell:

```powershell
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object -ExpandProperty FullName)
```

E então executar como antes:

```powershell
java -cp out com.company.Main
```

## Estrutura do projeto

- `src/` - código-fonte Java. Contém arquivos no pacote `com.company` e alguns arquivos no pacote padrão para exemplos didáticos.
  - `com/company/Main.java` - classe com o método `main` que inicia o programa.

## Executando no IntelliJ IDEA

1. Abra o diretório do projeto no IntelliJ.
2. Marque a pasta `src` como Sources Root (se necessário).
3. Localize a classe `com.company.Main` e clique em Run (ou crie uma configuração de execução).

## Modificando o projeto

- Você pode alterar as notas, título do filme ou ano em `Main.java` para ver como a saída muda.
- Este projeto é intencionalmente simples — ideal para experimentar com tipos, conversões e estruturas de controle.

