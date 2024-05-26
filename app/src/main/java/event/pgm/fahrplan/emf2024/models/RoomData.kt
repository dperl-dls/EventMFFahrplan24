package event.pgm.fahrplan.emf2024.models

data class RoomData(
        val roomName: String,
        val sessions: List<Session>
)
