# Compras (Exemplo em Java - Orientação a Objetos)

Um pequeno projeto em Java que simula um cartão de crédito e o registro de compras realizadas. O programa permite ao usuário informar o limite do cartão, lançar compras enquanto houver saldo e, ao final, exibe as compras realizadas em ordem (ordenadas) e o saldo restante.

## Tecnologias

- Java (JDK 8 ou superior)
- Build/execução via linha de comando (javac / java)
- Projeto pequeno e didático — pode ser aberto em qualquer IDE Java (IntelliJ IDEA, Eclipse, NetBeans, VS Code com extensão Java)

## Estrutura do projeto

- `src/`
  - `CartaoDeCredito.java` - Lógica do cartão e controle de saldo/compras
  - `Compra.java` - Representa uma compra (descrição, valor) — deve implementar ordenação
  - `Principal.java` - Classe com o método `main` e interface de texto para o usuário

Arquivos de exemplo estão no diretório `src`.

## Requisitos

- Java Development Kit (JDK) 8 ou superior instalado e configurado no PATH

Para verificar se o Java está instalado, abra um terminal (PowerShell no Windows) e rode:

```powershell
java -version
javac -version
```

Ambos devem retornar a versão do Java.

## Como compilar e executar (linha de comando - PowerShell)

1. Abra o PowerShell e navegue até a raiz do projeto (onde está a pasta `src`). Exemplo:

```powershell
cd F:\alura-java\01-aprenda-a-programar-em-java-com-orientacao-a-objetos\compras
```

2. Compile os arquivos `.java` dentro da pasta `src` (vai gerar `.class` dentro de `src`):

```powershell
javac src\*.java
```

3. Execute a aplicação apontando para o diretório `src` na classe `Principal`:

```powershell
java -cp src Principal
```

Observação: se preferir, crie pastas separadas para os arquivos compilados (por exemplo `out`), compilando com `-d out` e rodando com `-cp out`.

Exemplo com diretório de saída `out`:

```powershell
javac -d out src\*.java
java -cp out Principal
```

## Como usar

Ao executar, o programa pede que você informe o limite do cartão. Depois, em um loop, solicita:

- Descrição da compra
- Valor da compra

Se houver saldo suficiente a compra é lançada; caso contrário, o programa informa "Saldo insuficiente" e encerra. Ao final ele mostra a lista de compras (ordenadas) e o saldo remanescente.

Exemplo de interação:

```
Digite o limite do cartão:
1000
Digite a descrição da compra:
Caneta
Digite o valor da compra:
5
Compra realizada!
Digite 0 para sair ou 1 pra continuar comprando:
1
... (continua)
```

## Executando no IDE

1. Abra seu IDE Java favorito (IntelliJ IDEA, Eclipse, NetBeans ou VS Code com extensão Java).
2. Importe o diretório do projeto ou abra a pasta `compras` como projeto.
3. Configure o SDK do projeto (JDK 8+).
4. Execute a classe `Principal`.


