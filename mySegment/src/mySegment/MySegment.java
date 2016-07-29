package mySegment;
import java.util.*;

public class MySegment {
	
	private Trie trieHead;
	private TrieOperate op;

	public MySegment() throws Exception{
		StructTrieDic make=new StructTrieDic("Data\\TrainCorpus.txt");
		this.trieHead=make.MakeTrie();
		this.op=new TrieOperate(trieHead);
	}
	
	public MySegment(int maxLength) throws Exception{
		StructTrieDic make=new StructTrieDic("Data\\TrainCorpus.txt");
		this.trieHead=make.MakeTrie();
		this.op=new TrieOperate(trieHead);
		SegmentSentence.setMaxLength(maxLength);
	}
	
	public void setMaxLength(int maxLength){
		SegmentSentence.setMaxLength(maxLength);
	}
	
	public List<String> segment_Maximum_Forward_Matching(String sentence){
		return SegmentSentence.segment_Maximum_Forward_Matching(sentence, op);
	}
	
	public List<String> segment_N_Minimum_Path(String sentence){
		//System.out.println(sentence);
		return SegmentSentence.segment_N_Minimum_Path(sentence,op);
	}
}
