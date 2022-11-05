package online.tomk.golondonsdk_android

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import online.tomk.golondonsdk_android.Models.LineMode
import online.tomk.golondonsdk_android.Models.StopPoint
import online.tomk.golondonsdk_android.SDK.GLSDK
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchServiceTests {

    @Test
    fun searchAround_Success() = runTest {
        val results = GLSDK.Search.SearchAround(51.582, 0.2063)
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun search_Success() = runTest {
        val results = GLSDK.Search.Search("Gidea Park", listOf(), true, true)
        val results2 = GLSDK.Search.Search("Stratford", listOf(), true, true)
        val results3 = GLSDK.Search.Search("This is unknown :)", listOf())

        Assert.assertTrue(results.isNotEmpty())
        Assert.assertTrue(results2.isNotEmpty())

        Assert.assertNotNull(results3)
        Assert.assertTrue(results3.isEmpty())

        val modes: MutableList<LineMode> = mutableListOf()
        val combResults = results + results2

        combResults.forEach {
            if (it is StopPoint) {
                modes += (it.lineModes ?: listOf())
            }
        }

        Assert.assertNotEquals(modes.count { it != LineMode.unknown }, modes.count())
    }
}