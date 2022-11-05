package online.tomk.golondonsdk_android.Models

@kotlinx.serialization.Serializable
public data class Line (

    public var id: String?,
    public var name: String?,
    public var modeName: String?,
    public var disruptions: List<Disruption>?,
    public var currentStatus: LineStatus?,
)