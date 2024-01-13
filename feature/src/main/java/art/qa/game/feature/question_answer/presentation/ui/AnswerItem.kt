package art.qa.game.feature.question_answer.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import art.qa.game.feature.question_answer.domain.model.AnswerItemModel

@Composable
fun AnswerItem(
    modifier: Modifier,
    answerItemModel: AnswerItemModel,
    onAnswerClick: (Boolean) -> Unit,
    selected: String,
    setSelected: (String) -> Unit,
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 8.dp,
        modifier = modifier
            .clickable {
                onAnswerClick(answerItemModel.isCorrect)
                setSelected(answerItemModel.text)
            }
            .fillMaxSize()
    ) {
        Row {
            RadioButton(
                selected = selected == answerItemModel.text,
                onClick = {},
            )
            Text(
                text = answerItemModel.text,
                modifier = modifier.padding(all = 16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
    Spacer(modifier = modifier.height(16.dp))
}