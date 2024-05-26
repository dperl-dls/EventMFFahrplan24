package event.pgm.fahrplan.emf2024.utils

sealed class ServerBackendType(val name: String) {

    data object PENTABARF : ServerBackendType("pentabarf")
    data object FRAB : ServerBackendType("frab")
    data object PRETALX : ServerBackendType("pretalx")

}
