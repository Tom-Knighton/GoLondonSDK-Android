package online.tomk.golondonsdk_android.Models
import kotlinx.datetime.LocalDateTime

@kotlinx.serialization.Serializable
public data class Departure(
    public val platformName: String?,
    public val vehicleId: String?,
    public val lineId: String?,
    public val lineMode: LineMode?,
    public val destinationName: String?,
    public val destinationNaptan: String?,
    public val estimatedArrival: LocalDateTime?,
    public val estimatedDeparture: LocalDateTime?,
    public val scheduledArrival: LocalDateTime?,
    public val scheduledDeparture: LocalDateTime?,
    public val status: String?,
    public val towards: String?,
    public val tubeDirection: String?,
    public val currentDirection: String?,
    public val canonicalDirection: String?,
    public val stopBearing: Int?,
    public val stationName: String?,
    public val naptanId: String?,
)

@kotlinx.serialization.Serializable
public data class DepartureLineGroup(val lineId: String?, val lineMode: LineMode?, val platformGroups: List<DeparturePlatformGroup>?)

@kotlinx.serialization.Serializable
public data class DeparturePlatformGroup(
    public val platform: String?,
    public val direction: String?,
    public val departures: List<Departure>?,
    public val canonicalDirection: String?,
)