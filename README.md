# Projeto Pokémon Console RPG - Java MVC

## Descrição

Projeto desenvolvido para avaliação da disciplina de **Desenvolvimento de Software**.

O projeto consiste em um jogo inspirado na franquia Pokémon, executado e renderizado via terminal. Nele, o jogador pode explorar um mapa representado por uma matriz bidimensional, movimentar-se entre diferentes áreas, enfrentar Pokémon selvagens e batalhar contra treinadores hostis.

O programa foi desenvolvido seguindo a arquitetura **MVC (Model-View-Controller)**, permitindo uma melhor organização do código, maior separação de responsabilidades entre os componentes do sistema e facilitando futuras manutenções e expansões do projeto.

---

# Objetivos do Projeto

O principal objetivo do projeto é aplicar, de forma prática, os conceitos estudados na disciplina, incluindo:

* Programação Orientada a Objetos (POO)
* Arquitetura MVC
* Encapsulamento
* Herança
* Polimorfismo
* Abstração
* Coleções com ArrayList
* Organização modular de código
* Utilização de Enum
---

# Organização da Equipe

## Membro 1 - Engenheiro do Mundo

Responsável pelo sistema de navegação do jogo e pela inicialização da aplicação.

### Sistema 1 - Mapa

#### Model

**Mapa**

* Armazena a matriz bidimensional do mundo.
* Define terrenos, obstáculos e posições especiais.

#### View

**MapaView**

* Exibe o mapa para o jogador.
* Mostra a posição atual do personagem.

#### Controller

**MapaController**

* Atualiza as coordenadas do jogador.
* Controla a movimentação dentro do mapa.

### Sistema 2 - Menu Principal

#### Model

**Menu**

* Armazena configurações do jogo.
* Define opções como dificuldade e modo de jogo.

#### View

**MenuView**

* Exibe a tela inicial.
* Mostra as opções de iniciar ou sair do jogo.

#### Controller

**MenuController**

* Processa a escolha do usuário.
* Inicia ou encerra o jogo.

---

## Membro 2 - Gerente do Protagonista

Responsável pelos dados do jogador e pelo sistema de compras.

### Sistema 3 - Jogador

#### Model

**Jogador**

* Armazena a posição do jogador no mapa.
* Mantém a equipe de Pokémon.
* Controla dinheiro, insígnias e demais informações do progresso.

#### View

**JogadorView**

* Exibe o status do jogador.
* Mostra dinheiro, equipe e progresso na jornada.

#### Controller

**JogadorController**

* Gerencia a equipe Pokémon.
* Adiciona e remove criaturas da equipe.

### Sistema 4 - Loja

#### Model

**Loja**

* Armazena o estoque disponível.
* Controla os preços dos itens.

#### View

**LojaView**

* Exibe o catálogo de produtos disponíveis.

#### Controller

**LojaController**

* Realiza compras.
* Atualiza o dinheiro do jogador.
* Adiciona itens à mochila.

---

## Membro 3 - Engenheiro de Batalha

Responsável pelo sistema de combate e pelos treinadores adversários.

### Sistema 5 - Batalha

#### Model

**Batalha**

* Armazena informações temporárias da luta.
* Controla turnos e participantes.

#### View

**BatalhaView**

* Exibe os HPs dos Pokémon em combate.
* Mostra as opções de ação disponíveis.

#### Controller

**BatalhaController**

* Calcula o dano causado pelos ataques.
* Executa as ações de combate.
* Verifica condições de vitória ou derrota.

### Sistema 6 - Treinador

#### Model

**Treinador**

* Armazena o nome do treinador.
* Guarda diálogos e equipe Pokémon.

#### View

**TreinadorView**

* Exibe falas e interações dos treinadores.

#### Controller

**TreinadorController**

* Inicia batalhas contra treinadores.
* Gerencia encontros com chefões e NPCs hostis.

---

## Membro 4 - Pesquisador de Criaturas

Responsável pelos Pokémon e pela Pokédex.

### Sistema 7 - Pokémon

