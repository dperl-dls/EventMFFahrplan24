package event.pgm.fahrplan.emf2024.utils

import com.google.common.truth.Truth.assertThat
import info.metadude.android.eventfahrplan.commons.temporal.Moment
import event.pgm.fahrplan.emf2024.models.DateInfo
import event.pgm.fahrplan.emf2024.models.DateInfos
import org.junit.jupiter.api.Test

class FahrplanMiscTest {

    @Test
    fun `createDateInfos returns empty DateInfos`() {
        assertThat(FahrplanMisc.createDateInfos(emptyList())).isEqualTo(DateInfos())
    }

    @Test
    fun `createDateInfos returns DateInfos without duplicates`() {
        val dateInfos = DateInfos()
        dateInfos.add(DateInfo(0, Moment.ofEpochMilli(100)))
        dateInfos.add(DateInfo(1, Moment.ofEpochMilli(200)))
        dateInfos.add(DateInfo(1, Moment.ofEpochMilli(300)))
        dateInfos.add(DateInfo(0, Moment.ofEpochMilli(100)))
        val expectedDateInfos = DateInfos()
        expectedDateInfos.add(DateInfo(0, Moment.ofEpochMilli(100)))
        expectedDateInfos.add(DateInfo(1, Moment.ofEpochMilli(200)))
        expectedDateInfos.add(DateInfo(1, Moment.ofEpochMilli(300)))
        assertThat(FahrplanMisc.createDateInfos(dateInfos)).isEqualTo(expectedDateInfos)
    }

}
