package art.qa.game

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import art.qa.game.core.FragmentContainer
import art.qa.game.feature.question_answer.presentation.QAFragment
import art.qa.ui.theme.ArtQAGameTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtQAGameTheme {
                FragmentContainer(
                    modifier = Modifier.fillMaxSize(),
                    fragmentManager = supportFragmentManager,
                    commit = { add(it, QAFragment()) }
                )
            }
        }
    }
}