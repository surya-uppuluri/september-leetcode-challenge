package jv.jsep12020.problem;

import jv.day1.problem.LargestTimeForGivenDigits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestTimeForGivenDigitsTest {

    @Test
    @DisplayName("Should return an empty string")
    void largestTimeFromDigits_Negative() {

        LargestTimeForGivenDigits forGivenDigits = new LargestTimeForGivenDigits();
        String res = forGivenDigits.largestTimeFromDigits(new int[]{5, 5, 5, 5});
        assertEquals("", res);
    }


    @Test
    @DisplayName("Should return an 23:41 string")
    void largestTimeFromDigits_Positive() {
        LargestTimeForGivenDigits forGivenDigits = new LargestTimeForGivenDigits();
        String res = forGivenDigits.largestTimeFromDigits(new int[]{1, 2, 3, 4});
        assertEquals("23:41", res);
    }
}