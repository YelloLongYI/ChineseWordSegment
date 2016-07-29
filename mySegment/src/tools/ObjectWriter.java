package tools;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class ObjectWriter<T> {
	public ObjectWriter(String path,List<T> feature) throws Exception
	{
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(path,false));
		Iterator<T> iter=feature.iterator();
		T write;
		while(iter.hasNext()){
			write=(T)iter.next();
			out.writeObject(write);
			//System.out.println(write);
		}
		out.close();
	}
}
