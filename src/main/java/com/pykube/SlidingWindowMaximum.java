package com.pykube;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // remove elements not within the window
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // remove smaller elements within the window
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // add current element at the back of the deque
            deque.offer(i);
            // record the max value in the result
            if (i >= k - 1) {
                result[ri++] = nums[deque.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solver = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = solver.maxSlidingWindow(nums, k);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
