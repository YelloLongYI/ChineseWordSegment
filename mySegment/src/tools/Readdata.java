package tools;
import java.util.*;
import java.io.*;




//public class Readdata {
//	String datapath;
//	String code;
//	public Readdata(String datapath,String code)
//	{
//		this.datapath=datapath;
//		this.code=code;
//	}
//	public List<String> GetData() throws Exception
//	{
//		List<String> feature=new ArrayList<String>();
//		InputStreamReader ir=new InputStreamReader(new FileInputStream(datapath),code);
//		BufferedReader br=new BufferedReader(ir);
//		String s;
//		while((s=br.readLine())!=null)
//			feature.add(s);
//		return feature;
//	}
//}

public class Readdata {
	String datapath;
	String code;
	public Readdata(String datapath,String code)
	{
		this.datapath=datapath;
		this.code=code;
	}
	public List<String> GetData() throws Exception
	{
		
		//***********UnicodeReader±‹√‚BOM∏…»≈************//
		List<String> feature=new ArrayList<String>();
		FileInputStream fis=new FileInputStream(datapath);
		UnicodeReader uis=new UnicodeReader(fis,code);
		BufferedReader br=new BufferedReader(uis);
		String s;
		while((s=br.readLine())!=null)
			feature.add(s);
		return feature;
	}
}
