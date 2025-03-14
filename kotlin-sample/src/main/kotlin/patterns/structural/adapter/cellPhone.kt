package patterns.structural.adapter

import patterns.structural.adapter.UsbTypeC
import patterns.structural.adapter.USPlug

fun cellPhone(chargeCable: UsbTypeC) {
    if (chargeCable.hasPower) {
        println("I've got the power!")
    } else {
        println("No power")
    }
}

fun usPowerOutlet(): USPlug {
    return object : USPlug {
        override val hasPower = 1
    }
}

fun charger(plug: EUPlug) : UsbMini {
    return object : UsbMini {
        override val hasPower = Power.valueOf(plug.hasPower)
    }
}

