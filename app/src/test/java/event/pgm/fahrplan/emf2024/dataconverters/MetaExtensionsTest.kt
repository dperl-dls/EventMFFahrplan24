package event.pgm.fahrplan.emf2024.dataconverters

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.threeten.bp.ZoneId
import info.metadude.android.eventfahrplan.database.models.HttpHeader as HttpHeaderDatabaseModel
import info.metadude.android.eventfahrplan.database.models.Meta as MetaDatabaseModel
import info.metadude.android.eventfahrplan.network.models.HttpHeader as HttpHeaderNetworkModel
import info.metadude.android.eventfahrplan.network.models.Meta as MetaNetworkModel
import event.pgm.fahrplan.emf2024.models.HttpHeader as HttpHeaderAppModel
import event.pgm.fahrplan.emf2024.models.Meta as MetaAppModel

class MetaExtensionsTest {

    private val metaAppModel = MetaAppModel(
            httpHeader = HttpHeaderAppModel(
                eTag = "abc123",
                lastModified = "2019-12-31T23:59:59+01:00",
            ),
            numDays = 23,
            subtitle = "My subtitle",
            timeZoneId = ZoneId.of("Europe/Berlin"),
            title = "My title",
            version = "v.9.9.9"
    )

    private val metaDatabaseModel = MetaDatabaseModel(
            httpHeader = HttpHeaderDatabaseModel(
                eTag = "abc123",
                lastModified = "2019-12-31T23:59:59+01:00",
            ),
            numDays = 23,
            subtitle = "My subtitle",
            timeZoneName = "Europe/Berlin",
            title = "My title",
            version = "v.9.9.9"
    )

    private val metaNetworkModel = MetaNetworkModel(
            httpHeader = HttpHeaderNetworkModel(
                eTag = "abc123",
                lastModified = "2019-12-31T23:59:59+01:00",
            ),
            numDays = 23,
            subtitle = "My subtitle",
            timeZoneName = "Europe/Berlin",
            title = "My title",
            version = "v.9.9.9"
    )

    @Test
    fun `toMetaNetworkModel converts an app into a network model`() {
        assertThat(metaAppModel.toMetaNetworkModel()).isEqualTo(metaNetworkModel)
    }

    @Test
    fun `toMetaAppModel converts a database into an app model`() {
        assertThat(metaDatabaseModel.toMetaAppModel()).isEqualTo(metaAppModel)
    }

    @Test
    fun `toMetaDatabaseModel converts a network into a database model`() {
        assertThat(metaNetworkModel.toMetaDatabaseModel()).isEqualTo(metaDatabaseModel)
    }

}
