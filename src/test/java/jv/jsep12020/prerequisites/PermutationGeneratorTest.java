package jv.jsep12020.prerequisites;

import jv.sep12020.prerequisites.PermutationGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationGeneratorTest {

    @Test
    void testThatPermutationsAreGeneratedCorrectly() {
        PermutationGenerator Generator = new PermutationGenerator();
        List<List<Integer>> permutations = Generator.generatePermutations(new int[]{1, 2, 3, 4});
        System.out.println(permutations);
        assertEquals(permutations.size(), 24);

    }


}