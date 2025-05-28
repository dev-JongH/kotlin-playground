package standard

import kotlin.properties.Delegates

fun main() {
    // Delegates.notNull()
    var value: Int by Delegates.notNull()
    value = 0

    // lazy
    val holder = Holder()
    holder.expensiveMethod()

    // observable
    holder.state = "Initial"

    // vetoable
    holder.items = listOf(1, 2)
    // 적용 x
    holder.items.onEach { println(it) }
}

class Holder {
    // lazy
    private val ec by lazy { ExpensiveClass() }
    // observable
    var state by Delegates.observable("IDLE") { _, old, new ->
        println("state changed! $old -> $new")
    }
    // vetoable
    var items: List<Int> by Delegates.vetoable(listOf()) { _, _, new ->
        new.size > 2
    }

    fun expensiveMethod() {
        ec.method()
    }
}

class ExpensiveClass {
    init {
        println("expensive class initial !")
    }

    fun method() {
        println("method call")
    }
}