public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeftPlot = false, emptyRightPlot = false;
                if((i == 0) || (flowerbed[i - 1] == 0)) emptyLeftPlot = true;
                if((i == flowerbed.length - 1) || (flowerbed[i + 1] == 0)) emptyRightPlot = true;
                if (emptyLeftPlot && emptyRightPlot) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}