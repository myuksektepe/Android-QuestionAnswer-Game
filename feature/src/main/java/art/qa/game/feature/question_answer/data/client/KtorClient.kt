package art.qa.game.feature.question_answer.data.client

import art.qa.game.core.common.API_URL
import art.qa.game.feature.question_answer.domain.model.QuestionsModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json

suspend fun main() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
    val response: HttpResponse = client.get(API_URL)
    val questions: QuestionsModel = response.body()
    System.out.println(questions)
    client.close()
}
