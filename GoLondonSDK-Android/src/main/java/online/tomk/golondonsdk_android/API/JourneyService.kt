package online.tomk.golondonsdk_android.API

import online.tomk.golondonsdk_android.Models.Journey
import online.tomk.golondonsdk_android.Models.JourneyDateType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

internal class JourneyService {

    companion object {

        suspend fun GetPossibleJourneys(from: String, to: String, via: String? = null, time: LocalDateTime? = null, timeType: JourneyDateType? = null): List<Journey>? {

            try {
                var queryParams: String = "?from=${from}&to=${to}${if (via.isNullOrEmpty()) "" else "&via=${via}"}"

                if (time != null) {
                    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                    val tType = if (timeType == null) JourneyDateType.departAt else if (timeType == JourneyDateType.departAt) "departAt" else "arriveAt"
                    queryParams += "&time=${time.format(formatter)}&timeType=${tType}"
                }

                return APIClient.perform("Journey${queryParams}")
            }
            catch(error: Error) {
                return null
            }
        }
    }
}