
// Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

// Example 1:

// Input: [[1,2],[2,3],[3,4],[1,3]]
// Output: 1
// Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
// Example 2:

// Input: [[1,2],[1,2],[1,2]]
// Output: 2
// Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
// Example 3:

// Input: [[1,2],[2,3]]
// Output: 0
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if(length == 0) {
            return 0;
        }
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int count = 0;
        int pre = 0;
        
        for(int i = 1; i < length; i++) {
            if(intervals[pre][1] > intervals[i][0]) {
                if(intervals[pre][1] > intervals[i][1]) {
                    pre = i;
                }
                count++;
            }
            else {
                pre = i;
            }
        }
        
        return count;
    }
}