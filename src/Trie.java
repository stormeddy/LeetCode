/*Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.*/

/*Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.*/
public class Trie {
	
	static class TrieNode {
	    // Initialize your data structure here.
		TrieNode[] child=new TrieNode[26];
        int count;
        String val;
	    public TrieNode() {
	        
	    }
	}
    private TrieNode root;

    public Trie() {
        root = new TrieNode();        
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur=root;
        for (int i = 0; i < word.length(); i++) {
			int temp=word.charAt(i)-'a';
			if (cur.child[temp]==null) {
				cur.child[temp]=new TrieNode();
				cur.child[temp].val=cur.val+word.charAt(i);		
				cur=cur.child[temp];
			}
			else {
				cur=cur.child[temp];
			}
		}
		cur.count++;
    }
    
    public void addWord(String word){
    	TrieNode cur=root;
        for (int i = 0; i < word.length(); i++) {
			int temp=word.charAt(i)-'a';
			if (cur.child[temp]==null) {
				cur.child[temp]=new TrieNode();
				cur.child[temp].val=cur.val+word.charAt(i);		
				cur=cur.child[temp];
			}
			else {
				cur=cur.child[temp];
			}
		}
		cur.count++;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur=root;
        for (int i = 0; i < word.length(); i++) {
			int temp=word.charAt(i)-'a';
			if (cur.child[temp]==null) {
				return false;
			}
			else {
				cur=cur.child[temp];
			}
		}
		if(cur.count==0) return false;
		else return true;
    }
    
    public boolean searchAll(String word) {
		return searchWord(word, root);
	}
    
    public boolean searchWord(String word,TrieNode root){
    	TrieNode cur=root;
        for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i)=='.') {
				for (int j = 0; j < 26; j++) {
					if (cur.child[j]!=null) {
						if(searchWord(word.substring(i+1),cur.child[j])) return true;
					}
				}
				return false;
			}else {
				int temp=word.charAt(i)-'a';
				if (cur.child[temp]==null) {
					return false;
				}
				else {
					cur=cur.child[temp];
				}
			}        	
		}
        if(cur.count==0) return false;
		else return true;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur=root;
        for (int i = 0; i < prefix.length(); i++) {
			int temp=prefix.charAt(i)-'a';
			if (cur.child[temp]==null) {
				return false;
			}
			else {
				cur=cur.child[temp];
			}
		}
		return true;//"a"也算以"a"开头
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		trie.insert("ba");
		System.out.println(trie.search("a"));
		System.out.println(trie.startsWith("a"));
		System.out.println((char)('a'+4)+"sjgos");
		System.out.println(trie.searchAll("."));
	}
}

