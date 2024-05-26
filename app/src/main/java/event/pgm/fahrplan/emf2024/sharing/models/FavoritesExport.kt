package event.pgm.fahrplan.emf2024.sharing.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FavoritesExport(

        // Keep "lectures" key for Chaosflix export.
        val lectures: List<SessionExport>

)
