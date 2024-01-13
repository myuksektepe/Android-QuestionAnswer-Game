package art.qa.game.feature.question_answer.domain.model

data class AnswerItemModel(
    val id: Int,
    val text: String,
    val isCorrect: Boolean
)