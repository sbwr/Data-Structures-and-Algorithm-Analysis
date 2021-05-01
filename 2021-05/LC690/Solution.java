package LC690;

import java.util.*;

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // 找到该id
        Employee target = new Employee();
        int ans = 0;
        for(Employee e : employees) {
            if(e.id == id) {
                target = e;
                break;
            }
        }ans += target.importance;
        for(Employee e : employees) {
            for (int i : target.subordinates) {
                if(e.id == i){
                    ans += getImportance(employees, i);
                }
            }
        }
        return ans;
    }
}