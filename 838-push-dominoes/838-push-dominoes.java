import java.util.*;

class Solution {
    public static String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int L = -1;
        int R = -1;

        for (int i = 0; i <= dominoes.length(); ++i)
            if (i == dominoes.length() || arr[i] == 'R') {
                if (L < R) {
                    while (R < i) arr[R++] = 'R';
                }
                R = i;
            } 
            else if (arr[i] == 'L') {
                if (R < L || L == -1 && R == -1) {
                    if (L == -1) L++;
                    while (L < i) arr[L++] = 'L';
                }
                else {
                    int left = R + 1;
                    int right = i - 1;
                    
                    while (left < right) {
                        arr[left++] = 'R';
                        arr[right--] = 'L';
                    }
                }
                L = i;
            }

        return new String(arr);
    }
}