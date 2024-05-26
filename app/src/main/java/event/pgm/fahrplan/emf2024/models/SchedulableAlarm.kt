package event.pgm.fahrplan.emf2024.models

data class SchedulableAlarm(

        val day: Int,
        val sessionId: String,
        val sessionTitle: String,
        val startTime: Long

)
