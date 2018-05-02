/*
200_Number_of_Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally 
or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

*/

class Solution {
	public int numIslands(char[][] grid) {
		if (grid.length == 0)
			return 0;

		int sum = 0;
		int num_row = grid.length;
		int num_col = grid[0].length;

		for (int i = 0; i < num_row; i++) {
			for (int j = 0; j < num_col; j++) {
				if (grid[i][j] == '1') {
					sum++;
					dfs(grid, i, j);
				}
			}
		}
		return sum;
	}

	private void dfs (char[][] grid, int row, int col) {
		int num_row = grid.length;
		int num_col = grid[0].length;

		if (row < 0 || row >= num_row || col < 0 || col >= num_col || grid[row][col] == '0')
			return;
		grid[row][col] == '0';
		dfs(grid, row + 1, col);
		dfs(grid, row - 1, col);
		dfs(grid, row, col + 1);
		dfs(grid, row, col - 1);
	}
}