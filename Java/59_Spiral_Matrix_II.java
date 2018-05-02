/*
59_Spiral_Matrix_II

Given a positive integer n, generate a square matrix filled with elements 
from 1 to n2 in spiral order.

Example:
Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res = new int [n][n];
        int rows = 0, rowe = n - 1, cols = 0, cole = n - 1;
        int count = 1;
        while (count <= n*n && rows <= rowe && cols <= cole) {
            for (int i = cols; i <= cole; i++) {
                res[rows][i] = count;
                count++;
            }
            for (int i = rows + 1; i <= rowe; i++) {
                res[i][cole] = count;
                count++;
            }
            if (rows < rowe && cols < cole) {
                for (int i = cole - 1; i >= cols; i--) {
                    res[rowe][i] = count;
                    count++;
                }
                for (int i = rowe - 1; i >= rows + 1; i--) {
                    res[i][cols] = count;
                    count++;
                }
            }
            rows++;
            cols++;
            rowe--;
            cole--;
        }
        return res;
    }
}