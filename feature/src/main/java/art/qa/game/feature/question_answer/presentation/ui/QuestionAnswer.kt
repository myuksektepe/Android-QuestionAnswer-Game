package art.qa.game.feature.question_answer.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import art.qa.game.core.domain.model.FlowState
import art.qa.game.feature.question_answer.presentation.QuestionAnswerViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun QuestionAnswer(
    modifier: Modifier,
    viewModel: QuestionAnswerViewModel = viewModel()
) {

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
                        .safeContentPadding(),
                ) {
                    item {
                        Spacer(modifier = modifier.height(16.dp))
                        Question(modifier, questionModel = questionModel)
                        Spacer(modifier = modifier.height(16.dp))
                    }
                    items(
                        key = { answer -> answer.id },
                        items = questionModel.answers
                    ) { answer ->
                        AnswerItem(
                            modifier = modifier,
                            answer = answer,
                            onAnswerClick = { answer ->
                                viewModel.selectedAnswer.value = answer
                                if (answer.isCorrect) {
                                    viewModel.viewModelScope.launch(Dispatchers.IO) {
                                        delay(1000)
                                        viewModel.clearSelectedAnswer()
                                        viewModel.getQuestion()
                                    }
                                }
                            },
                            selectedAnswer = viewModel.selectedAnswer.value,
                        )
                    }
                    item {
                        Spacer(modifier = modifier.height(16.dp))
                    }
                }
            }
        }
    }

}