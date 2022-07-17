class Solution {
    public String simplifyPath(String path) {
        String[] directory = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        
        for(String dir : directory) {
            if(dir.length() == 0) continue;
            if(dir.equals(".")) continue;
            if(dir.equals("..")) {
                if(!list.isEmpty()) list.removeLast();
                continue;
            }
            list.add("/" + dir);
        }
        
        if(list.isEmpty()) list.add("/");
        
        StringBuilder sb = new StringBuilder();
        for(String dir : list) sb.append(dir);
        return sb.toString();
    }    
}