package com.example.algorithms

fun main() {
    println(
        areSimilar(
            mutableListOf(4, 3, 2, 1),
            mutableListOf(1, 2, 3, 4)
        )
    )
}

fun adjacentElementsProduct(list: MutableList<Int>): Int? {
    /*Example
    * [1,2,3,4,5]
    * This code seeks the greatest multiplication of pairs
    *  Result [4,5] = 20 */
    return list.zipWithNext(Int::times).max()
}

fun shapeAreaPolygon(n: Int): Int {
    /*Example
    * [2]
    * See imageC1
    * Result = 5 */
    return n * n + (n - 1) * (n - 1)
}

fun makeArrayConsecutive(list: MutableList<Int>): Int {
    /*Example
    * [6,2,3,8]
    * This algorithm orders a list of Int from the smallest to the largest and returns how many
    * more numbers are needed to make the ladder between the smallest and the largest
    * Result = 3 -> [2,3,6,8] -> [2,3,{4,5},6,{7},8] = {3}
    * */
    println(list)
    return list.max()!! - list.min()!! - list.size + 1
}

fun matrixElementsSum(matrix: List<List<Int>>): Int {
    /*Example
    * [[0, 1, 1, 2],
       [0, 5, 0, 0],
       [2, 0, 3, 3]]
    * This algorithm adds all the values ​​of the matrix that do not have a zero above them
    * See image C2
    * Result = 9
    * */
    matrix.forEach { println(it) }
    return matrix[0].indices.map { c ->
        matrix.indices.map { matrix[it][c] }.takeWhile { it > 0 }.sum()
    }.sum()
}

fun allLongestStrings(inputArray: MutableList<String>): List<String> {
    /*Example
   * [[Ocean, Sun, Moon, Universe],
   * This algorithm returns the longest word in a string list
   * Result = Universe
   * */
    return inputArray.filter {
        println(it)
        it.length == inputArray.maxBy {
            println(it)
            it.length
        }?.length
    }
}

fun commonCharacterCount(a: String, b: String): Int {
    /*Example
   * [Share, Sure],
   * This algorithm returns the number of equal characters between two words
   * Result = 3 [S, R, E]
   * */

    return ('a'..'z').map { c -> a.count { it == c }.coerceAtMost(b.count { it == c }) }.sum()
}

fun sortByHeight(a: MutableList<Int>): MutableList<Int> {
    /*Example
   * [-1, 150, -1, -1, 190, 140, 130, -1],
   * This algorithm returns a list ordered by height without ignoring obstacles (-1).
   * Result = [-1, 130, -1, -1, 140, 150, 190, -1]
   * */
    val s = a.filter { it != -1 }.sorted().toMutableList()
    return a.map { if (it == -1) -1 else s.removeAt(0) }.toMutableList()
}

fun alternatingSums(a: List<Int>): List<Int> {
    /*Example
   * [57, 53, 101, 31] = 242,
   * This algorithm receives a list of integers and returns an alternative sound for all elements.
   * Result = [158, 84] = 242
   * */
    return a.withIndex()
        .partition { it.index % 2 == 0 }.toList()
        .map { it.sumBy { it.value } }
}

fun addBorder(picture: MutableList<String>): MutableList<String> {
    /*Example
   * [Kotlin],
   * This algorithm receives a list of strings and draws a border with *.
   *          [********]
   * Result = [*Kotlin*]
   *          [********]
   * */
    return picture
        .map { "*$it*" }
        .toMutableList().apply {
            add(
                0,
                "*${"*".repeat(picture[0].length)}*"
            )
            add(get(0))
        }
}

fun areSimilar(a: MutableList<Int>, b: MutableList<Int>): Boolean {
    val exchangeLimit = 3
    /*Example
   * Z = (A = [1,2,3] B = [3,2,1]) \\ W = (A = [1,2,3,4] B = [4,3,2,1])
   * This algorithm receives two lists of integers and verify that they are similar.
   * Result = Z = True and W = false
   * exchangeLimit controls the limit of possible swaps to obtain a similarity
   * a.zip(b).filter { it.first != it.second }.count() -> count similarity
   * */
    return a.sorted() == b.sorted() && a.zip(b).filter { it.first != it.second }.count() < exchangeLimit
}

