package art.qa.game.core.domain.model

sealed class FlowState<out T> {
    object Loading : FlowState<Nothing>()
    data class Error(val exception: Exception) : FlowState<Nothing>()
    data class Success<out T>(val data: T) : FlowState<T>()
}