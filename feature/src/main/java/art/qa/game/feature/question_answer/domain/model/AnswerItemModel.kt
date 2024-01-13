package art.qa.game.feature.question_answer.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnswerItemModel(
    @SerialName("id")
    val id: Int,
    @SerialName("text")
    val text: String,
    @SerialName("isCorrect")
    val isCorrect: Boolean
)