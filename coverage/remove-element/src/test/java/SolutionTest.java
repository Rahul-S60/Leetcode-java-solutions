import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("0027 - Remove Element")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("removes every occurrence of the value and returns the new length")
    void removesValueFromArray() {
        int[] nums = {3, 2, 2, 3};
        int k = solution.removeElement(nums, 3);
        assertEquals(2, k);
        assertArrayEquals(new int[] {2, 2}, Arrays.copyOf(nums, k));
    }

    @Test
    @DisplayName("keeps the remaining elements in their original order")
    void preservesOrderOfRemainingElements() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int k = solution.removeElement(nums, 2);
        assertEquals(5, k);
        assertArrayEquals(new int[] {0, 1, 3, 0, 4}, Arrays.copyOf(nums, k));
    }

    @Test
    @DisplayName("returns 0 when every element matches the value")
    void removesAllElements() {
        int[] nums = {4, 4, 4};
        int k = solution.removeElement(nums, 4);
        assertEquals(0, k);
    }

    @Test
    @DisplayName("leaves the array untouched when the value is absent")
    void valueNotPresent() {
        int[] nums = {1, 2, 3};
        int k = solution.removeElement(nums, 9);
        assertEquals(3, k);
        assertArrayEquals(new int[] {1, 2, 3}, Arrays.copyOf(nums, k));
    }

    @Test
    @DisplayName("handles an empty array")
    void handlesEmptyArray() {
        int[] nums = {};
        int k = solution.removeElement(nums, 1);
        assertEquals(0, k);
    }
}
