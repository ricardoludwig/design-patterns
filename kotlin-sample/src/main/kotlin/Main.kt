import patterns.creational.abstractFactory.IntProperty
import patterns.creational.builder.Mail
import patterns.creational.sigleton.SingletonHttpClient
import patterns.creational.staticFactoryMethod.Server
import patterns.structural.decorator.DefaultStarTrekRepository
import patterns.structural.decorator.LoggingGetCaptain
import patterns.structural.decorator.ValidatingAdd
import patterns.structural.adapter.cellPhone
import patterns.structural.adapter.charger
import patterns.structural.adapter.usPowerOutlet
import patterns.structural.adapter.toEUPlug
import patterns.structural.adapter.toUsbTypeC
import patterns.structural.bridge.StormTrooper
import patterns.structural.bridge.Rifle
import patterns.structural.bridge.RegularLegs
import patterns.structural.bridge.Flamethrower
import patterns.structural.bridge.AthleticLegs
import patterns.structural.composite.Squad
import patterns.structural.facade.startFromConfiguration
import patterns.behavioral.strategy.OurHero
import patterns.behavioral.strategy.Weapons
import patterns.behavioral.state.Snail
import patterns.behavioral.command.TrooperOrders
import patterns.behavioral.command.moveGenerator
import patterns.behavioral.chainofresponsibility.Request
import patterns.behavioral.interpreter.select
import patterns.behavioral.mediator.Michael
import patterns.behavioral.mediator.MyCompany
import patterns.behavioral.mediator.Manager
import patterns.behavioral.visitor.collectLinks
import patterns.behavioral.visitor.Page
import patterns.behavioral.visitor.Container
import patterns.behavioral.visitor.Image
import patterns.behavioral.visitor.Link
import patterns.behavioral.visitor.Table
import patterns.behavioral.observer.Cat
import patterns.behavioral.observer.Dog
import patterns.behavioral.observer.Bat
import patterns.behavioral.observer.Turkey
import kotlin.concurrent.thread

class App {
    val greeting: String
        get() {
            return "Hello World!"
        }
}

data class Quote(val text: String, val author: String) {
}

fun testDataClass() {
    val quote = Quote("The best way to predict the future is to invent it.", "Alan Kay")
    println("Quote first: $quote")
    val copy = quote.copy(author = "Peter Drucker")
    println("Copy quote $copy")
    //quote.text = "Hello world"
    println("Quote second: $quote")
}

fun main() {
    raceConditionTest()
}

fun singletonPattern() {
    println("Calling Singleton HTTP client")
    println("1st call: instance: ${SingletonHttpClient}")
    println("2nd call: instance: ${SingletonHttpClient}")
    println("Is the same instance? ${SingletonHttpClient == SingletonHttpClient}")
    println("********************************")
    println("Response: ${SingletonHttpClient.response}")
}

fun factoryMethodPattern() {
    println("Calling Factory method")
    val piece = patterns.creational.factoryMethod.createPiece("Qa1")
    println("Piece: $piece")
    println("********************************")
}

fun staticFactoryMethodPattern() {
    println("Calling Static Factory method")
    val server = Server.withPort(8080)
    println("Server: $server")
    println("********************************")
}

fun abstractFactoryPatternServer() {
    val parser = patterns.creational.abstractFactory.YamlParser()
    val server = parser.server(listOf("port: 8080", "environment: production"))
    println("Server: $server")
    println("********************************")
}

fun abstractFactoryPatternProperty() {
    val parser = patterns.creational.abstractFactory.YamlParser()
    val portProperty = parser.property("port: 8080")
    val environmentProperty = parser.property("environment: production")
    // val port:Int? = portProperty.value as? Int
    if (portProperty is IntProperty) {
        val port: Int = portProperty.value
        println("Port: $port - Environment: ${environmentProperty.value}")
    }
}

fun builderPattern() {
    val mail =
            Mail(
                    subject = "Hello",
                    to = listOf("me@mycom.com", "you@mycom.com"),
                    body = "Hello, how are you?",
                    important = true
            )
    println("Mail: $mail")
}

fun decoratorPattern() {
    val starTrekRepository = DefaultStarTrekRepository()
    println("Captain of USS Enterprise: ${starTrekRepository
        .getCaptain("USS Enterprise")}")

    val loggingStarTrekRepository = LoggingGetCaptain(starTrekRepository)
    println("Captain of USS Enterprise: ${loggingStarTrekRepository
        .getCaptain("USS Enterprise")}")

    val validAdd = ValidatingAdd(loggingStarTrekRepository)
    validAdd.addCaptain("USS Voyager", "Kathryn Janeway")
    println("Adding captain to USS Voyager ${validAdd.getCaptain("USS Voyager")}")
}

