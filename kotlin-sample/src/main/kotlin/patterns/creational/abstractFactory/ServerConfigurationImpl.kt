package patterns.creational.abstractFactory

data class ServerConfigurationImpl(
    override val properties: List<Property>
) : ServerConfiguration
