package art.qa.game.feature.question_answer.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import art.qa.game.feature.question_answer.presentation.ui.QuestionAnswer

class QAActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<QAViewModel>()
            val questionModel = viewModel.question
            QuestionAnswer(
                modifier = Modifier,
                questionModel = questionModel,
                onAnswerClick = { isCorrect ->
                    if (isCorrect) {
                        Toast.makeText(this, "Answer is correct!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Naaah!", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}

/*
@Preview
@Composable
fun previewQA() {
    ComposeTryTheme {
        val viewModel = viewModel<QAViewModel>()
        val questionModel = viewModel.question
        QuestionAnswer(
            questionModel = questionModel,
            modifier = Modifier
        )
    }
}
 */