package art.qa.game.feature.question_answer.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionModel(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String?,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String? = null,
    @SerialName("answers")
    val answers: List<AnswerItemModel>
)