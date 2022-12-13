package day01

import println
import readInput

fun main() {

    fun part1(input: String): Int {
        val data = input.split("\n\n").map { elf ->
            elf.lines().filter { it != "" }.sumOf { it.toInt() }
        }
        return data.max()
    }

    fun part2(input: String): Int {
        return input.split("\n\n").map { elf ->
            elf.lines().filter { it != "" }.sumOf { it.toInt() }
        }
            .sortedDescending()
            .take(3)
            .sum()
    }


    val testInput = readInput(1, "smol")

    check(part1(testInput) == 24000)

    //--- Part One ---
    //Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
    val input = readInput(1, "input")
    part1(input).println()


    //--- Part Two ---
    //Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
    part2(input).println()
}
