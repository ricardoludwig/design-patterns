package patterns.creational.abstractFactory

class YamlParser : Parser {

    override fun server(propertyStrings: List<String>): ServerConfiguration {
        val parsedProperties = mutableListOf<Property>()
        for (p in propertyStrings) {
            parsedProperties += property(p)
        }
        return ServerConfigurationImpl(parsedProperties)
    }

    override fun property(prop: String): Property {
        val (name, value) = prop.split(":")
        return when (name.trim()) {
            "server" -> StringProperty(name.trim(), value.trim())
            "port" -> IntProperty(name.trim(), value.trim().toInt())
            "environment" -> StringProperty(name.trim(), value.trim())
            else -> throw RuntimeException("Unknown property: $name")
        }
    }
}
