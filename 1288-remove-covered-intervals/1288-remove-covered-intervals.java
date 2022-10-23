class Solution {
     public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)-> {
            if(a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        int max = 0, count = 0;
        
        for(int[] interval : intervals) {
            if(interval[1] <= max) count++;
            max = Math.max(interval[1] ,max);
        }
        return intervals.length - count;
    }
}