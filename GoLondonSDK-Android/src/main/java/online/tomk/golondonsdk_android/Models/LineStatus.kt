package online.tomk.golondonsdk_android.Models

import kotlinx.datetime.LocalDateTime

@kotlinx.serialization.Serializable
public data class LineStatus (

    public var id: String?,
    public var lineId: String?,
    public var statusSeverity: Int?,
    public var statusSeverityDescription: String?,
    public var reason: String?,
    public var created: LocalDateTime?,
    public var validityPeriods: List<LineStatusValidityPeriod>?,
    public var disruption: Disruption?,
)