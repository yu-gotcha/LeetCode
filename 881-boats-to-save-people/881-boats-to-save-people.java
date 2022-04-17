import java.util.*;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, count = 0;
        
        while(i <= j) {
            int sum = people[i] + people[j];
            
            if(sum <= limit) {
                i++;
                j--;
            }
            else j--;
            
            count++;
        }
        
        return count;
    }
}