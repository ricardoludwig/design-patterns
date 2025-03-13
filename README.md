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
