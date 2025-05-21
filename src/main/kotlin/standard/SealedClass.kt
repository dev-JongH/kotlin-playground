package standard

// standard package 외부에서 하단 interface/class에 대한 확장이 불가능하다.
// 때문에 패키지 내 정의된 sealed interface/class 외 상속 구조는 추가되지 않는다.
// sealed class로 설계된 계층 구조를 통해 보다 안정적인 동작을 보장할 수 있다.
sealed interface HttpException

sealed class ClientException(val code: Int): HttpException {
    data object UnauthorizedException: ClientException(code = 401)

    data object ForbiddenException: ClientException(code = 403)

    data object NotFoundException: ClientException(code = 404)
}