package event.pgm.fahrplan.emf2024.net

data class ParseScheduleResult(

        override val isSuccess: Boolean,
        val version: String

) : ParseResult
