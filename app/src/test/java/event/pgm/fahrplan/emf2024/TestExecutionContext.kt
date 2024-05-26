package event.pgm.fahrplan.emf2024

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Unconfined
import event.pgm.fahrplan.emf2024.repositories.ExecutionContext

object TestExecutionContext : ExecutionContext {
    override val ui: CoroutineDispatcher = Unconfined
    override val network: CoroutineDispatcher = Unconfined
    override val database: CoroutineDispatcher = Unconfined
}
