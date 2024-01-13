package art.qa.game.feature.question_answer.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionsModel(
    @SerialName("questions")
    val questions: List<QuestionModel>
)