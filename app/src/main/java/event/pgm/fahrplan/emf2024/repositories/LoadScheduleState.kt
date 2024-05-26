package event.pgm.fahrplan.emf2024.repositories

import event.pgm.fahrplan.emf2024.net.HttpStatus
import event.pgm.fahrplan.emf2024.net.ParseResult

sealed interface LoadScheduleState {

    data object InitialFetching : LoadScheduleState

    data object Fetching : LoadScheduleState

    data object FetchSuccess : LoadScheduleState

    data class FetchFailure(
        val httpStatus: HttpStatus,
        val hostName: String,
        val exceptionMessage: String,
        val isUserRequest: Boolean
    ) : LoadScheduleState

    data object InitialParsing : LoadScheduleState

    data object Parsing : LoadScheduleState

    data object ParseSuccess : LoadScheduleState

    // TODO Merge ParseResult innards into ParseFailure class
    data class ParseFailure(
        val parseResult: ParseResult
    ) : LoadScheduleState

}