fun adapterPattern() {
    cellPhone(charger(
        usPowerOutlet().toEUPlug()
        ).toUsbTypeC()
    )
}

fun bridgePattern() {
    val stormTrooper = StormTrooper(Rifle(), RegularLegs())
    println("StormTrooper: $stormTrooper")
    val flameTrooper = StormTrooper(Flamethrower(), RegularLegs())
    println("FlameTrooper: $flameTrooper")
    val scoutTrooper = StormTrooper(Rifle(), AthleticLegs())
    println("ScoutTrooper: $scoutTrooper")
}

fun compositePattern() {
    val squad = Squad(
        StormTrooper(Rifle(), RegularLegs()),
        StormTrooper(Flamethrower(), RegularLegs()),
        StormTrooper(Rifle(), AthleticLegs())
    )
    squad.move(1, 1)
    squad.attackRebel(1, 1)
}

fun facadePattern() {
    val server = Server.withPort(8080)
    server.startFromConfiguration("../app/src/main/kotlin/patterns/structural/facade/server.yaml")
}

fun strategyPattern() {
    val hero = OurHero()
    hero.shoot()
    hero.currentWeapon = Weapons::banana
    hero.shoot()
}

fun iteratorPattern() {
    val platoon = Squad(
        StormTrooper(Rifle(), RegularLegs()),
        StormTrooper(Flamethrower(), RegularLegs()),
        StormTrooper(Rifle(), AthleticLegs()),
        Squad(
            StormTrooper(Rifle(), RegularLegs()),
            StormTrooper(Flamethrower(), RegularLegs()),
            StormTrooper(Rifle(), AthleticLegs())
        )
    )
    for (trooper in platoon) {
        println(trooper)
    }
}

fun statePattern() {
    val snail = Snail()
    snail.seeHero()
    snail.seeHero()
    snail.seeHero()
    snail.getHit(5)
    snail.calmAgain()
    snail.seeHero()
}

fun commandPattern() {
    val trooperOrders = TrooperOrders()
    trooperOrders.addOrder(moveGenerator(trooperOrders, 1, 1))
    trooperOrders.addOrder(moveGenerator(trooperOrders, 2, 2))
    trooperOrders.addOrder(moveGenerator(trooperOrders, 3, 3))
    trooperOrders.executeOrders()
}

fun chainOfResponsibilityPattern() {

    val req = Request(
        "developer@company.com",
        "Why do we need to write tests?"
    )

    val chain = basicValidation(authentication(finalResponse()))

    val response = chain(req)
    println("Response: $response")
}

fun interpreterPattern() {
    val sql = select("name, age") {
        from("users") {
            where( "age > 25")
        }
    }
    println(sql)
}

fun mediatorPattern() {
    val productManager = Michael
    val company = MyCompany(productManager)
    company.taskCompleted(true)
}


fun mementoPattern() {
    val michael = Manager()
    michael.think("Need to implement Coconut Cannon")
    michael.think("Should get some coffee")
    val memento = michael.saveThatThought()
    /*
        We use the **with** standard function to avoid repeating michael.think()
        on each line. This function is helpful if you need to refer to the same
        object often in the same block of code and would like to avoid repetition.
    */
    with(michael) {
        think("Or maybe tea?")
        think("No, actually, let's implement Pineapple Launcher")
    }
    michael.printThoughts()
    michael.`what was I thinking back then`(memento)
    michael.printThoughts()
}

fun visitorPattern() {

    val page = Page(
        Container(
            Image,
            Link,
            Image
            ),
            Table,
            Link,
            Container(
                Table,
                Link
                ),
                Container(Image,
                Container(
                    Image,
                    Link
                    )
                )
                )
   println(collectLinks(page))
}

fun observerPattern() {
    
    val bat = Bat()
    val dog = Dog()
    val turkey = Turkey()

    val catTheConductor = Cat()
    catTheConductor.joinChoir(bat::screech)
    catTheConductor.joinChoir(dog::howl)
    catTheConductor.joinChoir(dog::bark)
    catTheConductor.joinChoir(turkey::gooble)
    catTheConductor.conduct()

}

/*
    The reason for this behavior is that the addition operation and the 
    assignment operation are not atomic. Two threads may override the addition
    operations of each other, resulting in the number not being incremented
    enough times.

    What you need to remember is the following: even if a collection is immutable,
    it may still contain mutable objects inside. Mutable objects are not thread-safe
*/
fun raceConditionTest() {
    val scores = listOf(Player(0))

    val threads = List(2) {
        thread {
            for (i in 1..1000) {
                scores[0].score++
            }
            println("Done")
        }
    }

    for (t in threads) {
        t.join()
    }

    println("Final score: ${scores[0].score}")
 }

private data class Player(var score: Int) 

























