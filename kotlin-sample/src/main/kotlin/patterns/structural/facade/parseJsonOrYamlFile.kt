package patterns.structural.facade

import kotlin.io.path.Path
import patterns.creational.staticFactoryMethod.Server
import patterns.creational.abstractFactory.YamlParser
import patterns.creational.abstractFactory.JsonParser

fun Server.startFromConfiguration(fileLocation: String) {

    val path = Path(fileLocation)
    val lines = path.toFile().readLines()
    val configuration = try {
        YamlParser().server(lines)
    } catch (e: RuntimeException) {
        JsonParser().server(lines) //TODO JonParser
    }
    val portNumber = configuration.properties.component2().value as? Int?: 
        throw RuntimeException("Port number must be a long")
    Server.withPort(portNumber.toLong())
}
