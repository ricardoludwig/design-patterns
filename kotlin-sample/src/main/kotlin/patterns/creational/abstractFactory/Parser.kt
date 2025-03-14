package patterns.creational.abstractFactory

interface Parser {
    fun server(propertyStrings: List<String>): ServerConfiguration
    fun property(prop: String): Property
}
