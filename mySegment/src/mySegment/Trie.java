package mySegment;
import java.util.*;

public class Trie {
	
	private ArrayList<Trie> childs;
	
	private HashMap<Character,Integer> childs_index;
	
	private char word;
	
	private int count;
	
	private boolean isWord=false;
	
	public Trie(char word){
		this.word=word;
		this.childs=new ArrayList<Trie>();
		this.childs_index=new HashMap<Character,Integer>();
		this.count=0;
	}
	
	public Trie addInTrie(char newWord){
		if(childs_index.containsKey(newWord)){	
			int index=this.childs_index.get(newWord);
			return this.childs.get(index);
		}
		else{
			Trie newNode=new Trie(newWord);
			this.childs_index.put(newWord, count);
			this.childs.add(newNode);
			count++;
			return newNode;
		}
	}
	
	public String toString(){
		return String.valueOf(this.word);
	}
	
	public Trie getChild(int index){
		if(index>this.count)
			return null;
		return this.childs.get(index);
	}
	
	public boolean isString(char query){
		return this.word==query;
	}
	
	public Trie next(char query){
		if(!this.childs_index.containsKey(query))
			return null;
		int index=this.childs_index.get(query);
		return this.childs.get(index);
	}
	
	public void MakeNewWord(){
		this.isWord=true;
	}
	
	public boolean isWord(){
		return this.isWord;
	}

}
