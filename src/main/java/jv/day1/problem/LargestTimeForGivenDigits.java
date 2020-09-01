package jv.day1.problem;

import jv.day1.prerequisites.PermutationGenerator;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class LargestTimeForGivenDigits {

    /**
     * 949. Largest Time for Given Digits
     * Easy
     * <p>
     * 271
     * <p>
     * 565
     * <p>
     * Add to List
     * <p>
     * Share
     * Given an array of 4 digits, return the largest 24 hour time that can be made.
     * <p>
     * The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.
     * <p>
     * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: [1,2,3,4]
     * Output: "23:41"
     * Example 2:
     * <p>
     * Input: [5,5,5,5]
     * Output: ""
     * <p>
     * <p>
     * Note:
     * <p>
     * A.length == 4
     * 0 <= A[i] <= 9
     */

    public String largestTimeFromDigits(int[] input) {
        PermutationGenerator permutationGenerator = new PermutationGenerator();
        List<List<Integer>> permutations = permutationGenerator.generatePermutations(input);
        List<String> validTimes = new ArrayList<>();
        for (List<Integer> permutation : permutations) {
            String permutedString = getStringFromList(permutation);
            log.info("Permuted String: {}", permutedString);
            if (isValidTime(permutedString)) {
                log.info("{} is a valid string", permutedString);
                validTimes.add(permutedString);
            }
        }
        validTimes.sort(Collections.reverseOrder());
        String res = "";
        if (validTimes.size() > 0) {
            String longestTime = validTimes.get(0);
            res = longestTime.substring(0, 2) + ":" + longestTime.substring(2); //format the result in HH:MM format
        }
        return res;

    }

    private boolean isValidTime(String permutedString) {
        if (permutedString.charAt(0) > '2') return false; //3H:MM is just invalid
        if (permutedString.charAt(0) == '2') { //23:MM case
            if (permutedString.charAt(1) > '3') return false;
        }
        if (permutedString.charAt(2) > '5')
            return false; //HH:5M is max possible, then it should get reset. SHould be really careful in char comparison. Compare with '5' not 5
        //log.info("Returning true");
        return true;
    }

    private String getStringFromList(List<Integer> permutation) {
        String s = "";
        for (int i = 0; i < permutation.size(); i++)
            s += permutation.get(i);
        return s;
    }


}
