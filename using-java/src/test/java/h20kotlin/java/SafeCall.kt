package h20kotlin.java

import h20kotlin.java.person.JPerson
import h20kotlin.java.person.JTown
import h20kotlin.java.person.KPerson
import h20kotlin.java.person.KTown


fun main(args: Array<String>) {
    val javaBogus = JPerson("D", JTown("Dville", "20120", null))
    val kotlinBogus = KPerson(
            name = "D",
            town = KTown(
                    name = "Dville",
                    postalCode = "20120",
                    townLevel = null
            )
    )
}