package event.pgm.fahrplan.emf2024.navigation

import android.net.Uri
import event.pgm.fahrplan.emf2024.models.Room

interface IndoorNavigation {
    fun isSupported(room: Room): Boolean
    fun getUri(room: Room): Uri
}
