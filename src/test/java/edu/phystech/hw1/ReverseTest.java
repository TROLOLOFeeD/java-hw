package edu.phystech.hw1;

import java.util.Arrays;
import java.util.Objects;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ReverseTest {

    private static int[] reverse(int[] nums) {
        if (nums.length > 1) {
            int[] num_ = new int[nums.length];
            for (int i = 0; i < nums.length / 2; ++i) {
                num_[i] = nums[nums.length - i - 1];
                num_[nums.length - i - 1] = nums[i];
            }
            if (nums.length % 2 == 1) {
                num_[nums.length / 2] = nums[nums.length / 2];
            }
            return num_;
        } else return nums;
    }


    @Test
    public void reverseWorks() {
        Assertions.assertArrayEquals(new int[]{1}, reverse(new int[]{1}));
        Assertions.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reverse(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    public void reverseReturnsNewArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] reversed = reverse(input);

        Assertions.assertArrayEquals(new int[]{5, 4, 3, 2, 1}, reversed);
        Assertions.assertArrayEquals(copy, input);
    }
}