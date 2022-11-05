package online.tomk.golondonsdk_android

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import online.tomk.golondonsdk_android.SDK.GLSDK
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class VehicleServiceteests {

    @Test
    fun getArrivalsFirstAtLST_Success() = runTest {
        val firstAtLST = GLSDK.StopPoints.GetArrivals("HUBLST")
        val vehId = firstAtLST.firstOrNull { it.lineId == "central" }?.platformGroups?.firstOrNull()?.departures?.firstOrNull { it.lineId == "central"}?.vehicleId ?: "no vehicle id"

        val result = GLSDK.Vehicles.GetArrivals(vehId)
        Assert.assertTrue(result.isNotEmpty())
    }
}