package standard

val fibonacci: Sequence<Long> = sequence {
    var first = 0L
    var second = 1L

    while (true) {
        yield(first)
        val temp = first
        first += second
        second = temp
    }
}

fun main() {
    println(fibonacci.take(10).toList())
}