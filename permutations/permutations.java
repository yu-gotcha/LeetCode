class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<Integer>(), visited, 0);
        
        return list;
        
    }
    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> tmp, boolean[] visited, int count) {
        if(count == nums.length) return;
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                tmp.add(nums[i]);
                visited[i] = true;
                dfs(nums, list, tmp, visited, count + 1);
                visited[i] = false;
                if(tmp.size() == nums.length) list.add(new ArrayList<>(tmp));
                tmp.remove(count);
                tmp = new ArrayList<>(tmp);
            }
        }
    }
}