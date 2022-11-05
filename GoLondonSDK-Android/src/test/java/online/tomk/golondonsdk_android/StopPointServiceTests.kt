package online.tomk.golondonsdk_android

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import online.tomk.golondonsdk_android.SDK.GLSDK
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class StopPointServiceTests {

    @Test
    fun getByIds_Success() = runTest {
        val result = GLSDK.StopPoints.Get(listOf("910GGIDEAPK", "HUBLST"))

        Assert.assertNotNull(result)
        Assert.assertEquals(2, result.count())
        Assert.assertNotNull(result.first().lineModeGroups?.first()?.modeName)
        result.first().quietTimeData?.containsDaily?.let { Assert.assertFalse(it) }
        result.last().quietTimeData?.dailyCrowding?.let { Assert.assertTrue(it.isNotEmpty()) }
    }

    @Test
    fun getArrivals_Success() = runTest {

        val result = GLSDK.StopPoints.GetArrivals("HUBLST")
        Assert.assertNotNull(result)
        Assert.assertTrue(result.isNotEmpty())

        val firstDep = result.first().platformGroups?.first()?.departures?.first()
        Assert.assertTrue(((firstDep?.scheduledArrival) != null) || ((firstDep?.scheduledDeparture) != null) || ((firstDep?.estimatedArrival) != null) || ((firstDep?.estimatedDeparture) != null))
    }

    @Test
    fun getTimetable_Success() = runTest {
        val result = GLSDK.StopPoints.GetTimetable("940GZZLUSTD", "jubilee")

        Assert.assertNotNull(result)
        Assert.assertEquals(2, result.count())
        Assert.assertNotNull(result.first().schedules)
        Assert.assertTrue(result.first().schedules.isNotEmpty())
    }
}