package event.pgm.fahrplan.emf2024.commons

import androidx.annotation.StringRes

@Suppress("kotlin:S6517")
interface ResourceResolving {

    fun getString(@StringRes id: Int, vararg formatArgs: Any = emptyArray()): String

}
