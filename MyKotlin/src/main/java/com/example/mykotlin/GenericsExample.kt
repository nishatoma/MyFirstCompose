package com.example.mykotlin

fun main() {

    val list = mutableListOf("Hello", "there")
    val finder = Finder(list)
    finder.findItem("Hello") {
        println("$it")
    }
}


// This only works for list of strings,
// we need to make this a generic
// By adding the T keyword!
class Finder<T>(private val list: List<T>) {

    fun findItem(element: T, foundItem: (element: T?) -> Unit) {
        val itemFoundList = list.filter {
            it == element
        }

        if (itemFoundList.isNullOrEmpty()) {
            foundItem(null)
        } else {
            foundItem(itemFoundList.first())
        }
    }
}