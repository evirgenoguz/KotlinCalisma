package com.evirgenoguz.kotlinclassinheritance

import kotlin.math.PI
import kotlin.math.sqrt


fun main(){

    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Capacity: ${capacity}")
        println("Material: ${buildingMaterial}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }

    with(roundHut){
        println("\nRound Hut\n==============")
        println("Material : ${buildingMaterial}")
        println("Capacity : ${capacity}")
        println("Has Room : ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }

}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean{
        return residents < capacity
    }

    abstract fun floorArea(): Double

    fun getRoom(): Boolean{
        if (capacity > residents){
            residents++
            println("You got room!")
            return true
        }
        else{
            println("Sorry, at capacity and no rooms left.")
            return false
        }
    }
}

class SquareCabin(residents: Int, val length: Double): Dwelling(residents){
    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }


}

open class RoundHut(residents: Int, val radius: Double): Dwelling(residents){
    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt((diameter * diameter) / 2)
    }

}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2): RoundHut(residents, radius){
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }

}