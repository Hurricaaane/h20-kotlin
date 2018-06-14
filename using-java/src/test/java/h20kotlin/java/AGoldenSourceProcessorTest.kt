package h20kotlin.java

import com.google.gson.GsonBuilder
import h20kotlin.java.person.JPerson
import h20kotlin.java.person.JTown
import h20kotlin.java.person.JTownLevel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

abstract class AGoldenSourceProcessorTest(val SUT: IGoldenSourceProcessor) {
    @Test
    public fun `it should process an ideal dataset`() {
        // Setup
        val idealDatabaseContents = listOf(
                JPerson("A", JTown("Aville", "12345", JTownLevel(1))),
                JPerson("B", JTown("Aville", "12345", JTownLevel(2))),
                JPerson("C", JTown("Cville", "19999", JTownLevel(9))),
                JPerson("D", JTown("Dville", "20120", JTownLevel(9))),
                JPerson("E", JTown("Aville", "12345", JTownLevel(1)))
        )

        // Demo example
        println(GsonBuilder().setPrettyPrinting().create().toJson(idealDatabaseContents))

        // Exercise
        val result = SUT.getAllPairsOfUniqueNameAndLevel(idealDatabaseContents)

        // Verify
        assertThat(result).containsExactlyInAnyOrder(
                "Aville" to 1,
                "Aville" to 2,
                "Cville" to 9,
                "Dville" to 9
        )
    }

    @Test
    public fun `it should process a real world dataset`() {
        // Setup
        val realDatabaseContents = listOf(
                JPerson("A", JTown("Aville", "12345", JTownLevel(1))),
                JPerson("B", null),
                JPerson("C", JTown("Cville", "19999", null)),
                JPerson("D", JTown("Dville", "20120", JTownLevel(null))),
                JPerson("E", JTown(null, "12345", JTownLevel(1)))
        )

        // Demo example
        println(GsonBuilder().setPrettyPrinting().create().toJson(realDatabaseContents))

        // Exercise
        val result = SUT.getAllPairsOfUniqueNameAndLevel(realDatabaseContents)

        // Verify
        assertThat(result).containsExactlyInAnyOrder(
                "Aville" to 1
        )
    }

    @Test
    @Disabled
    public fun `it should throw an exception if the dataset has invalid values`() {
        // Setup
        val realDatabaseContents = listOf(
                JPerson("A", JTown("Aville", "12345", JTownLevel(1))),
                JPerson("B", null),
                JPerson("C", JTown("Cville", "19999", null)),
                JPerson("D", JTown("Dville", "20120", JTownLevel(null))),
                JPerson("E", JTown(null, "12345", JTownLevel(1)))
        )

        // Demo example
        println(GsonBuilder().setPrettyPrinting().create().toJson(realDatabaseContents))

        // Exercise
        assertFailsWith<IllegalArgumentException> {
            SUT.getAllPairsOfUniqueNameAndLevel(realDatabaseContents)
        }
    }
}