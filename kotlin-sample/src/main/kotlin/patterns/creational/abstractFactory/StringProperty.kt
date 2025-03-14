package patterns.creational.abstractFactory

data class StringProperty(
    override val name: String,
    override val value: String
) : Property
