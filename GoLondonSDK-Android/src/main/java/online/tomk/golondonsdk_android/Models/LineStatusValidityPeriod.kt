package online.tomk.golondonsdk_android.Models

import kotlinx.datetime.LocalDateTime

@kotlinx.serialization.Serializable
public data class LineStatusValidityPeriod (

    public var fromDate: LocalDateTime?,
    public var toDate: LocalDateTime?,
    public var isNow: Boolean?,
)