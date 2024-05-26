package event.pgm.fahrplan.emf2024.utils

import androidx.annotation.StringRes

interface Validation {

    fun isValid(): Boolean

    @StringRes
    fun getErrorMessage(): Int?

}
