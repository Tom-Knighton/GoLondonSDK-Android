package online.tomk.golondonsdk_android.Models

import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.*

@OptIn(ExperimentalSerializationApi::class)
@kotlinx.serialization.Serializable(with = PointDeserialiser::class)
@JsonClassDiscriminator("pointType")
public sealed class GLPoint {
    abstract val lat: Float
    abstract val lon: Float
    abstract val pointType: PointType
}

@kotlinx.serialization.Serializable
public enum class PointType {

    @SerialName("Stop") StopPoint,
    @SerialName("POI") POIPoint,
}

object PointDeserialiser : JsonContentPolymorphicSerializer<GLPoint>(GLPoint::class) {
    override fun selectDeserializer(element: JsonElement): DeserializationStrategy<out GLPoint> {

        return if (element.jsonObject["pointType"].toString().lowercase() == "\"stop\"") {
            StopPoint.serializer()
        } else {
            POIPoint.serializer()
        }
    }
}