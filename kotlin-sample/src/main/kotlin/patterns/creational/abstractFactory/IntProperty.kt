package patterns.creational.abstractFactory

data class IntProperty(
    override val name: String,
    override val value: Int
) : Property
