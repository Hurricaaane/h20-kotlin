package h20kotlin.java

import h20kotlin.java.person.JPerson

public class KotlinGoldenSourceProcessor: IGoldenSourceProcessor {
    // FIXME: Handle null values
    override fun getAllPairsOfUniqueNameAndLevel(people: List<JPerson>): List<Pair<String, Int>> =
            people.map(::processPair).distinct()

    private fun processPair(it: JPerson) = it.town.name to it.town.townLevel.level
}