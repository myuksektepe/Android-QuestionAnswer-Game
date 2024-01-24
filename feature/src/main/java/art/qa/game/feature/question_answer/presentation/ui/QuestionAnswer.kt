package art.qa.game.feature.question_answer.presentation.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import art.qa.game.feature.question_answer.domain.model.QuestionModel

@Composable
fun QuestionAnswer(
    modifier: Modifier,
    questionModel: QuestionModel?,
    onAnswerClick: (Boolean) -> Unit
) {
    val (selected, setSelected) = remember { mutableStateOf("") }
    val (isCorrect, setIsCorrect) = remember { mutableStateOf<Boolean?>(null) }
    questionModel?.let {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            item {
                Spacer(modifier = modifier.height(16.dp))
                Question(modifier, questionModel = it)
                Spacer(modifier = modifier.height(16.dp))
            }
            items(it.answers) { answer ->
                AnswerItem(modifier, answer, onAnswerClick, selected, setSelected, isCorrect, setIsCorrect)
            }
            item {
                Spacer(modifier = modifier.height(16.dp))
            }
        }
    }
}