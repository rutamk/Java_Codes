package Codes.Data_Structures;

public class trie {
    static class Node {
        Node[] children;
        boolean eow; // end of word

        public Node() {
            children = new Node[26]; // a to z
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if (word.length() - i == 1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key) { // O(L) ; L = length of key
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            if (i == key.length() - 1 && curr.children[idx].eow == false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static boolean startsWith(String key) {
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countUniqueSubstrings(Node root, String word, boolean inserting) { // count the number of unique
                                                                                         // substrings in a word. the
                                                                                         // answer will is given by the
                                                                                         // number of nodes in a trie of
                                                                                         // the suffixs of the word.
                                                                                         // ababa has suffixs
                                                                                         // baba,aba,ba,a," ".
        // inserting suffixs in the trie
        if (inserting) {
            for (int i = 0; i < word.length(); i++) {
                String suffix = word.substring(i);
                insert(suffix);
            }
        }
        // count nodes
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int j = 0; j < 26; j++) {
            if (root.children[j] != null) {
                count += countUniqueSubstrings(root.children[j], word, false);
            }
        }
        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // String words[] = {"the","a", "there", "their", "any"};
        // for (int i = 0; i < words.length; i++) {
        // insert(words[i]);
        // }

        // System.out.println(search("their"));
        // System.out.println(search("thor"));
        // System.out.println(search("an"));

        // String wordss[] = {"apple", "app", "mango", "man", "woman"};
        // String prefix = "app";
        // for(int i=0; i<wordss.length; i++) {
        // insert(wordss[i]);
        // }
        // System.out.println(startsWith(prefix));

        System.out.println(countUniqueSubstrings(root, "ababa", true)); // make sure the above part is commented out in
                                                                        // order to get correct answer as it also counts
                                                                        // the previously made tries nodes in this code

        String words[] = { "a", "banana", "app", "appl", "ap", "apply" };
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}