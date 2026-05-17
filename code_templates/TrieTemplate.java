/**
 * TRIE (Prefix Tree) TEMPLATE
 * 
 * When to use:
 * - Prefix searching / autocomplete
 * - Word dictionary with search (including wildcards)
 * - Word Search II (Trie + DFS backtracking)
 * - XOR maximum (bitwise trie)
 */

public class TrieTemplate {

    private TrieNode root;

    public TrieTemplate() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null)
                return null;
            node = node.children[idx];
        }
        return node;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        // For Word Search II, you can add: String word;
    }
}
