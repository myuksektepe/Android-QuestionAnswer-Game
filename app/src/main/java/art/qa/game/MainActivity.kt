package art.qa.game

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import art.qa.game.core.common.custom_ui_items.FragmentContainer
import art.qa.game.feature.question_answer.presentation.QAFragment
import art.qa.game.core.ui.theme.ArtQAGameTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtQAGameTheme {
                FragmentContainer(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    fragmentManager = supportFragmentManager,
                    commit = { add(it, QAFragment()) }
                )
            }
        }
    }
}