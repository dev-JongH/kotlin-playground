package coroutine

import kotlinx.coroutines.*

suspend fun main(): Unit = coroutineScope {
    val job = Job()
    launch(job) {
        repeat(5) {
            delay(200)
            println(it)
        }
    }

    launch {
        delay(500)
        job.completeExceptionally(Error("Unknown error"))
    }
    job.join()

    launch(job) {
        println("Will not printed")
    }

    println("Done")
}