#  "Padrões de Projetos (Design Patterns)"

*Design Patterns* são soluções comprovadas para problemas recorrentes. No
mundo do desenvolvimento de software temos os padrões de projetos apresentados
no livro *Design Patterns: Elements of Reusable Object-Oriented Software*
escrito por *Erich Gamma*, *Richard Helm*, *Ralph Johnson* e *John Vlissides*.

Os 23 padrões de projetos apresentados no livro são divididos em três categorias:

1. Padrões de Criação (*Creational Patterns*)
2. Padrões Estruturais (*Structural Patterns*)
3. Padrões Comportamentais (*Behavioral Patterns*)

## Padrões de Criação (*Creational Patterns*)

## O que são?

São os padrões que focam na **forma como objetos são criados**. Eles encapsulam 
a lógica de instanciação, promovendo maior flexibilidade ao permitir que o 
código fique **independente da implementação concreta** das classes que utiliza.

O objetivo principal é **desacoplar o processo de criação dos objetos do seu 
uso**, facilitando mudanças e promovendo maior reutilização de código.

## Problemas que resolvem

* **Criação direta de objetos** que depende de implementações específicas, 
dificultando a manutenção e evolução do código.
* **Código duplicado** relacionado à instância de objetos com lógica complexa 
de construção.
* **Dependência de classes concretas**, reduzindo a flexibilidade e a 
capacidade de testar.
* **Incapacidade de controlar ou padronizar a criação de instâncias** em 
contextos mais complexos (por exemplo, sistemas com muitas variações de objetos 
ou que exigem controle de ciclo de vida).

## Exemplos de Padrões de Criação

* **Singleton** – Garante que uma classe tenha apenas uma instância e fornece 
um ponto global de acesso a ela.
* **Factory Method** – Define uma interface para criar um objeto, mas permite 
que subclasses decidam qual classe instanciar.
* **Abstract Factory**, é uma *factory* de *factories*, ou seja, é uma classe 
capaz de criar outras classes. É uma classe que encapsula múltiplos métodos de 
fábrica.
* **Builder**, utilizado para criação de objetos complexos, onde a criação do 
objeto depende de muitos parâmetros. O padrão de design **Builder** desacopla a 
atribuição de argumentos da criação de objetos e permite a construção de objetos 
complexos passo a passo. 
* **Prototype**, utilizado para a criação de objetos ligeiramente diferentes.
Isso é feito clonando um objeto existente e fazendo as alterações necessárias.

## Desvantagens

Apesar de trazerem maior flexibilidade, os padrões de criação também têm 
**desvantagens**:

* **Complexidade de código**: Introduzem várias interfaces, classes abstratas 
ou objetos auxiliares, o que pode aumentar o esforço de entendimento.
* **Sobrecarga desnecessária**: Para casos simples, aplicar padrões como Builder 
ou Abstract Factory pode ser exagero e resultar em *overengineering*.
* **Dificuldade de depuração**: A criação indireta pode dificultar o 
rastreamento da origem de objetos em ambientes com muitos níveis de abstração.
* **Excesso de classes**: Muitos desses padrões requerem várias classes ou 
estruturas auxiliares, o que pode poluir o projeto se não for bem organizado.

## Padrões Estruturais (*Structural Patterns*)

### O que são?

Os **Padrões Estruturais** tratam da **forma como classes e objetos são 
compostos para formar estruturas maiores**. Seu principal objetivo é facilitar 
o **design de sistemas flexíveis e reutilizáveis**, promovendo o baixo 
acoplamento entre os componentes.

Eles se concentram em **como as entidades são conectadas**, facilitando a 
**extensão de funcionalidades** sem necessidade de modificar o código 
existente (aderência ao princípio **Open/Closed**).

### Problemas que resolvem

* **Acoplamento rígido entre classes** que dificulta a reutilização.
* **Designs que não escalam bem** com o crescimento do sistema.
* **Dificuldade em alterar a estrutura interna de objetos** sem impactar o 
restante da aplicação.
* **Incompatibilidade entre interfaces de classes** que precisam trabalhar juntas.

### Exemplos de Padrões Estruturais

