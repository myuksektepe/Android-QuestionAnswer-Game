package art.qa.game.feature.question_answer.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import art.qa.game.feature.question_answer.domain.model.QuestionModel

@Composable
fun Question(
    modifier: Modifier,
    questionModel: QuestionModel
) {
    Text(
        text = questionModel.title,
        modifier = modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.labelLarge,
    )
    questionModel.description?.let {
        Text(
            text = it,
            modifier = modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.labelSmall,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
    Card (
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = questionModel.image),
            contentDescription = questionModel.title
        )
    }
}