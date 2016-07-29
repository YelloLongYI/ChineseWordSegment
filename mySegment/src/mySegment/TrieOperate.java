package mySegment;

public class TrieOperate {
	
	private Trie TrieHead;
	
	public TrieOperate(Trie TrieHead){
		this.TrieHead=TrieHead;
	}
	
	public boolean SearchInTrie(String query){
		char[] split=query.toCharArray();
		Trie trie=this.TrieHead;
		for(int i=0;i<split.length;i++){
			if(trie==null)
				return false;
			trie=trie.next(split[i]);	
		}
		if(trie==null)  //如果找不到下一个孩子，则找不到
			return false;
		if(trie.isWord())  //遍历完后，如果停留位置是一个词
			return true;
		return false;
	}
	
	void addInTrie(String str){
		char[] split=str.toCharArray();
		Trie trie=this.TrieHead;
		for(int i=0;i<split.length;i++){
			trie=trie.addInTrie(split[i]);
		}
		trie.MakeNewWord();
	}
}
