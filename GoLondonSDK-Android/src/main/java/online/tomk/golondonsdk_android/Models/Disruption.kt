package online.tomk.golondonsdk_android.Models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
public data class Disruption(
    public var description: String?,
    public var created: LocalDateTime?,
    public var lastUpdate: LocalDateTime?,
    public var affectedRoutes: List<LineRoute>?,
    public var closureText: String?,
    public var delayType: DisruptionDelayType?,
)

@kotlinx.serialization.Serializable
public enum class DisruptionDelayType {

    @SerialName("No Delays") noDelays,
    @SerialName("Minor Delays") minorDelays,
    @SerialName("Severe Delays") severeDelays,
    @SerialName("Planned Closure") plannedClosure,
}