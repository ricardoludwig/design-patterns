package patterns.creational.abstractFactory

class JsonParser: Parser {

    override fun server(propertyStrings: List<String>): ServerConfiguration {
        val parsedProperties = mutableListOf<Property>()
        for (p in propertyStrings) {
            parsedProperties += property(p)
        }
        return ServerConfigurationImpl(parsedProperties)
    }

    override fun property(prop: String): Property {
        val (name, value) = prop.split(":")
        return when (name) {
            "port" -> IntProperty(name, value.trim().toInt())
            "environment" -> StringProperty(name, value.trim())
            else -> throw RuntimeException("Unknown property: $name")
        }
    }
}
