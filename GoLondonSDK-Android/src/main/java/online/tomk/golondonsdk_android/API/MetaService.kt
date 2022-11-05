package online.tomk.golondonsdk_android.API

import kotlinx.datetime.LocalDateTime
import online.tomk.golondonsdk_android.Models.DisruptionDelayType
import online.tomk.golondonsdk_android.Models.LineMode
import online.tomk.golondonsdk_android.Models.StopPointAccessibility

internal class MetaService {

    companion object {

        suspend fun GetLineModes(): List<LineMode?>? {
            return try {
                APIClient.perform("Meta/LineModes")
            } catch (error: Error) {
                null
            }
        }

        suspend fun GetLineIdsForModes(lineModes: List<LineMode>): List<String>? {
            try {
                if (lineModes.isEmpty()) {
                    return null;
                }

                var query = "?modes=${lineModes.first()}"
                for (mode in lineModes.drop(1)) {
                    query += "&modes=${mode}"
                }

                return APIClient.perform("Meta/LineIds${query}")
            } catch(error: Error) {
                return null;
            }
        }

        suspend fun GetDelayTypes(): List<DisruptionDelayType>? {
            return try {
                APIClient.perform("Meta/DelayTypes")
            } catch (error: Error) {
                null
            }
        }

        suspend fun GetLastModifiedRouteTime(): LocalDateTime? {
            return try {
                APIClient.perform("Meta/LastCachedRoutesTime")
            } catch (error: Error) {
                null;
            }
        }

        suspend fun GetAccessibilityData(): List<StopPointAccessibility>? {
            return try {
                APIClient.perform("Meta/GetAccessibility")
            } catch (error: Error) {
                null;
            }
        }

        suspend fun GetLastAccessibilityCacheTime(): LocalDateTime? {
            return try {
                APIClient.perform("Meta/LastCachedAccessibilityTime")
            } catch (error: Error) {
                null
            }
        }
    }
}