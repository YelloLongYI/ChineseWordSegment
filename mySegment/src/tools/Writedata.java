package tools;
import java.util.*;
import java.io.*;

public class Writedata {
	
	List store=new ArrayList<>();
	
	public Writedata(String path,List feature,boolean mode) throws Exception
	{
		OutputStreamWriter ow=new OutputStreamWriter(new FileOutputStream(path,mode),"UTF-8");
		BufferedWriter bw=new BufferedWriter(ow);
		String temp;
		Iterator iter=feature.iterator();
		while(iter.hasNext())
		{
			bw.write(iter.next()+"\r\n");
		}
		bw.close();
	}
	
	public Writedata(){}
	
	public void WriteStore(String path) throws Exception
	{
		OutputStreamWriter ow=new OutputStreamWriter(new FileOutputStream(path,false),"UTF-8");
		BufferedWriter bw=new BufferedWriter(ow);
		String temp;
		Iterator iter=store.iterator();
		while(iter.hasNext())
		{
			bw.write(iter.next()+"\r\n");
		}
		bw.close();
	}
	
	public Writedata(String path,List feature,boolean mode,boolean line) throws Exception
	{
		//******写在一行上****//
		OutputStreamWriter ow=new OutputStreamWriter(new FileOutputStream(path,mode),"UTF-8");
		BufferedWriter bw=new BufferedWriter(ow);
		String temp;
		Iterator iter=feature.iterator();
		while(iter.hasNext())
		{
			bw.write(iter.next()+" ");
		}
		bw.write("\r\n");
		bw.close();
	}
	
	
	public Writedata(String path,List feature) throws Exception
	{
		OutputStreamWriter ow=new OutputStreamWriter(new FileOutputStream(path,false),"UTF-8");
		BufferedWriter bw=new BufferedWriter(ow);
		String temp;
		Iterator iter=feature.iterator();
		while(iter.hasNext())
		{
			bw.write(iter.next()+"\r\n");
		}
		bw.close();
	}
}
