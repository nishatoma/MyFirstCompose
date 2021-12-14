package com.example.mykotlin


fun main() {

    val car = Car("Black", "BMW")
    car.speed(100, 190)
    car.drive()
    println()

    // Truck
    val truck = Truck(color = "Magenta", model = "F16")
    truck.drive()
    truck.speed(100, 200)
}

class Truck(color: String, model:String): Car(color, model) {

    override fun speed(minSpeed: Int, maxSpeed: Int) {
        println("MIN TRUCK SPEED IS $minSpeed")
        println("MAX TRUCK SPEED IS $maxSpeed")
    }

    override fun drive() {
        super.drive()
        println("VROOOOM LIKE A TRUCK!")
    }
}

// All classes in Kotlin are closed by default.
// In order to inherit, we need to open the class.
open class Car(var color: String, var model: String) {

    // Initialize constructor values
//    init {
//        if (color.equals("green", ignoreCase = true)) {
//            println("green car!")
//        } else {
//            println("$color car!")
//        }
//    }

    // Make this function accessible to override
    open fun speed(minSpeed: Int, maxSpeed: Int) {
        println("Min Speed is $minSpeed")
        println("Max Speed is $maxSpeed")
    }

    open fun drive() {
        println("Driving a ${javaClass.simpleName}")
    }

    fun printCar() {
        println("[Car model] = $model")
        println("[Car color] = $color")
        println("Vehicle type: ${javaClass.simpleName}")
    }
}