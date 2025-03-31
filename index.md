---
export_on_save:
  html: true
---

# Builder

## Intenção

...

## Também conhecido como

...

## Motivação

...

<figure>

<!-- @include: ./src/framework/piece/builder/motivacao_sem_padrao.puml -->

<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Builder</figcaption>

</figure>


O padrão Decorator permite que o desenvolvedor adicione novas funcionalidades a um objeto sem alterar sua classe. Isso é feito utilizando a composição e delegação, onde um objeto é composto por outros objetos e os métodos são delegados para os objetos compostos.

<figure>

<!-- @include: ./src/framework/piece/builder/motivacao_com_padrao.puml -->


<figcaption>Exemplo de como o jogo pode ser implementado com o padrão Builder</figcaption>
</figure>

Com essa nova implementação, o desenvolvedor pode adicionar novos itens ao jogo sem precisar criar novas classes para cada combinação de habilidades. Isso torna o código mais flexível e fácil de manter.

<!-- @include: ./src/framework/piece/builder/PieceBuilder.java -->


## Estrutura

<figure>

<!-- @include: ./src/framework/piece/builder/estrutura.puml -->

<figcaption>Estrutura do Decorator</figcaption>

</figure>

## Participantes

...

## Referências


[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.

# Flyweight

## Intenção

...

## Também conhecido como

...

## Motivação

...

<figure>

<!-- @include: ./src/framework/piece/flyweight/motivacao_sem_padrao.puml -->

<figcaption>Exemplo de como o jogo pode ser implementado sem o padrão Builder</figcaption>

</figure>


O padrão Decorator permite que o desenvolvedor adicione novas funcionalidades a um objeto sem alterar sua classe. Isso é feito utilizando a composição e delegação, onde um objeto é composto por outros objetos e os métodos são delegados para os objetos compostos.

<figure>

<!-- @include: ./src/framework/piece/flyweight/motivacao_com_padrao.puml -->


<figcaption>Exemplo de como o jogo pode ser implementado com o padrão Builder</figcaption>
</figure>

Com essa nova implementação, o desenvolvedor pode adicionar novos itens ao jogo sem precisar criar novas classes para cada combinação de habilidades. Isso torna o código mais flexível e fácil de manter.

<!-- @include: ./src/framework/piece/flyweight/PieceFactory.java -->

## Estrutura

<figure>

<!-- @include: ./src/framework/piece/flyweight/estrutura.puml -->

<figcaption>Estrutura do Decorator</figcaption>

</figure>

## Participantes

...

## Referências


[^GAMMA]: GAMMA, Erich. et al. Padrões de projetos: Soluções reutilizáveis de software orientados a objetos Bookman editora, 2009.
