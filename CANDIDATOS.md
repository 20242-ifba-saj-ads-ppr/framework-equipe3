
# Eventos

## Piece

    onTryMove
    onMove



## Square

    onTry




## Board








# Padroes

## Criacionais 

### 2. Builder

Para configurar e construir um jogo complexo passo a passo.

Exemplo: GameBuilder permite construir um jogo com :
 - quantidade de jogadores
 - regras customizadas
 - tabuleiros
 - pecas
 - casas

### 3. Factory Method

Para permitir que cada tipo de jogo decida como instanciar suas regras, jogadores, peças, etc.

Exemplo: createRules() que retorna regras específicas para o jogo de xadrez ou damas.

### 4. Prototype

Para clonar peças, estados do jogo ou configurações de jogador.

Exemplo: Clonar rapidamente o estado atual do jogo para salvar/undo ou criar jogadores com configurações similares.

## Estruturais


### 10. Façade

Para oferecer uma interface simples ao desenvolvedor que usa o framework.

Exemplo: GameEngineFacade com métodos como startGame(), loadGame(), makeMove().

### 11. Flyweight

Para compartilhar dados imutáveis entre milhares de peças idênticas (como cartas ou casas do tabuleiro).

Exemplo: Reutilizar instâncias de cartas com mesmo valor/simbolo.


### 7. Bridge

    Para separar a representação visual do jogo da lógica.

    Exemplo: GameRenderer (abstração) e ConsoleRenderer ou WebRenderer (implementações).

### 9. Decorator

    Para adicionar comportamentos temporários ou poderes especiais às peças sem alterar suas classes.

    Exemplo: PowerUpDecorator adiciona habilidade de “andar duas casas” a uma peça.


## Comportamentais

### 13. Chain of Responsibility

Para tratar ações de jogador por uma cadeia de regras e validações.

Exemplo: MoveValidatorChain com várias validações (dentro do tabuleiro, peça correta, turno correto, etc.)

### 14. Command

Para encapsular ações dos jogadores como comandos, permitindo desfazer/refazer.

Exemplo: MoveCommand, DrawCardCommand, UndoCommand.

### 15. Interpreter

Para interpretar expressões de regras ou scripts personalizados.

Exemplo: Interpretar "se o jogador tiver 3 cartas iguais, ganha 10 pontos".

### 19. Observer

Para notificar boards, pecas e casa de eventos


### 20. State

Para representar diferentes fases do jogo (esperando jogadores, em andamento, finalizado).


### 21. Strategy

Para definir diferentes estrategias de interação com o jogar (console, web, etc)

Exemplo: MoveStrategy pode variar entre AggressiveStrategy ou DefensiveStrategy.
