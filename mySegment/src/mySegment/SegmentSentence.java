package mySegment;
import java.util.*;

public class SegmentSentence {
	
	private static int maxLength=5;
	
	private static List<String> segment_Maximum_Forward_Matching_Core(char[] sentence,TrieOperate trieOp,int begin,int end){
		List<String> res=new ArrayList<String>();
		if(begin<0||begin>=sentence.length)
			return res;
		StringBuilder string=new StringBuilder();
		String match="";
		int start=begin,bias=0,matchLength=1;
		while(start<=end){
			if(start+bias>end||bias>=maxLength){
				res.add(match);
				start+=matchLength;
				matchLength=1;
				bias=0;
				string.delete(0, string.length());
			}else{
				string.append(sentence[start+bias]);
				if(bias==0){
					match=string.toString();
				}else if(trieOp.SearchInTrie(string.toString())){
					match=string.toString();
					matchLength=bias+1;
				}			
				bias++;
			}
		}
		return res;
	}
	
	private static int nextStart(char[] chars,int begin){
		for(int i=begin;i<chars.length;i++){
			if(chars[i]>='0'&&chars[i]<='9')
				return i;
		}
		return -1;
	}
	
	private static int nextEnd(char[] chars,int start){
		for(int i=start;i<chars.length;i++){
			if(chars[i]<'0'||chars[i]>'9')
				return i-1;
		}
		return chars.length-1;
	}
	
	private static void add_Numbers_Start_End(char[] chars,List<Integer> starts,List<Integer> ends){
		int start=0,end=0;
		while(start<chars.length){
			start=nextStart(chars, start);
			if(start<0)
				return;
			end=nextEnd(chars, start);
			starts.add(start);
			ends.add(end);
			start=end+1;
		}
	}
	
	private static int nextLetterStart(char[] chars,int begin){
		for(int i=begin;i<chars.length;i++){
			if((chars[i]>='a'&&chars[i]<='z')||(chars[i]>='A'&&chars[i]<='Z'))
				return i;
		}
		return -1;
	}
	
	private static int nextLetterEnd(char[] chars,int start){
		for(int i=start;i<chars.length;i++){
			if(!(chars[i]>='a'&&chars[i]<='z')&&!(chars[i]>='A'&&chars[i]<='Z'))
				return i-1;
		}
		return chars.length-1;
	}
	
	private static void add_Letter_Start_End(char[] chars,List<Integer> starts,List<Integer> ends){
		int start=0,end=0;
		while(start<chars.length){
			start=nextLetterStart(chars, start);
			if(start<0)
				return;
			end=nextLetterEnd(chars, start);
			starts.add(start);
			ends.add(end);
			start=end+1;
		}
	}
	
	private static void add_Start_End(char[] chars,List<Integer> starts,List<Integer> ends){
		add_Numbers_Start_End(chars, starts, ends);
		add_Letter_Start_End(chars, starts, ends);
		
		Collections.sort(starts);
		Collections.sort(ends);
	}
	
	public static List<String> segment_Maximum_Forward_Matching(String sentence,TrieOperate trieOp){
		char[] chars=sentence.toCharArray();
		List<String> res=new ArrayList<String>();
		List<Integer> starts=new ArrayList<Integer>(),ends=new ArrayList<Integer>();
		add_Start_End(chars, starts, ends);
		int begin=0,end=chars.length-1,start=0;
		Iterator<Integer> startIter=starts.iterator(),endIter=ends.iterator();
		while(startIter.hasNext()){
			start=startIter.next();
			end=endIter.next();
			res.addAll(segment_Maximum_Forward_Matching_Core(chars, trieOp, begin,start-1));
			res.add(String.valueOf(chars, start, end-start+1));
			begin=end+1;
		}
		res.addAll(segment_Maximum_Forward_Matching_Core(chars, trieOp, begin,chars.length-1));
		return res;
	}
	
	public static void setMaxLength(int max){
		maxLength=max;
	}
	
