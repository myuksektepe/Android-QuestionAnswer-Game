package art.qa.game.feature.question_answer.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import art.qa.game.feature.R
import art.qa.game.feature.question_answer.domain.model.AnswerItemModel
import art.qa.game.feature.question_answer.domain.model.AnswersModel
import art.qa.game.feature.question_answer.domain.model.QuestionModel

class QAViewModel : ViewModel() {

    var question by mutableStateOf(
        QuestionModel(
            id = 1,
            image = R.drawable.the_carpet_marchant_ettore_simonetti,
            title = "The Carpet Merchant",
            description = "His father, Francesco, was a goldsmith and carver. His mother, Carolina, née Raffaelli, came from a family of mosaic artists, with a workshop in Rome. One of his ancestors, Giacomo Raffaelli, helped to develop the modern micromosaic technique. In 1869, he attended a course on geometry at the Accademia di San Luca, and was awarded a prize for perspective.",
            answers = AnswersModel(
                listOf(
                    AnswerItemModel(
                        id = 1,
                        text = "Ettore Simonetti",
                        isCorrect = true
                    ),
                    AnswerItemModel(
                        id = 2,
                        text = "Raffaello Sanzio",
                        isCorrect = false
                    ),
                    AnswerItemModel(
                        id = 3,
                        text = "Harrison Fisher",
                        isCorrect = false
                    ),
                ).shuffled()
            )
        )
    )
        private set
}