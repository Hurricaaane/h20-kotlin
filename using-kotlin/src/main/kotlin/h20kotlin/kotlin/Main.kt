package h20kotlin.kotlin

fun main(args: Array<String>) {
    val result = team("edms") {
        "JB" loves "Christopher"
        "JB" loves "Seb"
    }

    println(result)
}

fun team(name: String, initFn: Team.() -> Unit) = Team(name).apply(initFn)

class Team(
        val name: String,
        var members: MutableSet<String> = mutableSetOf(),
        var relationships: MutableList<Relationship> = mutableListOf()
) {
    infix fun String.loves(other: String) = Relationship(this, other).apply {
        relationships.add(this)
        members.add(this.source)
        this.target?.let(members::add)
    }

    override fun toString(): String {
        return (listOf("In $name made of ${members.sorted()}:") +
                relationships.map { "- $it" }
                ).joinToString("\n")
    }
}

data class Relationship(val source: String, val target: String?) {
    override fun toString(): String = target?.let { "$source loves $target" } ?: "$source is alone"
}