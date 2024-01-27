package art.qa.game.feature.question_answer.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
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
                ArtQAGameTheme {
                    QuestionAnswer(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }

    }
}