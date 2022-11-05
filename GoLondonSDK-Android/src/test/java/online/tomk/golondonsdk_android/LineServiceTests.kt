package online.tomk.golondonsdk_android

import android.provider.Settings.Global
import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import online.tomk.golondonsdk_android.API.APIClient
import online.tomk.golondonsdk_android.Models.*
import online.tomk.golondonsdk_android.SDK.GLSDK
import org.junit.Assert
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class LineServiceTests {


    @Test
    fun getDisruptions_Success() = runTest {
        val results =  GLSDK.Lines.Disruptions(LineMode.values().asList())
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun getLineInfo_Success() = runTest {
        val results = GLSDK.Lines.Lines(listOf("elizabeth"))
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun getLineInfoByMode_Success() = runTest {
        val results = GLSDK.Lines.LinesByLineMode(LineMode.values().asList())
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun getGeneralStatus_NotUnknown() = runTest {
        val result = GLSDK.Lines.Status(LineMode.values().asList())
        Assert.assertNotEquals(LineModeGroupStatus.unk, result)
    }

    @Test
    fun getLineRoutes_Success() = runTest {
        val results = GLSDK.Lines.Routes(listOf("elizabeth"))
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun getLineRoutes_FixCoords_HasDifferentCoords() = runTest {
        val unfixed = GLSDK.Lines.Routes(listOf("elizabeth", "central"), fixCoordinates = false)
        val fixed = GLSDK.Lines.Routes(listOf("elizabeth", "central"))

        Assert.assertTrue(Json.encodeToString(unfixed) != Json.encodeToString(fixed))
    }

    @Test
    fun getLineRoutes_MapIsFilled() = runTest {
        val results = GLSDK.Lines.Routes("central")
        val firstCoord = results?.lineMapRoutes?.firstOrNull()?.firstOrNull()

        Assert.assertNotNull(firstCoord)
        Assert.assertNotEquals(0, firstCoord?.get(0))
        Assert.assertNotEquals(0, firstCoord?.get(1))
    }

    @Test
    fun getLineRoutes_DirectionIsValid() = runTest {
        val resultIn = GLSDK.Lines.Routes("central", direction = LineDirection.inbound)
        val resultOut = GLSDK.Lines.Routes("central", direction = LineDirection.outbound)

        Assert.assertNotNull(resultIn)
        Assert.assertNotNull(resultOut)
        Assert.assertNotEquals(resultIn?.stopPointSequences?.firstOrNull()?.stopPoint?.firstOrNull()?.id, resultOut?.stopPointSequences?.firstOrNull()?.stopPoint?.firstOrNull()?.id)
    }
}