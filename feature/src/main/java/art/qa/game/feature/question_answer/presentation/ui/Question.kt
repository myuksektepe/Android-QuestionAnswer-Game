package art.qa.game.feature.question_answer.presentation.ui

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import art.qa.game.core.R
import art.qa.game.core.common.FOUR
import art.qa.game.core.common.SPACE
import art.qa.game.core.common.THREE_DOT
import art.qa.game.core.common.custom_ui_items.ExpandableText
import art.qa.game.feature.question_answer.domain.model.QuestionModel
import coil.compose.AsyncImage

@Composable
fun Question(
    modifier: Modifier,
    questionModel: QuestionModel
) {
    Text(
        text = questionModel.title,
        modifier = modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center
    )
    questionModel.description?.let {
        val context = LocalContext.current
        ExpandableText(
            modifier = modifier.padding(bottom = 16.dp),
            text = it,
            style = MaterialTheme.typography.titleMedium,
            collapsedMaxLine = FOUR,
            showMoreText = "$THREE_DOT$SPACE${context.getString(R.string.showMore)}",
            showLessText = "$SPACE${context.getString(R.string.showLess)}",
        )
    }
    ElevatedCard(
        modifier = modifier
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
    ) {
        AsyncImage(
            model = questionModel.image,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            contentDescription = questionModel.title
        )
    }
}