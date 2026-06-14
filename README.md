# ClassesPokemon

## Descrição do Projeto

O **ClassesPokemon** é um jogo desenvolvido em Java inspirado na franquia Pokémon, utilizando conceitos de Programação Orientada a Objetos (POO) e o padrão arquitetural MVC (Model-View-Controller). O jogo é executado via terminal e permite que o jogador explore um mapa, capture Pokémon, participe de batalhas e interaja com diferentes locais presentes no mundo do jogo.

O projeto foi desenvolvido com o objetivo de aplicar os conhecimentos adquiridos na disciplina de Programação Orientada a Objetos, promovendo a utilização de classes, objetos, encapsulamento, herança, polimorfismo e relacionamentos entre classes.

---

# Objetivos

* Aplicar conceitos de Programação Orientada a Objetos.
* Utilizar o padrão MVC para organizar a estrutura do sistema.
* Desenvolver um sistema modular e de fácil manutenção.
* Simular mecânicas básicas presentes nos jogos da franquia Pokémon.
* Exercitar a modelagem de classes e seus relacionamentos.

---

# Funcionalidades Principais

* Menu principal para navegação do jogador.
* Exploração de um mapa interativo.
* Escolha de Pokémon inicial.
* Captura e gerenciamento de Pokémon.
* Sistema de batalhas.
* Gerenciamento da equipe Pokémon.
* Sistema de inventário (mochila).
* Loja para compra de itens.
* Hospital para recuperação dos Pokémon.
* Ginásios para desafios e progressão no jogo.
* Controle de dinheiro e recursos do jogador.

---

# Estrutura do Projeto

O projeto segue o padrão arquitetural MVC (Model-View-Controller), dividindo as responsabilidades em três camadas.

## Model

Responsável pelo armazenamento dos dados e pelas regras de negócio.

### Principais Classes

### JogadorModel

Representa o jogador e armazena informações como:

* Dinheiro
* Equipe Pokémon
* Mochila
* Insígnias
* Posição no mapa

### PokemonBase

Representa um Pokémon contendo atributos e comportamentos relacionados ao personagem.

Exemplos:

* Nome
* Tipo
* Vida
* Nível
* Ataques

### MapaModel

Responsável pela criação e gerenciamento do mapa do jogo.

### LojaModel

Controla os itens disponíveis para compra.

### Batalha

Implementa a lógica das batalhas entre Pokémon.

### Treinador

Representa treinadores adversários encontrados durante a exploração.

---

## View

Responsável pela interação com o usuário através do terminal.

### Principais Classes

* MenuView
* MapaView
* PokemonView
* LojaView
* BatalhaView

Essas classes exibem informações e recebem as entradas do usuário.

---

## Controller

Responsável por controlar o fluxo da aplicação e conectar as Views aos Models.

### Principais Classes

### MenuController

Controla o menu principal e o início do jogo.

### ExploracaoController

Gerencia a exploração do mapa e coordena os demais controladores.

### MapaController

Controla movimentação e interações com o mapa.

### JogadorController

Gerencia ações relacionadas ao jogador.

### BatalhaController

Controla o sistema de batalhas.

---

# Relacionamentos entre Classes

## Associação

Ocorre quando duas classes interagem entre si sem dependência de existência.

Exemplos:

* Batalha ↔ PokemonBase
* ExploracaoController ↔ MapaController
* ExploracaoController ↔ JogadorController

---

## Agregação

Ocorre quando uma classe contém outra, mas os objetos podem existir independentemente.

Exemplo:

* JogadorModel agrega diversos objetos PokemonBase em sua equipe.

Mesmo que o jogador deixe de existir, os Pokémon continuam sendo entidades independentes.

---

## Composição

Ocorre quando uma classe é responsável pelo ciclo de vida de seus componentes.

Exemplo:

* MapaModel é composto pela estrutura interna do mapa (matriz de posições).

Caso o mapa seja destruído, seus elementos internos também deixam de existir.

---

# Fluxo Geral da Aplicação

1. O usuário inicia a aplicação através da classe Main.
2. O MenuController exibe o menu principal.
3. Após iniciar o jogo, o ExploracaoController assume o controle da exploração.
4. O jogador pode se movimentar pelo mapa.
5. Dependendo da posição, o jogador pode:

    * Encontrar Pokémon;
    * Iniciar batalhas;
    * Entrar em lojas;
    * Utilizar o hospital;
    * Desafiar ginásios.
6. As ações atualizam os Models e as informações são exibidas pelas Views.

---

# Como Executar o Projeto

## Requisitos

* Java JDK 17 ou superior.
* IDE compatível com Java (IntelliJ IDEA, Eclipse ou NetBeans).

## Passos para Execução

### 1. Obter o Projeto

Clone o repositório ou extraia os arquivos do projeto.

### 2. Abrir na IDE

Abra a pasta do projeto utilizando sua IDE de preferência.

### 3. Localizar a Classe Principal

Localize o arquivo:

Main.java

### 4. Executar

Execute a classe Main.

### 5. Jogar

O menu principal será exibido no terminal e o jogo poderá ser iniciado.

---

# Uso de Inteligência Artificial

Durante o desenvolvimento do projeto foram utilizadas ferramentas de Inteligência Artificial como apoio ao aprendizado e à implementação.

As ferramentas utilizadas foram:

* ChatGPT (OpenAI)
* Gemini (Google)

As IAs auxiliaram em atividades como:

* Esclarecimento de conceitos de Programação Orientada a Objetos;
* Explicação do padrão MVC;
* Sugestões para organização do código;
* Correção e revisão de trechos de código;
* Identificação de erros;
* Apoio na elaboração da documentação.

As ferramentas foram utilizadas apenas como suporte ao desenvolvimento. A modelagem, implementação, adaptação e validação das soluções foram realizadas pelos integrantes do grupo.

---

# Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos (POO)
* MVC (Model-View-Controller)

---

# Referências e Recursos

### Documentação Java

https://docs.oracle.com/en/java/

### Conceitos Utilizados

* Programação Orientada a Objetos
* MVC (Model-View-Controller)
* Estruturas de Dados em Java

### Ferramentas de Apoio

* ChatGPT (OpenAI)
* Gemini (Google)

---

# Integrantes

* Nome do Integrante 1
* Nome do Integrante 2
* Nome do Integrante 3
* Nome do Integrante 4

---

# Licença

Projeto desenvolvido para fins acadêmicos e educacionais.
