class RandomizedSet {
    Map<Integer, Integer> map; // val, index
    int[] arr;
    int size;
    Random random;

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new int[200000];
        size = 0;
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, size);
        arr[size++] = val;
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);
        int replacingValue = arr[size - 1];
        
        arr[index] = replacingValue;
        map.put(replacingValue, index);
        
        map.remove(val);
        size--;
        
        return true;
    }
    
    public int getRandom() {
        int index = random.nextInt(size);
        
        return arr[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */