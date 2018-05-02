/*
54_Spiral_Matrix

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

*/

class Solution {
	public List<Integer> spiralOrder (int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0)
			return res;

		int rowstart = 0, rowend = matrix.length - 1;
		int colstart = 0, colend = matrix[0].length - 1;

		while (rowstart <= rowend && colstart <= colend) {
			// row
			for (int i = colstart; i <= rowend; i++) 
				res.add(matrix[rowstart][i]);

			//col
			for (int j = rowstart + 1; j < rowend; j++) 
				res.add(matrix[j][colend]);

			if (rowstart < rowend && colstart < colend) {
				for (int k = colend - 1; k > colstart; k--)
					res.add(matrix[rowend][k]);
				for (int l = rowend; l > rowstart; l--) 
					res.add(matrix[l][colstart]);
			}
			rowstart++;
			rowend--;
			colstart++;
			colend--;
		}
		return res;
	}
}