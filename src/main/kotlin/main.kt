import standard.ClientException

// ClientException 확장 불가능
// data object ExtendsException: ClientException(code = -1)

fun handleClientException(exception: ClientException) {
    when (exception.also(::println)) {
        ClientException.ForbiddenException -> {

        }
        ClientException.NotFoundException -> {

        }
        ClientException.UnauthorizedException -> {

        }
    }
}
