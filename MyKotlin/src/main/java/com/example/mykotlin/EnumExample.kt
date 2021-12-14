package com.example.mykotlin

import java.io.IOException
import java.lang.NullPointerException

fun main() {

    Repository.startFetch()
    getResult(Repository.getCurrentState())
    Repository.finishFetch()
    getResult(Repository.getCurrentState())
    Repository.error()
    getResult(Repository.getCurrentState())
    Repository.ioFailure()
    getResult(Repository.getCurrentState())
    Repository.nullPointerFailure()
    getResult(Repository.getCurrentState())
}

// Repository class, singleton!
// We don't want to make more than one instance..
object Repository {
    private var loadState: Result = NotLoading
    private var dataFetched: String? = null

    fun startFetch() {
        loadState = Loading
        dataFetched = "DATA"
    }

    fun finishFetch(){
        loadState = Success("Data fetched successfully")
        dataFetched = null
    }

    fun error() {
        loadState = Error(Exception("New Exception!"))
    }

    fun getCurrentState(): Result = loadState

    fun nullPointerFailure() {
        loadState = Failure.AnotherFailure(NullPointerException("Some null failure"))
    }

    fun ioFailure() {
        loadState = Failure.CustomFailure(IOException("Some IO failure"))
    }
}

//enum class Result {
//    SUCCESS,
//    FAILURE,
//    ERROR,
//    PENDING,
//    IDLE
//}

// Let us use abstract class instead
// to create sealed class, we use sealed instead of abstract
// a sealed class is still an abstract class!
// sealed classes can nest data classes, objects (singleton), etc.
sealed class Result

// Now success can emit the success string!
// Now we can actually emit messages!
data class Success(val dataFetched: String?): Result()
data class Error(val exception: Exception): Result()
object NotLoading: Result()
object Loading: Result()

sealed class Failure: Result() {
    data class CustomFailure(val ioException: IOException): Failure()
    data class AnotherFailure(val nullPointerException: NullPointerException): Failure()
}

fun getResult(result: Result) {
    return when(result) {
        is Error -> {
            println(result.exception.toString())
        }
        is Success -> {
            println(result.dataFetched ?: "Ensure you start fetch function first")
        }
        is Loading -> {
            println("Loading!")
        }
        is NotLoading -> {
            println("Not loading")
        }
        is Failure.CustomFailure -> {
            println(result.ioException.toString())
        }

        is Failure.AnotherFailure -> {
            println(result.nullPointerException.toString())
        }
        // To get rid of else, we used sealed classes.
    }
}