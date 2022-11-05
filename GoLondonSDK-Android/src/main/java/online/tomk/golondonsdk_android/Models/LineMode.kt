package online.tomk.golondonsdk_android.Models

import kotlinx.serialization.SerialName
import online.tomk.golondonsdk_android.API.EnumIgnoreUnknownSerializer

@kotlinx.serialization.Serializable(with = LineModeSerializer::class)
public enum class LineMode {

    @SerialName("tube")
    tube,

    @SerialName("bus")
    bus,

    @SerialName("dlr")
    dlr,

    @SerialName("national-rail")
    nationalRail,

    @SerialName("overground")
    overground,

    @SerialName("replacment-bus")
    replacementBus,

    @SerialName("elizabeth-line")
    elizabethLine,

    @SerialName("cable-car")
    cableCar,

    @SerialName("tram")
    tram,

    @SerialName("unk")
    unknown
}

internal object LineModeSerializer :
    EnumIgnoreUnknownSerializer<LineMode>(
        values = LineMode.values(),
        defaultValue = LineMode.unknown
    )