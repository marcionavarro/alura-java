# 🎵 Minhas Músicas

Uma aplicação Java que gerencia sua biblioteca de áudios, permitindo controlar músicas e podcasts com funcionalidades de reprodução, curtidas e classificação automática.

## 📋 Sobre o Projeto

**Minhas Músicas** é um sistema desenvolvido com princípios de Programação Orientada a Objetos (POO). A aplicação demonstra conceitos fundamentais como:

- **Herança**: Classes `Musica` e `Podcast` herdam de `Audio`
- **Polimorfismo**: Implementação do método `getClassificacao()` de forma personalizada em cada subclasse
- **Encapsulamento**: Uso de getters e setters para controlar acesso aos atributos
- **Abstração**: Classe base `Audio` abstraindo funcionalidades comuns

### Funcionalidades Principais

✨ **Gerenciamento de Áudios**
- Criar e configurar músicas com cantor, gênero e álbum
- Criar e configurar podcasts com apresentador e descrição
- Reproduzir áudios (contador de reproduções)
- Curtir áudios (contador de curtidas)

📊 **Sistema de Classificação**
- Músicas recebem classificação 10 se mais de 2000 reproduções, caso contrário 7
- Podcasts recebem classificação 10 se mais de 500 curtidas, caso contrário 8

❤️ **Favorites**
- Adicionar áudios favoritos à lista "Minhas Preferidas"
- Gerenciar uma coleção personalizada de conteúdos

## 🛠️ Tecnologias

- **Linguagem**: Java
- **Versão**: Java 8 ou superior
- **Build**: Maven (opcional)
- **Paradigma**: Programação Orientada a Objetos (POO)

## 📁 Estrutura do Projeto

```
minhasmusicas/
├── src/br/com/alura/minhasmusicas/
│   ├── principal/
│   │   └── Principal.java          (Classe com método main)
│   └── modelos/
│       ├── Audio.java              (Classe base abstrata)
│       ├── Musica.java             (Herda de Audio)
│       ├── Podcast.java            (Herda de Audio)
│       └── MinhasPreferidas.java   (Gerenciador de favoritos)
└── README.md
```

## 🚀 Como Clonar

```bash
# Clone o repositório
git clone https://github.com/marcionavarro/alura-java.git

# Acesse o diretório do projeto
cd 01-aprenda-a-programar-em-java-com-orientacao-a-objetos/minhasmusicas
```

## ▶️ Como Compilar e Rodar

### Opção 1: Com IDE (IntelliJ IDEA, Eclipse, Visual Studio Code)

1. Abra o projeto em sua IDE preferida
2. Localize a classe `Principal.java` em `src/br/com/alura/minhasmusicas/principal/`
3. Clique com botão direito e selecione "Run Principal.main()"
4. Ou use o atalho: **Shift + F10** (IntelliJ) ou **Ctrl + F11** (Eclipse)

### Opção 2: Via Terminal/PowerShell

```bash
# Navegue até o diretório do projeto
cd 01-aprenda-a-programar-em-java-com-orientacao-a-objetos/minhasmusicas

# Compile os arquivos Java
javac -d bin src/br/com/alura/minhasmusicas/modelos/*.java src/br/com/alura/minhasmusicas/principal/*.java

# Execute a aplicação
java -cp bin br.com.alura.minhasmusicas.principal.Principal
```

### Opção 3: Com Maven (se configurado)

```bash
# Compile o projeto
mvn clean compile

# Execute a aplicação
mvn exec:java -Dexec.mainClass="br.com.alura.minhasmusicas.principal.Principal"
```

## 📖 Exemplo de Uso

```java
// Criar uma música
Musica musica = new Musica();
musica.setTitulo("Forever");
musica.setCantor("Kiss");
musica.setGenero("Rock");
musica.setAlbum("Destroyer");

// Reproduzir e curtir
musica.reproduz();
musica.curte();

// Criar um podcast
Podcast podcast = new Podcast();
podcast.setTitulo("BolhaDev");
podcast.setApresentador("Marcus Mendes");
podcast.setDescricao("Desenvolvimento Web");

// Adicionar aos favoritos
MinhasPreferidas preferidas = new MinhasPreferidas();
preferidas.inclui(musica);
preferidas.inclui(podcast);
```

## 🎓 Conceitos de POO Demonstrados

| Conceito | Descrição | Implementação |
|----------|-----------|---------------|
| **Herança** | Subclasses herdam atributos e métodos da superclasse | `Musica` e `Podcast` herdam de `Audio` |
| **Polimorfismo** | Sobrescrita do método `getClassificacao()` | Cada classe implementa sua lógica |
| **Encapsulamento** | Dados privados com acesso via getters/setters | Atributos `private` com métodos `public` |
| **Abstração** | Classe base com comportamento comum | `Audio` define interface comum |


## 👤 Autor

Desenvolvido como parte do curso **"Aprenda a Programar em Java com Orientação a Objetos"** da Alura.

---

**Divirta-se aprendendo Java!** 🎉

