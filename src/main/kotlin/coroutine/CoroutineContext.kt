package coroutine

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

suspend fun main() {
    println("get---------------------")
    val context: CoroutineContext = CoroutineName("First coroutine")
    val name: CoroutineName? = context[CoroutineName]
    println(name)

    val job: Job? = context[Job]
    println(job)

    println("plus---------------------")
    val namedContext: CoroutineContext = CoroutineName("Named Context")
    println(namedContext[CoroutineName]?.name)
    println(namedContext[Job]?.isActive)

    val jobContext: CoroutineContext = Job()
    println(jobContext[CoroutineName]?.name)
    println(jobContext[Job]?.isActive)

    val bothContext = namedContext + jobContext
    println(bothContext[CoroutineName])
    println(bothContext[Job])

    // fold
    bothContext.fold("") { acc, element -> "$acc$element"}.also(::println)

    coroutineScope {
        launch(CoroutineName("main")) {
            log("in launch")
        }
    }
}

fun CoroutineScope.log(msg: String) {
    println("[${coroutineContext[CoroutineName]?.name}] $msg")
}