package online.tomk.golondonsdk_android.Models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
public enum class LineDirection {

    @SerialName("inbound") inbound,
    @SerialName("outbound") outbound,
}