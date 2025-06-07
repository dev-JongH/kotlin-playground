package coroutine

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        try {
            repeat(1000) {
                delay(200)
                println(it)
            }
        } catch (e: CancellationException) {
            println(e)
            throw e
        }
    }
    delay(1100)
    job.cancelAndJoin()
    println("Cancelled successfully")
    delay(1000)
}