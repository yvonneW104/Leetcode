/*
447_Number_of_Boomerangs

Given n points in the plane that are all pairwise distinct, 
a "boomerang" is a tuple of points (i, j, k) such that the 
distance between i and j equals the distance between i and 
k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will 
be at most 500 and coordinates of points are all in the range 
[-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

*/

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length == 0)  return 0;
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            for (int j = 0; j < points.length; j++) {
                double dis = distance(points[i], points[j]);
                if (map.containsKey(dis)) {
                    int value = map.get(dis);
                    count += 2 * value;
                    map.put(dis, value + 1);
                } else 
                    map.put(dis, 1);
            }
        }
        return count;
    }
    
    public Double distance(int[] a, int[]b){
        return Math.sqrt(Math.pow(a[0]-b[0],2) + Math.pow(a[1]-b[1],2));
    }
}