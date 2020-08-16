// In a given grid, each cell can have one of three values:

// the value 0 representing an empty cell;
// the value 1 representing a fresh orange;
// the value 2 representing a rotten orange.
// Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

// Example 1:



// Input: [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
// Example 2:

// Input: [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
// Example 3:

// Input: [[0,2]]
// Output: 0
// Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

// Note:

// 1 <= grid.length <= 10
// 1 <= grid[0].length <= 10
// grid[i][j] is only 0, 1, or 2.

class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<List<Integer>> queue = new ArrayDeque<>();
        int length = grid.length;
        int width = grid[0].length;
        int freshOranges = 0;
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(Arrays.asList(i, j));
                }
                if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        int count = 0;
        for(; freshOranges > 0 && queue.size() > 0; count++) {
            int size = queue.size();
            
            for(int index = 0; index < size; index++) {
            List<Integer> tempList = queue.poll();
            int i = tempList.get(0);
            int j = tempList.get(1);
            if(i + 1 < length) {
                if(grid[i + 1][j] == 1) {
                    queue.offer(Arrays.asList(i + 1, j));
                    grid[i + 1][j] = 2;
                    freshOranges--;
                }
            }
            if(i - 1 >= 0) {
                if(grid[i - 1][j] == 1) {
                    queue.offer(Arrays.asList(i - 1, j));
                    grid[i - 1][j] = 2;
                    freshOranges--;
                }
            }
            if(j - 1 >= 0) {
                if(grid[i][j - 1] == 1) {
                    queue.offer(Arrays.asList(i, j - 1));
                    grid[i][j - 1] = 2;
                    freshOranges--;
                }
            }
            if(j + 1 < width) {
                if(grid[i][j + 1] == 1) {
                    queue.offer(Arrays.asList(i, j + 1));
                    grid[i][j + 1] = 2;
                    freshOranges--;
                }
            }
            }
        }
      
        return freshOranges == 0 ? count : -1;
    }
}













