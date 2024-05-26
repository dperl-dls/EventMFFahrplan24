package event.pgm.fahrplan.emf2024.exceptions

import kotlin.coroutines.CoroutineContext

fun interface ExceptionHandling {

    fun onExceptionHandling(context: CoroutineContext, throwable: Throwable)

}
