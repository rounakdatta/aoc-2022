import kotlin.math.max

fun main() {
    fun part1(input: List<String>): Int {
        return input.fold(Pair(0, 0)) { (currentSum, maxSum), it ->
            if (it != "") {
                Pair(currentSum + it.toInt(), max(maxSum, currentSum + it.toInt()))
            } else {
                Pair(0, maxSum)
            }
        }
            .second
    }

    fun part2(input: List<String>): Int {
        return input.toMutableList().apply { this.add("") }
            .fold(Pair(0, mutableListOf(0))) { (currentSum, listOfSums), it ->
                if (it != "") {
                    Pair(currentSum + it.toInt(), listOfSums)
                } else {
                    Pair(0, listOfSums.apply { this.add(currentSum) })
                }
            }
            .second.sorted()
            .takeLast(3)
            .sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
