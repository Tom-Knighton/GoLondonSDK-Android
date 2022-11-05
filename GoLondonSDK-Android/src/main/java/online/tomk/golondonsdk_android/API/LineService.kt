package online.tomk.golondonsdk_android.API

import online.tomk.golondonsdk_android.Models.*

internal class LineService {

    companion object {

        public suspend fun GetDisruptions(lineMode: LineMode): List<Disruption>? {
            return try {
                APIClient.perform("Line/Disruptions?lineMode=${lineMode}")
            } catch (error: Error) {
                null;
            }
        }

        public suspend fun GetLineInfoForIds(lineIds: List<String>, includeDetail: Boolean): List<Line>? {
            return try {
                APIClient.perform("Line/GetLineInfo/${lineIds.joinToString(",")}?includeDetail=${includeDetail}")
            } catch (error: Error) {
                null;
            }
        }

        public suspend fun GetLineInfoForModes(lineModes: List<LineMode>, includeDetail: Boolean): List<Line>? {
            return try {
                var queryString = "?"
                for (mode in lineModes) {
                    queryString += "lineModes=${mode}&"
                }
                queryString.removeSuffix("&")
                APIClient.perform("Line/GetLineInfoForModes${queryString}&includeDetail=${includeDetail}")
            } catch (error: Error) {
                null;
            }
        }

        public suspend fun GetGeneralStatusString(lineModes: List<LineMode>): LineModeGroupStatus? {
            return try {
                var queryString = "?"
                for (mode in lineModes) {
                    queryString += "lineModes=${mode}&"
                }
                queryString.removeSuffix("&")
                APIClient.perform("Line/StatusOverview${queryString}")
            } catch (error: Error) {
                null;
            }
        }

        public suspend fun GetLineRoutes(lineIds: List<String>, fixCoords: Boolean = true, direction: LineDirection = LineDirection.outbound): List<LineRoutes>? {
            return try {
                var queryString = "?"
                for (lineId in lineIds) {
                    queryString += "lineIdentifiers=${lineId}&"
                }
                queryString += "fixCoordinates=${fixCoords}&direction=${direction}"
                APIClient.perform("Line/Routes${queryString}")
            } catch (error: Error) {
                return null;
            }
        }

        public suspend fun GetLineRoutesForLine(lineId: String, fixCoords: Boolean, direction: LineDirection = LineDirection.outbound): LineRoutes? {
            return try {
                GetLineRoutes(listOf(lineId), fixCoords, direction)?.first();
            } catch (error: Error) {
                return null;
            }
        }
    }
}