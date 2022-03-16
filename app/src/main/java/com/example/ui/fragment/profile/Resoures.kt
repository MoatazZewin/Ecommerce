package com.example.ui.fragment.profile

sealed class Either<S, E> {

    data class Success<S, E>(val data: S) : Either<S, E>()
    data class Error<S, E>(val errorCode: E, val message: String? = null) : Either<S, E>()

}

enum class RepoErrors {
    NoInternetConnection,
    ServerError
}


enum class LoginErrors {
    NoInternetConnection,
    ServerError,
    UserNotFound,
    IncorrectPassword,
    ConnectionFiled
}