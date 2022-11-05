package online.tomk.golondonsdk_android.Models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
@SerialName("POI")
public data class POIPoint(
    override var pointType: PointType,
    override var lon: Float,
    override var lat: Float,

    public var id: String?,
    public var text: String?,

    public var place_name: String?,
): GLPoint()