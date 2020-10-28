package advanced

import com.google.gson.JsonParser
import java.net.URI
import java.net.URL
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration
import javax.imageio.ImageIO

fun main() {
    while (true) {
        val catUrl = getCatUrl()
        val image = ImageIO.read(URL(catUrl))
        println("cat!")
    }
}

private fun getCatUrl(): String {
    val theCatApiKey = "3d6d569d-9153-43cc-af23-86c161f0edad"
    val client = HttpClient.newHttpClient()
    val requestJson = HttpRequest.newBuilder()
            .uri(URI.create("https://api.thecatapi.com/v1/images/search?api_key=$theCatApiKey"))
            .timeout(Duration.ofSeconds(10))
            .build()
    val response = client.send(
            requestJson,
            HttpResponse.BodyHandlers.ofString()
    )
    val catInfo = JsonParser().parse(response.body()).asJsonArray[0].asJsonObject
    return catInfo["url"].asString
}