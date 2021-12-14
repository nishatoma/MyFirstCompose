package com.example.mykotlin

fun main() {

    val people = createListOfPeople()

    people.forEach { person ->
        println("First Name: ${person.firstName}," +
                " Last Name: ${person.lastName}, " +
                "Age: ${person.age}")
    }
}

data class Person(val firstName: String, val lastName: String, val age: Int)

fun createListOfPeople(): MutableList<Person> {
    val people = mutableListOf<Person>()
    for (i in 1..10) {
        people.add(Person("firstName$i", "lastName$i", i))
    }
    return people
}