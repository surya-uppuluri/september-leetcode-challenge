package kt.day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class PermutationGeneratorKotlinTest {

    @Test
    fun generatePermutations() {
        val generatedPermutations = PermutationGeneratorKotlin().generatePermutations(listOf(1, 2, 3, 4))
        generatedPermutations.forEach(System.out::print)
        /*assertEquals(24, generatedPermutations.size)*/
    }
}