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
		if(trie==null)  //����Ҳ�����һ�����ӣ����Ҳ���
			return false;
		if(trie.isWord())  //����������ͣ��λ����һ����
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
