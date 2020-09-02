package jv.day2.problem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NearByDuplicateTest {

    NearByDuplicate nearByDuplicate = new NearByDuplicate();

    @Test
    @DisplayName("Positive case 1 - should return true")
    void bruteForceApproach1() {
        boolean result = nearByDuplicate.bruteForceApproach(new int[]{1,2,3,1}, 3, 0);
        assertTrue(result);
    }

    @Test
    @DisplayName("Positive case 2- should return false")
    void bruteForceApproach2() {
        boolean result = nearByDuplicate.bruteForceApproach(new int[]{1,0,1,1}, 1, 2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Positive case 3- should return false")
    void bruteForceApproach3() {
        boolean result = nearByDuplicate.bruteForceApproach(new int[]{1,5,9,1,5,9}, 2, 3);
        assertFalse(result);
    }

    @Test
    @DisplayName("Negative case - When Integer.MAX_VALUE is supplied, should return false")
    void bruteForceApproach4() {
        boolean result = nearByDuplicate.bruteForceApproach(new int[]{-1, Integer.MAX_VALUE}, 1, Integer.MAX_VALUE);
        assertFalse(result);
    }
}