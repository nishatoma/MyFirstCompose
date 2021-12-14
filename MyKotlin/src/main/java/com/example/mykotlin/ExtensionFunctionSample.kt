package com.example.mykotlin

fun main() {

    println("Hello friend".whateverYouWantToCallThis(" how are you?"))

    val list = mutableListOf("Hello", "There")
    // prints [Hello, There]
    println(list.toString())
    // Swap elemnts 1 and 2
    list.swap(0, 1)
    // prints [There, Hello]
    println(list.toString())

    val name = "MayaM"
    // Prints MayaM
    println(name)
    // Prints 'aya'
    println(name.deleteFirstAndLast())
}


// Extension function
// Yes you can call the function whatever you want!
fun String.whateverYouWantToCallThis(toAppend: String): String = this.plus(toAppend)

// The way to do this is to add the receiver type as
// a prefix to the extension function name,
// for example, we want to add a method called "swap" to
// a mutable list that swaps two elements in the list...
fun MutableList<String>.swap(indexOne: Int, indexTwo: Int) {
    // 'this' refers to the MutableList we are working with
    val tmp = this[indexOne]
    this[indexOne] = this[indexTwo]
    this[indexTwo] = tmp
}

// delete first and last character!
fun String.deleteFirstAndLast() : String = this.substring(1, this.length - 1)
