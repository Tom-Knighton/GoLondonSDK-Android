package online.tomk.golondonsdk_android.Models

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
public enum class LineModeGroupStatus {

    @SerialName("All lines are reporting Good Service") allGood,
    @SerialName("Most lines are reporting Good Service") mostGood,
    @SerialName("Some lines are reporting problems") someProblems,
    @SerialName("Many lines are reporting problems") manyProblems,
    @SerialName("All lines are reporting problems") allProblems,
    @SerialName("Unable to determine service status.") unk,
}