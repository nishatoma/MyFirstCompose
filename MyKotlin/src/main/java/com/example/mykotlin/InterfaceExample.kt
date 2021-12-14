package com.example.mykotlin


fun main() {

    val button = Button("button")
    button.onClick("Hello!!!!")

    val superMario = Character("Super Mario")
    superMario.onClick("This is an actor!")

}


class Button(private val label: String) : ClickEvent {

    override fun onClick(message: String) {
        println("Clicked by $label and sent $message!")
    }
}

class Character(val name: String): ClickEvent {


    override fun onClick(message: String) {
        println("Clicked by $name and sent message: $message")
    }
}

// Interfaces
interface ClickEvent {
    fun onClick(message: String)
}
