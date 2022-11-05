package online.tomk.golondonsdk_android.API

import online.tomk.golondonsdk_android.Models.GLPoint
import online.tomk.golondonsdk_android.Models.LineMode

internal class SearchService {

    companion object {

        public suspend fun SearchAround(lat: Double, lon: Double, filterBy: List<LineMode> = listOf(), radius: Int = 900): List<GLPoint>? {
            try {
                var queryParams = "?radius=${radius}"
                for (lineMode in filterBy) {
                    queryParams += "&modesToFilterBy=${lineMode}"
                }

                val points: List<GLPoint>? = APIClient.perform("Search/Around/${lat}/${lon}${queryParams}")
                return points
            } catch (error: Error) {
                return null;
            }
        }

        public suspend fun Search(name: String, filterBy: List<LineMode> = listOf(), includePOI: Boolean = false, includeAddresses: Boolean = false): List<GLPoint>? {
            try {
                var queryParams = "?includePOI=${includePOI}&includeAddresses=${includeAddresses}"
                for (lineMode in filterBy) {
                    queryParams += "&modesToFilterBy=${lineMode}"
                }

                val points: List<GLPoint>? = APIClient.perform("Search/${name}${queryParams}")
                return points
            } catch (error: Error) {
                return null;
            }
        }
    }
}