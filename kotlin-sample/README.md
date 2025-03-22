# Design Patterns - Implementação em Kotlin

## Creational Pattern 

### Singleton

#### Eager Initialization

Em Java e algumas outras linguagens, a tarefe de implementar o padrão Singleton
é complexa. Primeiro é necessário proibir que novas instâncias sejam criadas
alterando o nível de acesso do construtor para privado, a implementação precisa
ser *thread-safe* e ter bom desempenho. Em alguns casos, garantir que aquela 
instância tenha uma inicialização tardia, *lazy initialization*. 

Em Kotlin algumas dessas preocupações foram resolvidas com uso da palavra chave,
**keyword**, ***object***.

* ***object*** tem uma diferença em relação a criação de classes em Java,
ele não tem construtores, por isso, se for necessário implementar algum tipo
de inicialização para o **Singleton** que estiver criando, por exemplo, 
carregar dados de um arquivo, isso terá que ser feito com o **init**.

Abaixo temos um exemplo de implementação de um **Singleton** em Kotlin, retirada
do livro *Kotlin Design Patterns and Best Practices*.

Aqui temos um exemplo de *Singleton* utilizando uma abordagem de 
*Eager Initialization*, através do bloco **init** para fazer a requisição 
HTTP e armazenar a resposta na variável *response*.

```kotlin

object SingletonHttpClient {

    var response: String = ""
    private set

    init {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=612"))
            .build()
        val client = HttpClient.newHttpClient()
        response = client
            .send(request, HttpResponse.BodyHandlers.ofString()).body()
    }
}

```

#### Lazy Initialization

O uso do **lazy** *delegate* permite a implementação do padrão com a 
inicialização tardia. 

Observer que essa implementação não é *thread-safe*.

```kotlin

class SingletonLazyHttpClient {
    var response: String = ""
        private set

    companion object {
        val instance: SingletonLazyHttpClient by lazy {
            SingletonLazyHttpClient()
        }
    }

    fun request() {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=612"))
            .build()
        val client = HttpClient.newHttpClient()
        response = client
            .send(request, HttpResponse.BodyHandlers.ofString()).body()
        println("Response: $response")
    }
}

```
#### Thread Safe

##### Solução com *synchronized* e *double-checked locking*

```kotlin

class SingletonSynchronized private constructor(private val data: String) {
    companion object {
        @Volatile
        private var instance: SingletonSynchronized? = null

        fun getInstance(value: String): SingletonSynchronized? {
            if (instance == null) {
                synchronized(this) {
                    if (instance == null) {
                        instance = SingletonSynchronized(value)
                    }
                }
            }
            return instance
        }
    }
    
    fun getData(): String = data
}

```

##### Solução com Static Holder Pattern 

Essa implementação possui várias características importantes:

* **Construtor privado** para evitar a instanciação direta  
* **Objeto companion** para manter a instância do singleton  
* **Padrão de verificação dupla (double-check locking)** para segurança em 
ambientes concorrentes  
* **Inicialização tardia** (a instância é criada apenas quando necessária)  
* Segurança em múltiplas threads usando **@Volatile** e bloco **synchronized**
- **Desempenho**: Após a criação inicial, não há sobrecarga de sincronização
- **Segurança de memória**: A anotação **@Volatile** garante a visibilidade 
adequada entre threads

> Embora o Kotlin também ofereça a declaração `object` para singletons, o 
padrão Holder oferece **mais flexibilidade** quando você precisa de:

- **Construção com parâmetros**
- **Inicialização tardia**
- **Mais controle sobre o processo de inicialização**

```kotlin

class SingletonHolder private constructor(private val data: String) {

    companion object {
        @Volatile
        private var instance: SingletonHolder? = null

        fun getInstance(value: String): SingletonHolder =
            instance ?: synchronized(this) {
                instance ?: SingletonHolder(value).also { instance = it }
            }
        //Add this method for testing purposes
        fun reset() {
            instance = null
        }
    }

    fun getData(): String = data

}

```

## Testando os exemplos 

### Requerimentos 

- Maven 3.6
- Java 21
- Kotlin

### Uso

### Execução

``mvn package``

``java -jar kotlin-console-app-0.0.1-SNAPSHOT-jar-with-dependencies.jar``

Ou

``make run``

### Testes

* ``mvn test``: Roda somente os testes unitários

