import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("0001 - Two Sum")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("returns the indices of the two numbers that add up to the target")
    void findsPairAtStartOfArray() {
        assertArrayEquals(new int[] {0, 1}, solution.twoSum(new int[] {2, 7, 11, 15}, 9));
    }

    @Test
    @DisplayName("finds a pair that is not at the beginning of the array")
    void findsPairInMiddle() {
        assertArrayEquals(new int[] {1, 2}, solution.twoSum(new int[] {3, 2, 4}, 6));
    }

    @Test
    @DisplayName("handles a pair made of two equal values")
    void findsPairOfEqualValues() {
        assertArrayEquals(new int[] {0, 1}, solution.twoSum(new int[] {3, 3}, 6));
    }

    @Test
    @DisplayName("works with negative numbers")
    void handlesNegativeNumbers() {
        assertArrayEquals(new int[] {0, 3}, solution.twoSum(new int[] {-3, 4, 5, -1}, -4));
    }

    @Test
    @DisplayName("returns an empty array when no pair sums to the target")
    void returnsEmptyWhenNoSolution() {
        assertArrayEquals(new int[] {}, solution.twoSum(new int[] {1, 2, 3}, 100));
    }

    @Test
    @DisplayName("returns an empty array for an empty input")
    void returnsEmptyForEmptyInput() {
        assertArrayEquals(new int[] {}, solution.twoSum(new int[] {}, 0));
    }

    @Test
    @DisplayName("the returned indices point at values that add up to the target")
    void returnedIndicesAreConsistent() {
        int[] nums = {0, 8, 3, 5, 6};
        int target = 11;
        int[] result = solution.twoSum(nums, target);
        assertEquals(2, result.length);
        assertTrue(result[0] < result[1]);
        assertEquals(target, nums[result[0]] + nums[result[1]]);
    }
}
