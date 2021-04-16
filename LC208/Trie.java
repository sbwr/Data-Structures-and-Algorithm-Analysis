package LC208;

class Trie {
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26]; // 用0-25表示a-z
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        int index, len = word.length();
        for(int i = 0; i < len; i ++){
            index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        int index, len = word.length();
        for(int i = 0; i < len; i ++){
            index = word.charAt(i) - 'a';
            if(node.children[index] == null){
                return false;
            }
            node = node.children[index];
        }return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        int index, len = prefix.length();
        for(int i = 0; i < len; i ++){
            index = prefix.charAt(i) - 'a';
            if(node.children[index] == null){
                return false;
            }
        node = node.children[index];
        }return true; 
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
