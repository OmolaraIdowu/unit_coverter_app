package com.swancodes.unitconverter

/**
 * Program that implements classes for different kinds of dwellings.
 * Shows how to:
 * Create class hierarchy, variables and functions with inheritance,
 * abstract class, overriding, and private vs. public variables.
 */
import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    // An instance of SquareCabin called squareCabin with residents
    val squareCabin = SquareCabin(6, 50.0)
    // An instance of RoundHut called roundHut with residents
    val roundHut = RoundHut(3, 10.0)
    // An instance of RoundTower called roundTower with residents
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        // All operations to do with instanceName
        println("\nSquare Cabin\n============")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Floor area:  ${floorArea()}")
    }

    with(roundHut) {
        // All operations to do with instanceName
        println("\nRound Hut\n============")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Floor area:  ${floorArea()}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Has room? ${hasRoom()}" )
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")

    }

    with(roundTower) {
        // All operations to do with instanceName
        println("\nRound Tower\n============")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Floor area:  ${floorArea()}")
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
    // For the area values, you could print the floor area using this: println("Floor area: %.2f".format(floorArea()))
}

/**
 * Defines properties common to all dwellings.
 * All dwellings have floorspace,
 * but its calculation is specific to the subclass.
 * Checking and getting a room are implemented here
 * because they are the same for all Dwelling subclasses.
 *
 * @param residents Current number of residents
 */
// A property
abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    /**
     *  Calculate the floor area of the dwelling.
     *  Implemented by subclasses where shape is determined.
     *
     *  @return floor area
     */
    abstract fun floorArea(): Double

    /**
     * Checks whether there is room for another resident.
     *
     * @return true if room available, false otherwise
     */
    fun hasRoom(): Boolean {
        return residents < capacity
    }

    /**
     * Compares the capacity to the number of residents and
     * If capacity is larger than number of residents,
     * add residents by increasing the number of residents.
     * Print the result.
     */
    fun getRoom() {
        if(capacity > residents) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }
}

/**
 * A square cabin dwelling.
 *
 * @param residents Current number of residents
 * @param length Length
 */
// Subclass SquareCabin to Dwelling
class SquareCabin(residents: Int, private val length: Double) : Dwelling(residents) {
    override val buildingMaterial = "Wood"
    override val capacity = 6

    /**
     * Calculates floor area for a square dwelling.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return length * length
    }
}

/**
 * Dwelling with a circular floorspace
 *
 * @param residents Current number of residents
 * @param radius Radius
 */
// Subclass RoundHut to Dwelling
open class RoundHut(residents: Int, private val radius: Double) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 4

    /**
     * Calculates floor area for round dwelling.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return PI * radius * radius
    }

    /**
     * Calculate the max length for a square carpet
     * that fits the circular floor.
     *
     * @return length of carpet
     */
    fun calculateMaxCarpetSize(): Double {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

/**
 * Round tower with multiple stories.
 *
 * @param residents Current number of residents
 * @param radius Radius
 * @param floors Number of stories
 */
// Subclass RoundTower to RoundHut
class RoundTower(residents: Int,  radius: Double, private val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"

    // Capacity depends on the number of floors.
    override val capacity = 4 * floors

    /**
     * Calculate the total floor area for a tower dwelling
     * with multiple stories.
     *
     * @return floor area
     */
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}