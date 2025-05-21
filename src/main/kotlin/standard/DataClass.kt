package standard

data class Person(val name: String, val age: String) {
    val thirdWeight = 500
}

fun main() {
    // destructuring declaration
    // primary constructor 내 미포함 property는 component 함수를 생성할 수 없기 때문에
    // destructuring declaration으로 변수를 생성할 수 없다.
    val (name, age) = getMyInfo()

    println("$name $age")
}

fun getMyInfo() = Person(name = "JongHyeon", age = "30")