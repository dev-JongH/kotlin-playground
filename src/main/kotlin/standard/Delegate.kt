package standard

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class PropertyDelegator<T>(private var value: T) {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): T {
        println("value getter")
        return value
    }

    operator fun setValue(
        thisRef: Any?,
        prop: KProperty<*>,
        value: T,
    ) {
        println("value setter")
        this.value = value
    }
}

class DelegatorProvider<T>(private var value: T) {
    operator fun provideDelegate(
        thisRef: Any?,
        property: KProperty<*>
    ): PropertyDelegator<T> = PropertyDelegator(value)
}

abstract class PreferenceHolder {
    operator fun Boolean.provideDelegate(thisRef: Any?, property: KProperty<*>) = bind(this)

    inline fun <reified T: Any> bind(default: T): ReadWriteProperty<PreferenceHolder, T> = TODO()
}

object Preference: PreferenceHolder() {
    var showLoadingDialog by bind(this)
}

fun main() {
    var delegated: Int by DelegatorProvider(0)
    println("$delegated")
    delegated = 1
}