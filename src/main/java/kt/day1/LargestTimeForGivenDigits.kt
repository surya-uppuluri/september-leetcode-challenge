package kt.day1

import jv.day1.prerequisites.PermutationGenerator
import lombok.extern.slf4j.Slf4j
import java.util.*

@Slf4j
class LargestTimeForGivenDigits {
    /**
     * 949. Largest Time for Given Digits
     * Easy
     *
     *
     * 271
     *
     *
     * 565
     *
     *
     * Add to List
     *
     *
     * Share
     * Given an array of 4 digits, return the largest 24 hour time that can be made.
     *
     *
     * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
     *
     *
     * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
     *
     *
     *
     *
     *
     *
     * Example 1:
     *
     *
     * Input: [1,2,3,4]
     * Output: "23:41"
     * Example 2:
     *
     *
     * Input: [5,5,5,5]
     * Output: ""
     *
     *
     *
     *
     * Note:
     *
     *
     * A.length == 4
     * 0 <= A[i] <= 9
     */
    fun largestTimeFromDigits(input: IntArray?): String {
        val permutationGenerator = PermutationGenerator()
        val permutations = permutationGenerator.generatePermutations(input)
        val validTimes: MutableList<String> = ArrayList()
        for (permutation in permutations) {
            val permutedString = getStringFromList(permutation)
            if (isValidTime(permutedString)) {
                validTimes.add(permutedString)
            }
        }
        validTimes.sortWith(Collections.reverseOrder())
        var res = ""
        if (validTimes.size > 0) {
            val longestTime = validTimes[0]
            res = longestTime.substring(0, 2) + ":" + longestTime.substring(2) //format the result in HH:MM format
        }
        return res
    }

    private fun isValidTime(permutedString: String): Boolean {
        if (permutedString[0] > '2') return false //3H:MM is just invalid
        if (permutedString[0] == '2') { //23:MM case
            if (permutedString[1] > '3') return false
        }
        return if (permutedString[2] > '5') false else true //HH:5M is max possible, then it should get reset. SHould be really careful in char comparison. Compare with '5' not 5
        //log.info("Returning true");
    }

    private fun getStringFromList(permutation: List<Int>): String {
        var s = ""
        for (i in permutation.indices) s += permutation[i]
        return s
    }
}