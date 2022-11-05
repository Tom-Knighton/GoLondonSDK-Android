package online.tomk.golondonsdk_android.Models


@kotlinx.serialization.Serializable
public data class LineRoute(val id: String?, val name: String?, val direction: String?, val originationName: String?, val destinaionName: String?)


@kotlinx.serialization.Serializable
public data class LineRoutes(

    public var lineId: String?,
    public var lineName: String?,
    public var stopPointSequences: List<Branch>?,
    public var lineMapRoutes: List<List<List<Double>>>?,
    public var direction: LineDirection?,
)

@kotlinx.serialization.Serializable
public data class Branch (

    public var lineId: String?,
    public var lineName: String?,
    public var branchId: Int?,
    public var nextBranchIds: List<Int>?,
    public var previousBranchIds: List<Int>?,
    public var stopPoint: List<StopPoint>?,
)