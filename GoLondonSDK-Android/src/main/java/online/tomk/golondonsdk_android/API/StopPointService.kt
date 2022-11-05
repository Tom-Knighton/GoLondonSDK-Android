package online.tomk.golondonsdk_android.API

import online.tomk.golondonsdk_android.Models.Departure
import online.tomk.golondonsdk_android.Models.DepartureLineGroup
import online.tomk.golondonsdk_android.Models.StopPoint
import online.tomk.golondonsdk_android.Models.StopPointTimetable

internal class StopPointService {

    companion object {

        suspend fun GetBy(ids: List<String>): List<StopPoint>? {
            if (ids.isEmpty()) {
                return null
            }

            return try {
                APIClient.perform("StopPoint/${ids.joinToString(",")}")
            } catch (error: Error) {
                return null;
            }
        }

        suspend fun GetEstimatedArrivals(id: String): List<DepartureLineGroup>? {
            return try {
                APIClient.perform("StopPoint/EstimatedArrivals/${id}")
            } catch (error: Error) {
                return null;
            }
        }

        suspend fun GetTimetable(stopPointId: String, lineId: String, direction: String? = null): List<StopPointTimetable>? {
            return try {
                var url ="StopPoint/${stopPointId}/timetable/${lineId}"
                if (!direction.isNullOrEmpty()) {
                    url += "?direction=${direction}"
                }
                APIClient.perform(url)
            } catch (error: Error) {
                return null;
            }
        }
    }
}