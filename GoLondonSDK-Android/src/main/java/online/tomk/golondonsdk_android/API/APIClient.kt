package online.tomk.golondonsdk_android.API
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import online.tomk.golondonsdk_android.Models.StopPoint
import ru.gildor.coroutines.okhttp.await
import java.util.concurrent.TimeUnit

internal class APIClient {

    companion object {
        private val BASEURL: String = "https://api.golondon.tomk.online/api/";

        private var client: OkHttpClient = OkHttpClient().newBuilder().readTimeout(60, TimeUnit.SECONDS).build()

        suspend fun performNoDecoding(url: String): String? {
            var result: String? = null;

            try {
                val url = URL(BASEURL + url)
                val request = Request.Builder().url(url).build()

                System.out.println(url)

                val response = client.newCall(request).await()
                result = response.body()?.string()
            }
            catch (err: Error) {
                println("Error executing request")
            }

            return result;
        }

        @OptIn(ExperimentalSerializationApi::class)
        val json = Json { ignoreUnknownKeys = true; explicitNulls = false; }

        public suspend inline fun <reified T> perform(url: String): T? {
            val result = performNoDecoding(url);

            if (result != null) {
                return json.decodeFromString<T>(result);
            }

            return null;
        }
    }
}