package art.qa.game.core.data.client

import art.qa.game.core.common.API_URL
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json

val ktorClient = HttpClient(CIO) {
    defaultRequest {
        header("X-Custom-Header", "Hello")
        url(API_URL)
    }
    install(ContentNegotiation) {
        json()
    }
}