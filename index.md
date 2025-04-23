---
export_on_save:
  html: true
---

# Template

## Nome padrão

### Intenção

(GOF)

### Motivação
- Cenário sem a aplicação do padrão
  - descrição textual, classes envolvidas e UML
- Estrutura do padrão (GOF - papeis)
  - UML
- Padrão aplicado no cenário
  - descrição textual, classes envolvidas, UML
- Participantes
  - Quem está desempenhado cada papel do padrão dentro do seu cenário.
- Código
  - destacando o código do framework e o código do uso do framework (código do jogo específico)

## Builder

### Intenção

Separar a construção de um objeto complexo da sua representação de modo que o
mesmo processo de construção possa criar diferentes representações.

### Motivação
- Cenário sem a aplicação do padrão
  - descrição textual, classes envolvidas e UML
- Estrutura do padrão (GOF - papeis)
  - UML
- Padrão aplicado no cenário
  - descrição textual, classes envolvidas, UML
- Participantes
  - Quem está desempenhado cada papel do padrão dentro do seu cenário.
- Código
  - destacando o código do framework e o código do uso do framework (código do jogo específico)



# Builder

## Intenção

O padrão Builder tem como intenção separar a construção de um objeto complexo da sua representação, permitindo que o mesmo processo de construção crie diferentes representações do objeto.

## Motivação

Considere um framework para criação de jogos de tabuleiro em que o desenvolvedor pode criar as peças a que desejar, com diferentes caracteristicas e comportamentos. Considerando que essas peças podem possuir uma construção complexa e que deve ser segmentada, apenas ter uma interface ou classe abstrata para ser implementada pelo cliente que iria instanciá-la diretamente parece uma ideia trabalhosa de se manter. 

<figure>

<!-- @include: ./src/framework/piece/builder/motivacao_sem_padrao.puml -->

<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Builder</figcaption>

</figure>

Ao utilizar o padrão Builder a lógica de como um objeto é criado é separada de sua classe, agora uma interface construtora é responsável por designar um contrato das partes de uma peça que devem ser construídas para instanciar um objeto. Enquanto uma classe direitora possui métodos com diferentes receitas de como instanciar uma peça. 

<figure>

<!-- @include: ./src/framework/piece/builder/motivacao_com_padrao.puml -->


<figcaption>Exemplo de como o jogo pode ser implementado com o padrão Builder</figcaption>
</figure>

Com essa nova implementação, o desenvolvedor pode implementar diferentes maneiras de construir peças que podem ser reutilizáveis.

## Código

### PieceBuilder
<!-- @include: ./src/framework/piece/builder/PieceBuilder.java -->

### Director
<!-- @include: ./src/game/jungle/piece/Director.java -->

### MouseBuilder
<!-- @include: ./src/game/jungle/piece/mouse/MouseBuilder.java -->

### Mouse
<!-- @include: ./src/game/jungle/piece/mouse/Mouse.java -->

## Estrutura

<figure>

<!-- @include: ./src/framework/piece/builder/estrutura.puml -->

<figcaption>Estrutura do Builder</figcaption>

</figure>

## Participantes

- **PieceBuilder** 
  - Especifica uma interface abstrata para criação de partes de um objeto Piece.
- **MouseBuilder**
  - Constrói e monta as partes do produto implementando a interface `PieceBuilder`.  
  - Define e mantém o controle da representação que cria.  
  - Fornece uma interface para adquirir um objeto Piece.  
- **Director**
  - Constrói um objeto usando a interface `PieceBuilder`. 
- **Mouse**
  - Representa o objeto complexo em construção. O `MouseBuilder` constrói a representação interna da classe Piece e define o processo pelo qual ele é montado.  
  - Inclui classes que definem as partes constituintes, incluindo interfaces para montar as partes no resultado final.


## Referências


[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.

# Flyweight

## Intenção

O padrão Flyweight visa compartilhar objetos imutáveis para economizar memória, permitindo que múltiplos objetos semelhantes utilizem a mesma instância.

## Motivação

O padrão Flyweight é uma solução eficaz para reduzir o consumo de memória ao compartilhar partes imutáveis de objetos, permitindo que várias instâncias de objetos compartilhem características comuns. Isso é particularmente útil quando se tem uma grande quantidade de objetos com atributos semelhantes, como no caso das peças de um jogo de tabuleiro.

<figure>

<!-- @include: ./src/framework/piece/flyweight/motivacao_sem_padrao.puml -->

<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Flyweight</figcaption>

</figure>

No caso desse framework, as peças podem ter características imutáveis (como o modelo e a cor) que podem ser compartilhadas entre várias instâncias. Essas características são chamadas de estado intrínseco e podem ser armazenadas em um único objeto, que é compartilhado por todas as peças que possuem essas mesmas características. Por outro lado, o estado extrínseco, que varia para cada instância (por exemplo, a posição de cada peça no tabuleiro), é mantido separadamente e atribuído a cada instância individualmente.

<figure>

<!-- @include: ./src/framework/piece/flyweight/motivacao_com_padrao.puml -->


<figcaption>Exemplo de como o jogo pode ser implementado com o padrão Flyweight</figcaption>
</figure>

Ao aplicar o padrão Flyweight, podemos armazenar as características imutáveis das peças em um único pool de objetos compartilhados, ao invés de criar instâncias repetidas para cada peça. Isso não apenas economiza memória, mas também simplifica o gerenciamento das peças no jogo.

## Código

### PieceFactory
<!-- @include: ./src/framework/piece/flyweight/PieceFactory.java -->

### Piece
<!-- @include: ./src/framework/piece/Piece.java -->

### SharedPiece
<!-- @include: ./src/framework/piece/flyweight/SharedPiece.java -->

### Mouse
<!-- @include: ./src/game/jungle/piece/mouse/Mouse.java -->

## Estrutura

<figure>

<!-- @include: ./src/framework/piece/flyweight/estrutura.puml -->

<figcaption>Estrutura do Flyweight</figcaption>

</figure>

## Participantes

- **Piece (Flyweight)**
  - Declara uma interface pela qual os flyweights podem receber e agir sobre o estado extrínseco.

- **SharedPiece (ConcreteFlyweight)**
  - Implementa a interface Flyweight e adiciona armazenamento para o estado intrínseco, se houver. Um objeto ConcreteFlyweight deve ser compartilhável. Qualquer estado que ele armazene deve ser intrínseco; ou seja, deve ser independente do contexto do objeto ConcreteFlyweight.

- **Mouse (UnsharedConcreteFlyweight)**
  - Nem todas as subclasses de Flyweight precisam ser compartilhadas. A interface Flyweight permite o compartilhamento; ela não o impõe. É comum que objetos UnsharedConcreteFlyweight tenham objetos ConcreteFlyweight como filhos em algum nível na estrutura do objeto flyweight (como as classes Linha e Coluna possuem).

- **PieceFactory**
  - Cria e gerencia objetos flyweight.
  - Garante que os flyweights sejam compartilhados corretamente. Quando um cliente solicita um flyweight, o objeto FlyweightFactory fornece uma instância existente ou cria uma nova, caso nenhuma exista.

- **Client**
  - Mantém uma referência ao(s) flyweight(s).
  - Computa ou armazena o estado extrínseco do(s) flyweight(s).

## Referências


[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.
