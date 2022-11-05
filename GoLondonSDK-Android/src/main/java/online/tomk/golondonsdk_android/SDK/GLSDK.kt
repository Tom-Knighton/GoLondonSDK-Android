package online.tomk.golondonsdk_android.SDK

import android.graphics.Point
import online.tomk.golondonsdk_android.API.*
import online.tomk.golondonsdk_android.Models.*;
import java.time.LocalDateTime
import java.util.Date

public class GLSDK {

    public class Journeys {
        companion object {

            suspend fun MakeJourney(from: String, to: String, via: String? = null, time: LocalDateTime? = null, timeType: JourneyDateType? = JourneyDateType.arriveAt): List<Journey> {
                return JourneyService.GetPossibleJourneys(from, to, via, time, timeType) ?: listOf();
            }

            suspend fun MakeJourney(fromCoords: Pair<Float, Float>, to: String, via: String? = null, time: LocalDateTime? = null, timeType: JourneyDateType? = JourneyDateType.arriveAt): List<Journey> {
                return MakeJourney("${fromCoords.first},${fromCoords.second}", to, via, time, timeType)
            }

            suspend fun MakeJourney(fromCoords: Pair<Float, Float>, toCoords: Pair<Float, Float>, via: String? = null, time: LocalDateTime? = null, timeType: JourneyDateType? = JourneyDateType.arriveAt): List<Journey> {
                return MakeJourney("${fromCoords.first},${fromCoords.second}", "${toCoords.first},${toCoords.second}", via, time, timeType)
            }

            suspend fun MakeJourney(from: String, toCoords: Pair<Float, Float>, via: String? = null, time: LocalDateTime? = null, timeType: JourneyDateType? = JourneyDateType.arriveAt): List<Journey> {
                return MakeJourney(from, "${toCoords.first},${toCoords.second}", via, time, timeType)
            }
        }
    }

    public class Lines {
        companion object {
            /*
            * Gets a list of disruptions affecting the specified LineMode
            * */
            public suspend fun Disruptions(lineMode: LineMode): List<Disruption> {
                return LineService.GetDisruptions(lineMode) ?: listOf();
            }

            /*
            *   Gets a list of disruptions affecting the specified LineModes
            */
            public suspend fun Disruptions(lineModes: List<LineMode>): List<Disruption> {
                var disruptions: List<Disruption> = listOf();
                for (lineMode in lineModes) {
                    disruptions += LineService.GetDisruptions(lineMode) ?: listOf();
                }
                return disruptions;
            }
            /*
            * Gets the Line object and info for a specified LineId, optionally include disruption details
            * */
            public suspend fun Line(lineId: String, includeDetails: Boolean = false): Line? {
                return LineService.GetLineInfoForIds(listOf(lineId), includeDetails)?.firstOrNull();
            }

            /*
            * Gets the Line objects and info, optionally including disruption details, for a list of lineIds
            * */
            public suspend fun Lines(lineIds: List<String>, includeDetails: Boolean = false): List<Line> {
                return LineService.GetLineInfoForIds(lineIds, includeDetails) ?: listOf();
            }

            /*
            * Gets the Lines for a LineMode
            * */
            public suspend fun LinesByLineMode(lineMode: LineMode, includeDetails: Boolean = false): List<Line> {
                return LineService.GetLineInfoForModes(listOf(lineMode), includeDetails) ?: listOf();
            }

            /*
            * Gets the Lines for all specified lineModes
            * */
            public suspend fun LinesByLineMode(lineModes: List<LineMode>, includeDetails: Boolean = false): List<Line> {
                return LineService.GetLineInfoForModes(lineModes, includeDetails) ?: listOf();
            }

            /*
            * Gets the general/overview status for a group of lineModes
            * */
            public suspend fun Status(lineModes: List<LineMode>): LineModeGroupStatus {
                return LineService.GetGeneralStatusString(lineModes) ?: LineModeGroupStatus.unk;
            }

            /*
            * Gets the LineRoutes object for the specified lineids
            * */
            public suspend fun Routes(lineIds: List<String>, fixCoordinates: Boolean = true): List<LineRoutes> {
                return LineService.GetLineRoutes(lineIds, fixCoordinates) ?: listOf();
            }

            /*
            * Gets the LineRoutes object for a lineId
            * */
            public suspend fun Routes(lineId: String, fixCoordinates: Boolean = true, direction: LineDirection = LineDirection.outbound): LineRoutes? {
                return LineService.GetLineRoutesForLine(lineId, fixCoordinates, direction);
            }
        }
    }

    public class Meta {
        companion object {

            public suspend fun GetLineModes(): List<LineMode?> {
                return MetaService.GetLineModes() ?: listOf()
            }

            public suspend fun GetLineIds(lineModes: List<LineMode>): List<String> {
                return MetaService.GetLineIdsForModes(lineModes) ?: listOf()
            }

            public suspend fun GetLineIds(lineMode: LineMode): List<String> {
                return MetaService.GetLineIdsForModes(listOf(lineMode)) ?: listOf()
            }

            public suspend fun GetDelayTypes(): List<DisruptionDelayType> {
                return MetaService.GetDelayTypes() ?: listOf()
            }

            public suspend fun GetLastLineRouteModifiedTime(): kotlinx.datetime.LocalDateTime? {
                return MetaService.GetLastModifiedRouteTime()
            }

            public suspend fun GetAccessibilityData(): List<StopPointAccessibility> {
                return MetaService.GetAccessibilityData() ?: listOf()
            }

            public suspend fun GetLastAccessibilityCacheTime(): kotlinx.datetime.LocalDateTime? {
                return MetaService.GetLastAccessibilityCacheTime()
            }
        }
    }

    public class Search {
        companion object {
            public suspend fun Search(name: String, filterBy: List<LineMode> = listOf(), includePOI: Boolean = false, includeAddresses: Boolean = false): List<GLPoint> {
                return SearchService.Search(name, filterBy, includePOI, includeAddresses) ?: listOf()
            }

            public suspend fun SearchAround(latitude: Double, longitude: Double, filterBy: List<LineMode> = listOf(), radius: Int = 90): List<GLPoint> {
                return SearchService.SearchAround(latitude, longitude, filterBy, radius) ?: listOf()
            }
        }
    }

    public class StopPoints {
        companion object {
            suspend fun Get(ids: List<String>): List<StopPoint> {
                return StopPointService.GetBy(ids) ?: listOf()
            }

            suspend fun GetArrivals(id: String): List<DepartureLineGroup> {
                return StopPointService.GetEstimatedArrivals(id) ?: listOf()
            }

            suspend fun GetTimetable(id: String, lineId: String, direction: String? = null): List<StopPointTimetable> {
                return StopPointService.GetTimetable(id, lineId, direction) ?: listOf()
            }
        }
    }

    public class Vehicles {
        companion object {
            suspend fun GetArrivals(vehicleId: String): List<Departure> {
                return VehicleService.GetVehicleArrivals(vehicleId) ?: listOf()
            }
        }
    }
}