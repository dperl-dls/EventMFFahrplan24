package event.pgm.fahrplan.emf2024.dataconverters

import event.pgm.fahrplan.emf2024.models.Highlight
import info.metadude.android.eventfahrplan.database.models.Highlight as HighlightDatabaseModel

fun HighlightDatabaseModel.toHighlightAppModel() = Highlight(
        sessionId = sessionId,
        isHighlight = isHighlight
)
