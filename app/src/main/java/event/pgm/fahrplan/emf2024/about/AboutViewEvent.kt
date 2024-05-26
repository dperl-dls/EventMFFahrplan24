package event.pgm.fahrplan.emf2024.about

sealed interface AboutViewEvent {

    data class OnPostalAddressClick(val textualAddress: String): AboutViewEvent

}
