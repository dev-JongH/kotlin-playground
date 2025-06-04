package coroutine

import kotlinx.coroutines.*

fun main() = runBlocking {
    val a = CoroutineScope(Dispatchers.Default).async {
        delay(1000)
        10
    }

    val b = CoroutineScope(Dispatchers.Default).async {
        delay(3000)
        20
    }

    val c = CoroutineScope(Dispatchers.Default).async {
        delay(2000)
        30
    }

    println(a.await())
    println(b.await())
    println(c.await())
}