package online.tomk.golondonsdk_android

import android.provider.Settings.Global
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalDateTime
import online.tomk.golondonsdk_android.Models.JourneyDateType
import online.tomk.golondonsdk_android.SDK.GLSDK
import org.junit.Assert
import org.junit.Test
import java.time.ZoneId
import java.util.Calendar
import java.util.Date


@OptIn(ExperimentalCoroutinesApi::class)
class JourneyTests {

    @Test
    fun testJourney() = runTest {
        val c: Calendar = Calendar.getInstance()
        c.time = Date()
        c.add(Calendar.HOUR, 1)
        c.add(Calendar.MINUTE, 30)
        val startDate = c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
        val results = GLSDK.Journeys.MakeJourney("910GGIDEAPK", "910GROMFORD", null, startDate, JourneyDateType.arriveAt)
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun testJourneyVia() = runTest {
        val results = GLSDK.Journeys.MakeJourney("910GGIDEAPK", "HUBLST", "910GROMFORD")
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun testJourneyCoords() = runTest {
        val results = GLSDK.Journeys.MakeJourney(Pair(51.582f, 0.2063f), Pair(51.5188f, 0.0814f))
        Assert.assertTrue(results.isNotEmpty())
    }
}