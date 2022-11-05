package online.tomk.golondonsdk_android.Models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StopPointAccessibility(val stationName: String?, val overviewAccessibility: StationAccessibilityType?, val lineAccessibility: List<StopPointLineAccessibility>?)

@Serializable
public data class StopPointLineAccessibility(val lineName: String?, val lineDirection: String?, val accessibility: StationAccessibilityType?)

@Serializable
public enum class StationAccessibilityType {
    @SerialName("StepFreeToTrain")
    StepFreeToTrain,

    @SerialName("StepFreeToPlatform")
    StepFreeToPlatform,

    @SerialName("Partial")
    PartialToPlatform,

    @SerialName("Interchange")
    InterchangeOnly,

    @SerialName("None")
    None,
}