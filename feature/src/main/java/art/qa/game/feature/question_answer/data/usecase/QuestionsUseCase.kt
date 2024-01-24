package art.qa.game.feature.question_answer.data.usecase

import art.qa.game.core.data.client.ktorClient
import art.qa.game.core.domain.model.FlowState
import art.qa.game.feature.question_answer.domain.model.QuestionModel
import art.qa.game.feature.question_answer.domain.model.QuestionsModel
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow


const val QA_PATH = "qa.json"

suspend fun fetchQuestions(): Flow<FlowState<QuestionsModel?>> = flow {
    // Loading
    emit(FlowState.Loading)

    val response: HttpResponse = ktorClient.get(QA_PATH)
    // Success
    if (response.status.value in 100..399) {
        emit(FlowState.Success(response.body<QuestionsModel>()))
    }

    // Error
    else {
        emit(FlowState.Error(response.body<Exception>()))
    }
}.catch {
    emit(FlowState.Error(java.lang.Exception(it)))
}


suspend fun getRandomQuestion(): Flow<FlowState<QuestionModel?>> = channelFlow {
    fetchQuestions().collectLatest {
        when (it) {
            is FlowState.Loading -> {
                send(FlowState.Loading)
            }

            is FlowState.Error -> {
                send(FlowState.Error(it.exception))
            }

            is FlowState.Success -> {
                send(FlowState.Success(it.data?.questions?.random()))
            }
        }
    }
}