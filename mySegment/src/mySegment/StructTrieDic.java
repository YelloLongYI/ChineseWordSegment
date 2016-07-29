package mySegment;
import java.util.*;
import java.io.*;
import tools.*;

public class StructTrieDic {
	
	private String FilePath;
	
	private Trie TrieHead;
	
	private TrieOperate op;
	
	public StructTrieDic(String FilePath){
		this.FilePath=FilePath;
		this.TrieHead=new Trie(' ');
		this.op=new TrieOperate(this.TrieHead);
	}
	
	private List<String> ReadData() throws Exception{
		List<String> lines=new Readdata(this.FilePath,"UTF-8").GetData();
		return lines;
	}
	
	public Trie MakeTrie() throws Exception{
		List<String> lines=ReadData();
		Iterator<String> iter=lines.iterator();
		String temp;
		while(iter.hasNext()){
			temp=iter.next();
			String[] split=temp.split("\\s+");
			for(int i=0;i<split.length;i++)	{
				this.op.addInTrie(split[i]);
			}
			
		}
		return this.TrieHead;
	}
	
	
	
	
}
