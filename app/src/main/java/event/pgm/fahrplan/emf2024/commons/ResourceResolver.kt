package event.pgm.fahrplan.emf2024.commons

import android.content.Context

class ResourceResolver(val context: Context) : ResourceResolving {

    override fun getString(id: Int, vararg formatArgs: Any) = context.getString(id, *formatArgs)

}
