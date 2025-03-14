package patterns.structural.adapter

interface USPlug {
    val hasPower: Int
}

fun USPlug.toEUPlug(): EUPlug {
    val hasPower = if (this.hasPower == 1) "TRUE" else "FALSE"
    return object : EUPlug {
        override val hasPower: String = hasPower
    }
}
