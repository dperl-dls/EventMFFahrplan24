package event.pgm.fahrplan.emf2024

import info.metadude.android.eventfahrplan.commons.logging.Logging

object NoLogging : Logging {
    override fun d(tag: String, message: String) = Unit
    override fun e(tag: String, message: String) = Unit
    override fun report(tag: String, message: String) = Unit
}
