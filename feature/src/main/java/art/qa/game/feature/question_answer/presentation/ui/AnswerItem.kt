package art.qa.game.feature.question_answer.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.unit.dp
import art.qa.game.feature.question_answer.domain.model.AnswerItemModel
import art.qa.game.ui.theme.ColorPalate

@Composable
fun AnswerItem(
    modifier: Modifier,
    answerItemModel: AnswerItemModel,
    onAnswerClick: (Boolean) -> Unit,
    selected: String,
    setSelected: (String) -> Unit,
    isCorrect: Boolean?,
    setIsCorrect: (Boolean?) -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 8.dp,
        modifier = modifier
            .clickable {
                onAnswerClick(answerItemModel.isCorrect)
                setSelected(answerItemModel.text)
                setIsCorrect(answerItemModel.isCorrect)
            }
            .fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .background(
                    color = if (selected == answerItemModel.text) {
                        if (isCorrect == true) getCorrectAnswerBg() else getWrongAnswerBg()
                    } else Transparent,
                    shape = RoundedCornerShape(4.dp)
                )
        ) {
            RadioButton(
                selected = selected == answerItemModel.text,
                onClick = {},
                colors = RadioButtonDefaults.colors(
                    selectedColor = DarkGray
                )
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

@Composable
fun getCorrectAnswerBg() = if (isSystemInDarkTheme()) ColorPalate.Dark.CorrectAnswerBg else ColorPalate.Light.CorrectAnswerBg

@Composable
fun getWrongAnswerBg() = if (isSystemInDarkTheme()) ColorPalate.Dark.WrongAnswerBg else ColorPalate.Light.WrongAnswerBg