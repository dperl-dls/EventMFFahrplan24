package event.pgm.fahrplan.emf2024.net

data class FetchScheduleResult(

        val httpStatus: HttpStatus,
        val hostName: String,
        val exceptionMessage: String = ""

) {

    val isSuccessful
        get() = HttpStatus.HTTP_OK == httpStatus

    val isNotModified
        get() = HttpStatus.HTTP_NOT_MODIFIED == httpStatus

}
