package art.qa.game.feature.question_answer.domain.model

data class QuestionModel(
    val id: Int,
    val image: Int,
    val title: String,
    val description: String? = null,
    val answers: AnswersModel
)