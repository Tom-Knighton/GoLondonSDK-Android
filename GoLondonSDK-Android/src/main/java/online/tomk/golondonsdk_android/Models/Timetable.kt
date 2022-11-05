package online.tomk.golondonsdk_android.Models

import kotlinx.datetime.LocalDateTime

@kotlinx.serialization.Serializable
public class StopPointTimetable {

    public val lineId: String
    public val stopPointId: String
    public val direction: String
    public val schedules: List<TimetableSchedule>

    public constructor(
        lineId: String,
        stopPointId: String,
        direction: String,
        schedules: List<TimetableSchedule>
    ) {
        this.lineId = lineId
        this.stopPointId = stopPointId
        this.direction = direction
        this.schedules = schedules
    }
}

@kotlinx.serialization.Serializable
public class TimetableSchedule {

    public val name: String
    public val towards: List<String>
    public val entries: List<TimetableEntry>

    public constructor(name: String, towards: List<String>, entries: List<TimetableEntry>) {
        this.name = name
        this.towards = towards
        this.entries = entries
    }
}

@kotlinx.serialization.Serializable
public class TimetableEntry {

    public val terminatingAt: String
    public val id: Int
    public val time: LocalDateTime

    public constructor(terminatingAt: String, id: Int, time: LocalDateTime) {
        this.terminatingAt = terminatingAt
        this.id = id
        this.time = time
    }
}