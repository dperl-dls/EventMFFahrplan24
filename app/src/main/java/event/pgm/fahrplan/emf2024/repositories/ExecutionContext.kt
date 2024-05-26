package event.pgm.fahrplan.emf2024.repositories

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

interface ExecutionContext {

    val ui: CoroutineDispatcher
    val network: CoroutineDispatcher
    val database: CoroutineDispatcher

    suspend fun <T> withUiContext(block: suspend CoroutineScope.() -> T) =
            withContext(context = ui, block = block)

}
