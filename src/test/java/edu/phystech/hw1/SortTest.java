package edu.phystech.hw1;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class SortTest {

    private static int LeftChild(int i) {
        return 2 * i + 1;
    }

    private static int RightChild(int i) {
        return 2 * i + 2;
    }

    private static void SiftDown(int[] arr, int i, int size) {
        int left = LeftChild(i);
        int right = RightChild(i);
        int large = i;
        if (left < size && arr[left] > arr[large]) large = left;
        if (right < size && arr[right] > arr[large]) large = right;
        if (large != i) {
            int tmp = arr[i];
            arr[i] = arr[large];
            arr[large] = tmp;
            SiftDown(arr, large, size);
        }
    }

    private static void BuildHeap(int[] arr, int size) {
        for (int i = size / 2 - 1; i > -1; --i) SiftDown(arr, i, size);
    }

    private static int[] sort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int size = nums.length;
        BuildHeap(copy, size);
        for (int i = size - 1; i > 0; --i) {
            int tmp = copy[0];
            copy[0] = copy[i];
            copy[i] = tmp;
            --size;
            SiftDown(copy, 0, size);
        }
        return copy;
    }

    @Test
    public void sortWorks() {
        Assertions.assertArrayEquals(new int[]{1}, sort(new int[]{1}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sort(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void sortReturnsNewArray() {
        int[] input = {9, 1, 3, 11, 45, 499};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] sorted = sort(input);

        Assertions.assertArrayEquals(new int[]{1, 3, 9, 11, 45, 499}, sorted);
        Assertions.assertArrayEquals(copy, input);
    }
}
