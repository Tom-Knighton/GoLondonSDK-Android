package online.tomk.golondonsdk_android.Models
import kotlinx.serialization.*
import kotlinx.serialization.json.JsonObject

@Serializable
@SerialName("Stop")
public data class StopPoint(
    public override var pointType: PointType,
    public override var lon: Float,
    public override var lat: Float,

    public var icsId: String?,
    public var zone: String?,
    public var id: String?,
    public var name: String?,
    public var commonName: String?,
    public var lineModes: List<LineMode>?,
    public var lineModeGroups: List<LineModeGroup>?,
    public var children: List<StopPoint>?,
    public var properties: List<StopPointProperty>?,
    public var childStationIds: List<String>?,
    public var indicator: String?,
    public var stopLetter: String?,
    public var quietTimeData: StopPointCrowding?,

): GLPoint()

@Serializable
public data class StopPointCrowding(

    public val containsDaily: Boolean,
    public val generalWeeklyCrowding: String,
    public val generalWeekendCrowding: String,
    public val dailyCrowding: JsonObject?,
)

@Serializable
public data class StopPointProperty(val name: String?, val value: String?)