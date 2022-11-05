package online.tomk.golondonsdk_android.Models

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
public data class Journey(
    public var startDateTime: LocalDateTime?,
    public var arrivalDateTime: LocalDateTime?,
    public var duration: Int?,
    public var legs: List<JourneyLeg>?,
)

@kotlinx.serialization.Serializable
public data class JourneyLeg(

    public var instruction: JourneyLegInstruction?,
    public var departureTime: LocalDateTime?,
    public var arrivalTime: LocalDateTime?,
    public var departurePoint: StopPoint?,
    public var arrivalPoint: StopPoint?,
    public var path: JourneyLegPath?,
    public var routeOptions: List<JourneyLegRouteOptions>?,
    public var mode: JourneyMode?,
    public var disruptions: List<Disruption>?,
    public var isDisrupted: Boolean?,
    public var hasFixedLocations: Boolean?,
)

@kotlinx.serialization.Serializable
public data class JourneyLegInstruction(val summary: String?, val detailed: String?)

@kotlinx.serialization.Serializable
public data class JourneyLegPath(val stopPoints: List<StopPoint>?)

@kotlinx.serialization.Serializable
public data class JourneyLegRouteOptions(val name: String?, val directions: List<String>?, val lineIdentifier: Line?)

@kotlinx.serialization.Serializable
public data class JourneyMode(val id: String?, val name: String?, val type: String?)

@kotlinx.serialization.Serializable
public enum class JourneyDateType {
    @SerialName("Arrive At") arriveAt,
    @SerialName("Depart At") departAt
}
