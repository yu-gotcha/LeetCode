class Solution {
    public int[] replaceElements(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max || arr[i - 1] == max) max = findMax(i, arr);
            arr[i - 1] = max;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
    
    public int findMax(int i, int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int j = i; j < arr.length; j++) {
            max = Math.max(arr[j], max);
        }
        return max;
    }
}