package art.qa.game.feature.question_answer.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import art.qa.game.core.common.EMPTY
import art.qa.game.core.domain.model.FlowState
import art.qa.game.feature.question_answer.presentation.QAViewModel

@Composable
fun QuestionAnswer(
    modifier: Modifier,
    viewModel: QAViewModel,
    onAnswerClick: (Boolean) -> Unit
) {
    val (selected, setSelected) = remember { mutableStateOf(EMPTY) }
    val (isCorrect, setIsCorrect) = remember { mutableStateOf<Boolean?>(null) }
    val result by viewModel.questionsModel.collectAsStateWithLifecycle()

    when (result) {
        is FlowState.Loading -> {
            Column(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        is FlowState.Error -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = (result as FlowState.Error).exception.message.toString())
            }
        }

        is FlowState.Success -> {
            (result as FlowState.Success).data?.let { questionModel ->
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .padding(start = 16.dp, end = 16.dp)
                        .fillMaxSize()
                ) {
                    item {
                        Spacer(modifier = modifier.height(16.dp))
                        Question(modifier, questionModel = questionModel)
                        Spacer(modifier = modifier.height(16.dp))
                    }
                    items(questionModel.answers) { answer ->
                        AnswerItem(modifier, answer, onAnswerClick, selected, setSelected, isCorrect, setIsCorrect)
                    }
                    item {
                        Spacer(modifier = modifier.height(16.dp))
                    }
                }
            }
        }
    }

}