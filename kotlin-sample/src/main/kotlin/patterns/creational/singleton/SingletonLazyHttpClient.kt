package patterns.creational.singleton

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class SingletonLazyHttpClient {
    var response: String = ""
        private set

    companion object {
        val instance: SingletonLazyHttpClient by lazy {
            SingletonLazyHttpClient()
        }
    }

    fun request() {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=612"))
            .build()
        val client = HttpClient.newHttpClient()
        response = client
            .send(request, HttpResponse.BodyHandlers.ofString()).body()
        println("Response: $response")
    }
}