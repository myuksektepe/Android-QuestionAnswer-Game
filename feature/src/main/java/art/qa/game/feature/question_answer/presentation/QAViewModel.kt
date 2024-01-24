package art.qa.game.feature.question_answer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import art.qa.game.core.domain.model.FlowState
import art.qa.game.feature.question_answer.data.usecase.getRandomQuestion
import art.qa.game.feature.question_answer.domain.model.QuestionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class QAViewModel : ViewModel() {

    init {
        getQuestion()
    }

    private val questionModelMSF: MutableStateFlow<FlowState<QuestionModel?>> = MutableStateFlow(FlowState.Loading)
    val questionsModel: StateFlow<FlowState<QuestionModel?>> get() = questionModelMSF

    fun getQuestion() {
        viewModelScope.launch(Dispatchers.IO) {
            getRandomQuestion().collectLatest {
                questionModelMSF.value = it
            }
        }
    }
}