	private static class ListArr{
		int index;
		char word;
		List<Integer> next;
		Iterator<Integer> nextIter;
		public ListArr(int index,char word){
			this.index=index;
			this.word=word;
			this.next=new ArrayList<Integer>();
			
		}
		public void addNext(int next){
			this.next.add(next);
		}
		public boolean hasNext(){
			return this.nextIter.hasNext();
		}
		public int getNext(){
			return this.nextIter.next();
		}
		public void linkComplete(){
			this.nextIter=next.iterator();
		}
		public char getWord(){
			return this.word;
		}
	}
	
	private static void initListArr(ListArr[] char_list,char[] chars){
		for(int i=0;i<chars.length;i++)
			char_list[i]=new ListArr(i, chars[i]);
		for(int i=0;i<chars.length;i++)
			char_list[i].addNext(i);
	}
	
	private static void addStartEndLink(ListArr[] char_list,List<Integer> start,List<Integer> end){
		Iterator<Integer> iter1=start.iterator(),iter2=end.iterator();
		int S,E;
		while(iter1.hasNext()){
			S=iter1.next();
			E=iter2.next();
			char_list[S].addNext(E);
		}
	}
	
	private static void addWordLink(ListArr[] char_list,TrieOperate trieOp){
		StringBuilder cur_string=new StringBuilder();
		int start=0,bias;
		while(start<char_list.length){
			bias=1;
			cur_string.append(char_list[start].getWord());
			while(bias<maxLength&&start+bias<char_list.length){
				cur_string.append(char_list[start+bias].getWord());
				if(trieOp.SearchInTrie(cur_string.toString())){
					char_list[start].addNext(start+bias);
					//System.out.println(cur_string.toString()+" "+start+" "+(start+bias));
				}
				bias++;
			}
			cur_string.delete(0, cur_string.length());
			start++;
		}
		
	}
	
	private static int[] getMinPath(ListArr[] char_list){
		int[] minPathDP=new int[char_list.length+1],minPathRoute=new int[char_list.length+1];
		int next;
		for(int i=char_list.length-1;i>=0;i--){
			minPathDP[i]=Integer.MAX_VALUE;
			while(char_list[i].hasNext()){
				next=char_list[i].getNext();
				if(minPathDP[i]>1+minPathDP[next+1]){
					minPathDP[i]=1+minPathDP[next+1];
					minPathRoute[i]=next+1;
				}		
			}
		}
		return minPathRoute;
	}
	
	private static void getSegmentRes(String sentence,int[] minPathRoute,List<String> res){
		int start=0;
		while(start<minPathRoute.length-1){
			res.add(sentence.substring(start,minPathRoute[start]));
			start=minPathRoute[start];
			//System.out.println(start+" "+(minPathRoute.length-1));
		}
	}
	
	private static void linkComplete(ListArr[] char_list){
		for(int i=0;i<char_list.length;i++)
			char_list[i].linkComplete();
	}
	
	
	private static void add_Start_End_Link(ListArr[] char_list,List<Integer> starts,List<Integer> ends){
		int start,end;
		Iterator<Integer> siter=starts.iterator(),eiter=ends.iterator();
		while(siter.hasNext()){
			start=siter.next();
			end=eiter.next();
			char_list[start].addNext(end);
		}
	}
	
	public static List<String> segment_N_Minimum_Path(String sentence,TrieOperate trieOp){
		char[] chars=sentence.toCharArray();
		ListArr[] char_list=new ListArr[chars.length];
		initListArr(char_list, chars);
		List<Integer> starts=new ArrayList<Integer>(),ends=new ArrayList<Integer>();
		add_Start_End(chars, starts, ends);
		add_Start_End_Link(char_list, starts, ends);
		addWordLink(char_list, trieOp);
		linkComplete(char_list);
		int[] minPathRoute=getMinPath(char_list);		
		List<String> res=new ArrayList<String>();
		getSegmentRes(sentence, minPathRoute, res);
		return res;
	}
	
}
