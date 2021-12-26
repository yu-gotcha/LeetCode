class Trie {
    
    private Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(!node.isContain(word.charAt(i)))
                node.put(word.charAt(i), new Node());
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = searchPrefix(prefix);
        return node != null;
    }
    
    private Node searchPrefix(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++) {
            if(node.isContain(word.charAt(i)))
                node = node.get(word.charAt(i));
            else return null;
        }
        
        return node;
    }
}

class Node {
    private Node[] nodes;
    private boolean isEnd;
    
    public Node() {
        this.nodes = new Node[26];
        this.isEnd = false;
    }
    
    public boolean isContain(char ch) {
        return this.nodes[ch - 'a'] != null;
    }
    
    public Node get(char ch) {
        return this.nodes[ch - 'a'];
    }
    
    public void put(char ch, Node node) {
        this.nodes[ch - 'a'] = node;
    }
    
    public void setEnd() {
        this.isEnd = true;
    }
    
    public boolean isEnd() {
        return this.isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */