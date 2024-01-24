package art.qa.game.feature.question_answer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import art.qa.game.core.ui.theme.ArtQAGameTheme
import art.qa.game.feature.question_answer.presentation.ui.QuestionAnswer

class QAFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val qaViewModel = viewModel<QAViewModel>()

                ArtQAGameTheme {
                    QuestionAnswer(
                        modifier = Modifier.fillMaxSize(),
                        viewModel = qaViewModel,
                        onAnswerClick = { isCorrect ->
                            if (isCorrect) {
                                qaViewModel.getQuestion()
                                Toast.makeText(requireContext(), "Answer is correct!", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(requireContext(), "Naaah!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
            }
        }

    }
}