#### Model

**PokemonBase**

* Nome
* HP
* Ataque
* Defesa
* Tipo

#### View

**PokemonView**

* Exibe informações individuais de um Pokémon.

#### Controller

**PokemonController**

* Gerencia ataques.
* Aplica dano recebido.
* Atualiza atributos durante as batalhas.

### Sistema 8 - Pokédex

#### Model

**Pokedex**

* Armazena informações sobre os Pokémon existentes no jogo.

#### View

**PokedexView**

* Exibe descrições, estatísticas e características dos Pokémon.

#### Controller

**PokedexController**

* Realiza pesquisas por nome.
* Recupera informações armazenadas na Pokédex.

---

## Membro 5 - Gerente de Suprimentos

Responsável pela implementação da herança no sistema de itens.

### Sistema 9 - Item Base

#### Model

**ItemBase (Classe Abstrata)**

* Nome
* Quantidade

#### View

**ItemView**

* Exibe os itens armazenados na mochila.

#### Controller

**ItemController**

* Gerencia operações gerais relacionadas aos itens.

### Sistema 10 - Poção

#### Model

**Pocao**

* Herda os atributos e comportamentos de ItemBase.
* Adiciona o atributo de valor de cura.

#### View

**PocaoView**

* Exibe mensagens relacionadas à utilização da poção.

#### Controller

**PocaoController**

* Recupera o HP de um Pokémon.
* Consome a quantidade disponível do item.

---

# Estrutura de Herança

```java
ItemBase
    ↑
  Pocao
```

A classe `Pocao` utiliza o mecanismo `extends`, herdando atributos e comportamentos da classe abstrata `ItemBase`.

---

# Enum de Tipos

Será utilizado um Enum para representar os tipos dos Pokémon.

```java
public enum TipoPokemon {
    FOGO,
    AGUA,
    GRAMA,
    ELETRICO
}
```

O Enum será utilizado principalmente pelo sistema de batalha para calcular vantagens e desvantagens entre os diferentes tipos.

---

# Estrutura MVC

```text
src
│
├── model
│   ├── Mapa
│   ├── Jogador
│   ├── PokemonBase
│   ├── ItemBase
│   ├── Pocao
│   └── ...
│
├── view
│   ├── MapaView
│   ├── JogadorView
│   ├── PokemonView
│   ├── LojaView
│   └── ...
│
├── controller
│   ├── MapaController
│   ├── JogadorController
│   ├── BatalhaController
│   ├── LojaController
│   └── ...
│
└── Main
```

---

# Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos
* MVC (Model-View-Controller)
* ArrayList
* Enum
* Herança
* Encapsulamento
* Abstração

---

# Utilização de Inteligência Artificial

Durante o desenvolvimento deste projeto, ferramentas de Inteligência Artificial foram utilizadas como apoio ao processo de planejamento e aprendizagem.

A IA foi empregada principalmente para:

* Auxiliar na divisão das responsabilidades entre os integrantes da equipe.
* Sugerir uma organização inicial da arquitetura MVC.
* Esclarecer dúvidas relacionadas à sintaxe da linguagem Java.
* Auxiliar na compreensão de conceitos de Programação Orientada a Objetos.
* Fornecer exemplos de implementação de métodos, classes e estruturas de código.

A ferramenta não foi utilizada para desenvolver integralmente o projeto. Todas as decisões de modelagem, implementação, integração dos sistemas e correção de erros foram realizadas pelos integrantes da equipe.

Dessa forma, a Inteligência Artificial atuou como uma ferramenta de apoio educacional, semelhante ao uso de documentação técnica, fóruns de programação e materiais de consulta, contribuindo para a organização do projeto e para o aprendizado dos conceitos aplicados.

---

# Objetivo Acadêmico

Demonstrar a aplicação prática dos conceitos de Programação Orientada a Objetos por meio da construção de um RPG de terminal inspirado na franquia Pokémon, utilizando arquitetura MVC e divisão modular de responsabilidades entre os integrantes da equipe.
