package event.pgm.fahrplan.emf2024.sharing

import com.squareup.moshi.Moshi
import event.pgm.fahrplan.emf2024.models.Session
import event.pgm.fahrplan.emf2024.sharing.models.FavoritesExport
import event.pgm.fahrplan.emf2024.sharing.models.SessionExport

class JsonSessionFormat(

    private val moshi: Moshi = Moshi.Builder().build()

) {

    private val jsonAdapter by lazy { moshi.adapter(FavoritesExport::class.java) }

    fun format(session: Session): String {
        val export = FavoritesExport(listOf(SessionExport(session)))
        return jsonAdapter.toJson(export)
    }

    fun format(sessions: List<Session>): String? {
        return when {
            sessions.isEmpty() -> null
            sessions.size == 1 -> format(sessions[0])
            else -> {
                val export = FavoritesExport(sessions.map { SessionExport(it) })
                return jsonAdapter.toJson(export)
            }
        }

    }
}
