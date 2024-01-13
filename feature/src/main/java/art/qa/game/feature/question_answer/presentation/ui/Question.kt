package art.qa.game.feature.question_answer.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import art.qa.game.FOUR
import art.qa.game.SPACE
import art.qa.game.THREE_DOT
import art.qa.game.core.ExpandableText
import art.qa.game.feature.question_answer.domain.model.QuestionModel

@Composable
fun Question(
    modifier: Modifier,
    questionModel: QuestionModel
) {
    Text(
        text = questionModel.title,
        modifier = modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.titleLarge,
    )
    questionModel.description?.let {
        val context = LocalContext.current
        ExpandableText(
            modifier = modifier.padding(bottom = 16.dp),
            text = it,
            style = MaterialTheme.typography.titleMedium,
            collapsedMaxLine = FOUR,
            showMoreText = "$THREE_DOT$SPACE${context.getString(art.qa.game.core.R.string.showMore)}",
            showLessText = "$SPACE${context.getString(art.qa.game.core.R.string.showLess)}",
        )
    }
    ElevatedCard(
        modifier = modifier
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        Image(
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = questionModel.image),
            contentDescription = questionModel.title
        )
    }
}