package patterns.creational.sigleton

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

object SingletonHttpClient {

    var response: String = ""
    private set

    init {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=612"))
            .build()
        val client = HttpClient.newHttpClient()
        response = client
            .send(request, HttpResponse.BodyHandlers.ofString()).body()
    }
}
