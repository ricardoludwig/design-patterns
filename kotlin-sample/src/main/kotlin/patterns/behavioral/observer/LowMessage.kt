package patterns.behavioral.observer

data class LowMessage(override val repeat: Times) : Message {
    override val pitch: SoundPitch = SoundPitch.LOW
}
