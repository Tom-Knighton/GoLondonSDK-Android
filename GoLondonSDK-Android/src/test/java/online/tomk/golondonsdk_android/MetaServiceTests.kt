package online.tomk.golondonsdk_android
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import online.tomk.golondonsdk_android.Models.LineMode
import online.tomk.golondonsdk_android.SDK.GLSDK
import org.junit.Assert
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MetaServiceTests {

    @Test
    fun getLineModes_Success() = runTest {
        val results = GLSDK.Meta.GetLineModes()
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun getLineIds_Success() = runTest {
        val results = GLSDK.Meta.GetLineIds(LineMode.elizabethLine)
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun getDelayTypes_Success() = runTest {
        val results = GLSDK.Meta.GetDelayTypes()
        Assert.assertTrue(results.isNotEmpty())
    }

    @Test
    fun getLastModifiedRoutes_Success() = runTest {
        val results = GLSDK.Meta.GetLastLineRouteModifiedTime()
        Assert.assertNotNull((results))
    }

    @Test
    fun getLastAccessibleData() = runTest {
        val data = GLSDK.Meta.GetAccessibilityData()
        Assert.assertTrue(data.isNotEmpty())
    }

    @Test
    fun getLastAccessibleCacheTime() = runTest {
        val time = GLSDK.Meta.GetLastAccessibilityCacheTime()
        Assert.assertNotNull(time)
    }
}