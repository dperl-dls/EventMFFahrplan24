package event.pgm.fahrplan.emf2024.extensions

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

/**
 * Sets the given [pairs] as a [Bundle] in this [Fragment].
 */
fun <T : Fragment> T.withArguments(vararg pairs: Pair<String, Any?>): T = apply {
    arguments = bundleOf(*pairs)
}
