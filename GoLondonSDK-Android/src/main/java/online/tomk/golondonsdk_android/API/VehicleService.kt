package online.tomk.golondonsdk_android.API

import online.tomk.golondonsdk_android.Models.Departure

internal class VehicleService {

    companion object {
        suspend fun GetVehicleArrivals(vehicleId: String): List<Departure>? {
            return try {
                APIClient.perform("Vehicle/${vehicleId}/Arrivals")
            } catch (error: Error) {
                return null;
            }
        }
    }
}