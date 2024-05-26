package event.pgm.fahrplan.emf2024.net

sealed class LoadShiftsResult {

    data object Success : LoadShiftsResult()
    data class Error(val httpStatusCode: Int, val exceptionMessage: String) : LoadShiftsResult()
    data class Exception(val throwable: Throwable) : LoadShiftsResult()

}
