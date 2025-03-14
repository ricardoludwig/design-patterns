# Padrões de Projetos (Design Patterns)

*Design Patterns* são soluções comprovadas para problemas recorrentes. No
mundo do desenvolvimento de software temos os padrões de projetos apresentados
no livro *Design Patterns: Elements of Reusable Object-Oriented Software*
escrito por *Erich Gamma*, *Richard Helm*, *Ralph Johnson* e *John Vlissides*.

Os 23 padrões de projetos apresentados no livro são divididos em três categorias:

1. Padrões de Criação (*Creational Patterns*)
2. Padrões Estruturais (*Structural Patterns*)
3. Padrões Comportamentais (*Behavioral Patterns*)

## Padrões de Criação (*Creational Patterns*)

São os padrões focados na criação de objetos de maneira flexível, são eles:

* **Factory Method**, define uma interface para criar um objeto, mas permite que 
as subclasses alterem o tipo de objetos que serão criados.

* **Abstract Factory**, é uma *factory* de *factories*, ou seja, é uma classe 
capaz de criar outras classes. É uma classe que encapsula múltiplos métodos de 
fábrica.

* **Builder**, utilizado para criação de objetos complexos, onde a criação do 
objeto depende de muitos parâmetros. O padrão de design **Builder** desacopla a 
atribuição de argumentos da criação de objetos e permite a construção de objetos 
complexos passo a passo. 

* **Prototype**, utilizado para a criação de objetos ligeiramente diferentes.
Isso é feito clonando um objeto existente e fazendo as alterações necessárias.

* **Singleton**, garante que uma classe tenha apenas uma instância e fornece 
um único ponto de acesso.

## Singleton

O padrão Singleton resolve dois problemas:

1. **Garante que classe que implementa esse padrão terá apenas uma instancia.**
Isso permite que o acesso ao um recurso que é compartilhado, por exemplo,
conexão com banco de dados ou dados de um arquivo carregado do sistema de 
arquivos.

2. **Disponibilizar um ponto de acesso global para a instância.** Isso 
quer dizer que a solução implementada com poderá ser aproveita pelo o restante 
da aplicação sem a necessidade de outras implementações. A ideia é semelhante
ao uso de variáveis globais, mas sem o efeito negativo de alteração de valores
ao longo do fluxo de execução, Singleton protege desse comportamento indesejável.

O uso desse padrão é aplicável nos casos onde é desejável que exista uma única
instância para todos os clientes ou quando precisa ter controle sobre variáveis
globais.

### Diagrama

![Singleton](img/singleton-pattern.svg)

### Vantagens

* Há certeza que classe existirá apenas uma instância da classe.

* Ponto de acesso global para a instância.

* *Lazy Initialization*, o objeto é inicializado apenas quando é requisitado,
na primeira vez.

### Desvantagens

* O padrão poder mascarar um *design* ruim, por exemplo, quando componentes da
aplicação conhecem muito entre si.

* Se for inocentemente implementado pode acarretar em problemas de concorrência
em ambientes *multithread*.

* Pode ser difícil escrever teste unitários para esse tipo de implementação, por
conta de restrições dos **frameworks** de testes e **mocks**.


