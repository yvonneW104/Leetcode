/*
399_Evaluate_Division

Equations are given in the format A / B = k, where A and B are variables represented as strings, 
and k is a real number (floating point number). Given some queries, return the answers. If the 
answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, 
vector<pair<string, string>> queries , where equations.size() == values.size(), 
and the values are positive. This represents the equations. Return vector<double>.

According to the example above:
equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 

The input is always valid. You may assume that evaluating the queries will result in no division 
by zero and there is no contradiction.

*/

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> eq = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> va = new HashMap<String, ArrayList<Double>>();
        
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i]; // ["a", "b"]
            if (!eq.containsKey(equation[0])) {
                eq.put(equation[0], new ArrayList<String>());
                va.put(equation[0], new ArrayList<Double>());
            }
            if (!eq.containsKey(equation[1])) {
                eq.put(equation[1], new ArrayList<String>());
                va.put(equation[1], new ArrayList<Double>());
            }
            
            eq.get(equation[0]).add(equation[1]);
            eq.get(equation[1]).add(equation[0]);
            va.get(equation[0]).add(values[i]);
            va.get(equation[1]).add(1/values[i]);  
        }
        double [] result = new double[queries.length];
        for (int j = 0; j < result.length; j++) {
            String[] query = queries[j];
            result[j] = get_res(query[0], query[1], eq, va, new HashSet<String>(), 1.0);
            result[j] = result[j] == 0.0 ? -1.0 : result[j];
        }
        return result;
    }
    
    public double get_res(String top, String bot, HashMap<String, ArrayList<String>> eq,
                         HashMap<String, ArrayList<Double>> va, HashSet<String> set, double value) {
        if (set.contains(top))  return 0.0;
        if (!eq.containsKey(top))   return 0.0;
        if (top.equals(bot))  return value;
        set.add(top);
            
        ArrayList<String> str = eq.get(top);
        ArrayList<Double> val = va.get(top);
        double temp = 0.0;
        for (int i = 0; i < str.size(); i++) {
            temp = get_res(str.get(i), bot, eq, va, set, value * val.get(i));
            if (temp != 0.0) {
                break;
            }
        }
        set.remove(top);
        return temp;
    }
}