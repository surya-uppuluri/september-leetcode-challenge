package kt.day1

import java.util.*

internal class PermutationGeneratorKotlin {
    /**
     * Given input as 1,2,3,4 generate all permutations of it as -
     * 1234
     * 1243
     * 1324
     * 1342
     * 1423
     * 1432
     * ----
     * 2134
     * 2143
     * 2314
     * 2341
     * 2413
     * 2431
     * ----
     * 3124
     * 3142
     * 3241
     * 3214
     * 3412
     * 3421
     * ----
     * 4123
     * 4132
     * 4213
     * 4231
     * 4312
     * 4321
     */
    private var allPermutations: ArrayList<Any> = ArrayList<Any>()
    lateinit var input: List<Int>
    fun generatePermutations(input: List<Int>): ArrayList<Any> {
        this.input = input //declaring and assigning to class variable to avoid passing this variable around in backtracking/recursion.
        /**
         * Algorithm to generate permutations of a given array/string
         * ---------------------------------------------------
         *
         * If you look at the example of human mind generating permutations, it does it systematically. Think how?
         * 1. Take a number, generate all possibilities with that number.
         * 2. Then remove the number that you just took and start over again till each permutation is generated having size
         * equal to the size of given input. [2134 has same size as 1234. You removed initial 1 and replaced it with 2
         * to get a new permutation.
         * 3. We are going to do the same programmatically. Watch out how.
         */
        val eachRow: ArrayList<Any> = ArrayList<Any>()
        val visited = BooleanArray(input.size) //I prefer array rather than list for bool because it comes prepopulated with false which is what I want.
        backtrack(eachRow, visited)
        return allPermutations
    }

    private fun backtrack(eachRow: ArrayList<Any>, visited: BooleanArray) {
        /** Define base case first. When do you stop recursing for a given row?
         * When you find that a row has all 4 digits populated for a input size of 4.
         */
        if (eachRow.size === input.size) {
            allPermutations.add(ArrayList(eachRow))
            return
        }
        for (i in input.indices) {
            if (visited[i]) continue  //if a column in current iteration is marked as true, continue till the end and find new permutations
            eachRow.add(input[i]) //If it's not true, it means it's not in current permutation yet. Add it and backtrack
            visited[i] = true //well you've already visited the column. Mark it true.
            backtrack(eachRow, visited) //backtrack with current configuration
            eachRow.remove(eachRow.size - 1) //Now, just like your mind removed the last right most element to replace it with a new element to generate a new permutation, let the code do the same.
            visited[i] = false //I want to give rise to new permutations
        }
    }
}