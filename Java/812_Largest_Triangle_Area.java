/*
812_Largest_Triangle_Area

You have a list of points in the plane. Return the area of the 
largest triangle that can be formed by any 3 of the points.

Example:
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2
Explanation: 
The five points are show in the figure below. The red triangle is 
the largest.

*/

class Solution {
    public double largestTriangleArea(int[][] points) {
        double max_area = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = i + 1; k < n; k++) {
                    max_area = Math.max(max_area, area(points[i], points[j], points[k]));
                }
            }
        }
        return max_area;
    }
    
    private double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0] * (Q[1] - R[1]) + Q[0] * (R[1] - P[1]) + R[0] * (P[1] - Q[1]));
    }
}