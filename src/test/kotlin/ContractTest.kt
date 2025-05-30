import kotlinx.coroutines.*
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import standard.measureCoroutineDuration

internal class ContractTest {

    @Test
    fun `measure coroutine duration`() = runTest {
        val result: String
        // measureCoroutineDuration 내부에 contract를 정의함으로써
        // compiler에게 measureCoroutineDuration이 호출되는 것을 보장하여
        // value 키워드로 선언된 result에 초기 값을 할당하는 코드에 compile error가 발생하지 않는다.
        measureCoroutineDuration {
            delay(1000)
            result = "OK"
        }.also(::println)
        println(result)
    }

}