* **Adapter** – Permite que interfaces incompatíveis trabalhem juntas.
* **Bridge** – Separa uma abstração da sua implementação.
* **Composite** – Permite tratar objetos individuais e composições de objetos 
de maneira uniforme.
* **Decorator** – Adiciona responsabilidades a objetos dinamicamente.
* **Facade** – Fornece uma interface simplificada para um subsistema complexo.
* **Flyweight** – Compartilha objetos para economizar memória.
* **Proxy** – Fornece um substituto ou representante de outro objeto.

### Desvantagens

Embora tragam muitos benefícios, os padrões estruturais também têm 
**desvantagens**, como:

* **Complexidade adicional**: Podem introduzir novas classes e interfaces, 
tornando o sistema mais difícil de entender.
* **Sobrecarga de abstrações**: O uso excessivo pode dificultar a manutenção por 
causa do número de camadas envolvidas.
* **Desempenho**: Em alguns casos, como com `Proxy` ou `Decorator`, pode haver 
uma penalidade de desempenho devido à delegação de chamadas.
* **Dificuldade de depuração**: Quando muitas estruturas envolvem um objeto, 
rastrear a origem de um problema pode se tornar mais difícil.

## Padrões Comportamentais (*Behavioral Patterns*)

### O que são?

Os **Padrões Comportamentais** tratam da **comunicação e interação entre 
objetos**. Eles definem **como responsabilidades são distribuídas** entre os 
objetos e **como eles colaboram** para realizar tarefas, respeitando o baixo 
acoplamento e promovendo maior flexibilidade e reutilização.

Esses padrões ajudam a **encapsular o comportamento** e 
**delegar responsabilidades**, tornando o código mais coeso e fácil de manter.

### Problemas que resolvem

* **Distribuição ineficiente de responsabilidades** entre classes.
* **Acoplamento forte entre objetos**, dificultando a reutilização e testes.
* **Dificuldade em alterar comportamentos** sem modificar o código existente.
* **Falta de flexibilidade nas interações entre objetos**, levando à rigidez do 
sistema.
* **Código com muitos condicionais** para decidir qual comportamento executar.

## Exemplos de Padrões Comportamentais

* **Chain of Responsibility** – Passa a solicitação por uma cadeia de objetos até 
que um deles a processe.
* **Command** – Encapsula uma solicitação como um objeto, permitindo parametrizar 
clientes com diferentes requisições.
* **Interpreter** – Avalia sentenças em uma linguagem, representando sua 
gramática com classes.
* **Iterator** – Fornece uma maneira de acessar os elementos de um objeto 
agregado sequencialmente sem expor sua estrutura interna.
* **Mediator** – Define um objeto que centraliza a comunicação entre objetos, 
promovendo o baixo acoplamento.
* **Memento** – Captura e externaliza o estado interno de um objeto sem violar 
seu encapsulamento.
* **Observer** – Define uma dependência um para muitos entre objetos para que, 
quando um objeto mudar de estado, todos os seus dependentes sejam notificados.
* **State** – Permite que um objeto altere seu comportamento quando seu estado 
interno muda.
* **Strategy** – Define uma família de algoritmos, encapsula cada um deles e 
os torna intercambiáveis.
* **Template Method** – Define o esqueleto de um algoritmo em uma operação, 
deixando alguns passos para as subclasses.
* **Visitor** – Permite adicionar operações a objetos de uma estrutura sem 
alterar suas classes.

## Desvantagens

Embora úteis, os padrões comportamentais também apresentam **desvantagens**:

* **Aumento da complexidade**: Muitos padrões introduzem várias interfaces e 
classes auxiliares, o que pode complicar o projeto.
* **Dificuldade de rastreamento**: A lógica distribuída entre vários objetos ou 
métodos pode dificultar o entendimento do fluxo de execução.
* **Possível sobrecarga de abstrações**: Em casos simples, pode ser exagerado 
aplicar esses padrões, gerando código mais difícil de manter.
* **Manutenção complexa**: Comportamentos espalhados por múltiplos objetos ou 
delegados a outras classes podem dificultar a depuração e manutenção do sistema.

