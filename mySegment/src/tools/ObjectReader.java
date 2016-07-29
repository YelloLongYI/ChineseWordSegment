package tools;
import java.io.*;
import java.util.*;

public class ObjectReader<T> {
	
	String path;
	
	public ObjectReader(String path){
		this.path=path;
	}
	
	public List<T> GetData() throws Exception{
		List<T> feature=new ArrayList<T>();
		ObjectInputStream or=new ObjectInputStream(new FileInputStream(path));
		T read;
		try{
			while(true){
				read=(T)or.readObject();
				feature.add(read);
			}
		}catch(EOFException e){
			
		}finally{
			or.close();
		}
		return feature;
//		List<String> feature=new ArrayList<String>();
//		FileInputStream fis=new FileInputStream(datapath);
//		UnicodeReader uis=new UnicodeReader(fis,code);
//		BufferedReader br=new BufferedReader(uis);
//		String s;
//		while((s=br.readLine())!=null)
//			feature.add(s);
//		return feature;
	}
}
