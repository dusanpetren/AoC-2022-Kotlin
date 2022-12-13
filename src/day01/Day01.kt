package day01

import println
import readInput

fun main() {
    fun getMostCalories(elves: List<Elf>): Int {
        return elves.sortedByDescending(Elf::calorie)[0].calorie;
    }

    fun getThreeMostCalories(elves: List<Elf>): List<Int> {
        return elves
            .sortedByDescending(Elf::calorie)
            .chunked(3)[0].stream()
            .map(Elf::calorie)
            .toList()
    }

    // test if implementation meets criteria from the description, like:
    val testInput: List<String> = readInput(1, "smol")
    val testElves: MutableList<Elf> = createElvesWithCalories(testInput)

    check(testElves.sortedByDescending(Elf::calorie)[0].calorie == 24000)

    //--- Part One ---
    //Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
    val input = readInput(1, "input")
    val elves = createElvesWithCalories(input)
    getMostCalories(elves).println()

    //--- Part Two ---
    //Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
    getThreeMostCalories(elves).sum().println()
}

private fun createElvesWithCalories(testInput: List<String>): MutableList<Elf> {
    val elves: MutableList<Elf> = ArrayList()
    var elf = Elf()
    for (cals in testInput) {
        if (cals == "") {
            elves.add(elf)
            elf = Elf()
            continue
        }
        elf.addCalorie(cals.toInt())
    }
    return elves
}

data class Elf(var calorie: Int = 0) {
    fun addCalorie(cals: Int) {
        this.calorie += cals
    }

}
