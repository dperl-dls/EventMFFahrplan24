package event.pgm.fahrplan.emf2024.dataconverters

import info.metadude.android.eventfahrplan.database.models.Alarm as DatabaseAlarm


fun List<DatabaseAlarm>.toAlarmsAppModel() = map(DatabaseAlarm::toAlarmAppModel)
