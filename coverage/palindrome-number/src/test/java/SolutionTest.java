import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("0009 - Palindrome Number")
class SolutionTest {

    private final Solution solution = new Solution();

    @ParameterizedTest(name = "{0} is a palindrome")
    @ValueSource(ints = {0, 1, 7, 121, 1221, 12321, 1000000001})
    void recognisesPalindromes(int value) {
        assertTrue(solution.isPalindrome(value));
    }

    @ParameterizedTest(name = "{0} is not a palindrome")
    @ValueSource(ints = {10, 123, 100, 1231})
    void rejectsNonPalindromes(int value) {
        assertFalse(solution.isPalindrome(value));
    }

    @Test
    @DisplayName("negative numbers are never palindromes")
    void negativeNumbersAreNotPalindromes() {
        assertFalse(solution.isPalindrome(-121));
        assertFalse(solution.isPalindrome(-1));
    }

    @Test
    @DisplayName("zero is a palindrome")
    void zeroIsPalindrome() {
        assertTrue(solution.isPalindrome(0));
    }
}
