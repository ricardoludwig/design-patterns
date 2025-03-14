package patterns.behavioral.observer

data class HighMessage(override val repeat: Times) : Message {
    override val pitch: SoundPitch = SoundPitch.HIGH
}
