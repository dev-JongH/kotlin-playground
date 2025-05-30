package standard

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.TimedValue


fun printEach(input: List<String>?) {
    input?.onEach { println(it) }
    if (!input.isNullOrEmpty()) {
        // input as List<String> smart casting!
        input.onEach { println(it) }
    }
}

sealed class UiState {
    data object Loading: UiState() {
        var progress: Double = 0.0
    }
    data object Success: UiState()

    data object Failure: UiState()
}

@OptIn(ExperimentalContracts::class)
fun UiState.isLoading(): Boolean {
    contract {
        returns(true) implies (this@isLoading is UiState.Loading)
    }
    return this is UiState.Loading && this.progress > 0.0
}

@OptIn(ExperimentalContracts::class)
suspend fun measureCoroutineDuration(
    block: suspend () -> Unit
): Duration {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return measureTimeMillis { block() }.milliseconds
}