class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] last = new int[s.length()];

        for(int i = 0; i < s.length(); i++) {
            int lastPresent = i;
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) lastPresent = j;
            }
            last[i] = lastPresent;
        }

        for(int i = 0; i < last.length; i++) {
            System.out.println("picked: " + s.charAt(i));
            int max = last[i];
            for(int k = i; k < max; k++) {
                if(max < last[k]) max = last[k];
            }

            list.add(max - i + 1);
            i = max;
        }

        return list;
    }
}