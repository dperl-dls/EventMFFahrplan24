package event.pgm.fahrplan.emf2024.dataconverters

import com.google.common.truth.Truth.assertThat
import event.pgm.fahrplan.emf2024.models.Highlight
import org.junit.jupiter.api.Test
import info.metadude.android.eventfahrplan.database.models.Highlight as HighlightDatabaseModel

class HighlightExtensionsTest {

    @Test
    fun toHighlightAppModel() {
        val highlightDatabaseModel = HighlightDatabaseModel(
                sessionId = 2342,
                isHighlight = true
        )
        val highlightAppModel = Highlight(
                sessionId = 2342,
                isHighlight = true
        )
        assertThat(highlightDatabaseModel.toHighlightAppModel()).isEqualTo(highlightAppModel)
    }

}
