# ClassesPokemon

## Informações Gerais sobre o Projeto

ClassesPokemon é um jogo inspirado na franquia Pokémon desenvolvido em Java utilizando os conceitos de Programação Orientada a Objetos (POO) e a arquitetura MVC (Model-View-Controller). O projeto foi criado com fins acadêmicos para aplicar os conteúdos estudados durante a disciplina, incluindo encapsulamento, herança, polimorfismo, coleções, tratamento de exceções e persistência de dados.

O jogador pode explorar um mapa, escolher um Pokémon inicial, enfrentar Pokémon selvagens, desafiar treinadores, visitar lojas, utilizar hospitais Pokémon e conquistar insígnias em ginásios.

### Objetivos

* Aplicar conceitos de Programação Orientada a Objetos.
* Utilizar a arquitetura MVC para organização do código.
* Desenvolver um sistema modular e de fácil manutenção.
* Simular mecânicas básicas presentes nos jogos Pokémon.
* Implementar persistência de dados utilizando arquivos de texto.

---

# Funcionalidades Principais

* Exploração de mapa.
* Escolha de Pokémon inicial.
* Sistema de batalhas contra Pokémon selvagens.
* Sistema de batalhas contra treinadores.
* Hospital para recuperação dos Pokémon.
* Loja para compra e utilização de itens.
* Sistema de ginásios e obtenção de insígnias.
* Gerenciamento da equipe Pokémon.
* Gerenciamento da mochila do jogador.
* Sistema de salvamento e carregamento de dados em arquivo TXT.

---

# Estrutura do Projeto

O projeto segue a arquitetura MVC.

## Model

Responsável pelos dados e regras de negócio.

### Principais Classes

#### JogadorModel

Armazena informações do jogador:

* Dinheiro
* Mochila
* Insígnias
* Posição no mapa
* Equipe Pokémon

#### PokemonBase

Representa um Pokémon com seus atributos e comportamentos.

#### MapaModel

Responsável pela criação e gerenciamento do mapa.

#### LojaModel

Gerencia os itens disponíveis para compra.

#### Treinador

Representa os treinadores adversários.

#### Batalha

Contém a lógica das batalhas.

---

## View

Responsável pela interação com o usuário.

### Principais Classes

* MenuView
* MapaView
* LojaView
* BatalhaView

As Views exibem informações e recebem as entradas do usuário.

---

## Controller

Responsável pelo controle do fluxo da aplicação.

### Principais Classes

#### MenuController

Controla o menu principal.

#### ExploracaoController

Coordena a exploração do mapa e as interações do jogador.

#### MapaController

Controla movimentação e interação com o mapa.

#### JogadorController

Gerencia as ações relacionadas ao jogador.

#### BatalhaController

Controla o sistema de batalhas.

#### LojaController

Controla as compras e utilização de itens.

---

# Relações entre as Classes

## Associação

As classes colaboram entre si para executar funcionalidades do sistema.

Exemplos:

* ExploracaoController ↔ JogadorController
* ExploracaoController ↔ MapaController
* Batalha ↔ PokemonBase

---

## Agregação

O JogadorModel agrega objetos que podem existir independentemente dele.

Exemplos:

* Equipe Pokémon
* Itens da mochila

---

## Composição

O MapaModel é composto por sua estrutura interna de posições e elementos do mapa.

Caso o mapa deixe de existir, seus componentes internos também deixam de existir.

---

# Persistência de Dados

O projeto implementa persistência de dados utilizando arquivos de texto (.txt).

Ao encerrar o jogo, informações importantes do jogador são armazenadas em arquivo para que possam ser recuperadas posteriormente.

Atualmente são persistidos os seguintes dados:

* Dinheiro do jogador;
* Insígnias conquistadas.

O carregamento das informações é realizado automaticamente quando o jogo é iniciado, permitindo a continuidade do progresso entre diferentes execuções da aplicação.

---

# Tratamento de Exceções

O sistema utiliza tratamento de exceções durante operações de leitura e gravação de arquivos, garantindo maior robustez e evitando falhas inesperadas durante o processo de salvamento e carregamento dos dados.

---

# Como Executar o Projeto

## Requisitos

* Java JDK 17 ou superior.
* IDE compatível com Java (IntelliJ IDEA, Eclipse ou NetBeans).

## Passos

1. Baixe ou clone o projeto.
2. Abra o projeto em sua IDE.
3. Localize a classe `Main`.
4. Execute a aplicação.
5. Utilize o menu para iniciar o jogo.

---

# Uso de Inteligência Artificial

Durante o desenvolvimento do projeto foram utilizadas ferramentas de Inteligência Artificial como apoio ao aprendizado e desenvolvimento.

As ferramentas utilizadas foram:

* ChatGPT (OpenAI)
* Gemini (Google)

As IAs auxiliaram em:

* Esclarecimento de conceitos de Programação Orientada a Objetos;
* Explicação sobre MVC;
* Correção e revisão de código;
* Sugestões de implementação;
* Auxílio na documentação do projeto;
* Apoio na identificação e correção de erros.

As decisões de implementação, adaptação e validação das soluções foram realizadas pelos integrantes do grupo.

---

# Tecnologias Utilizadas

* Java
* Programação Orientada a Objetos (POO)
* MVC (Model-View-Controller)
* Manipulação de Arquivos TXT

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

Projeto desenvolvido exclusivamente para fins acadêmicos e educacionais.
