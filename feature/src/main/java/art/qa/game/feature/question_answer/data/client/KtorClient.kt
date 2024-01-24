package art.qa.game.feature.question_answer.data.client

import art.qa.game.core.data.client.ktorClient
import art.qa.game.feature.question_answer.domain.model.QuestionsModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

suspend fun fetchQuestions(): QuestionsModel? {
    val response: HttpResponse = ktorClient.get("")
    if (response.status.value in 100..399) {
        return response.body<QuestionsModel>()
    }
    return null
}
