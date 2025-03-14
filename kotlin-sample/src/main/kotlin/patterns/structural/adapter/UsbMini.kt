package patterns.structural.adapter

interface UsbMini {
    val hasPower: Power
}

fun UsbMini.toUsbTypeC(): UsbTypeC {
    val hasPower = this.hasPower == Power.TRUE
    return object: UsbTypeC {
        override val hasPower = hasPower
    }
}
