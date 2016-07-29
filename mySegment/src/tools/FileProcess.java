package tools;
import java.io.*;

public class FileProcess {
	
	public static void cleardirectory(String path) throws Exception
	{
		File[] files=new File(path).listFiles();
		for(File file:files)
		{
			if(file.exists())
				file.delete();
		}
	}
	
	public static void DirectoryCopy(String olddirectory,String newdirectory)
	{
		try
		{
			File[] files=new File(olddirectory).listFiles();
			for(File file:files)
			{
				if(file.exists())
				{
					FileCopy(olddirectory+file.getName(),newdirectory+file.getName());
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void FileCopy(String oldpath,String newpath) 
	{
		int byteread=0;

		try
		{
			File oldfile=new File(oldpath);
			if(oldfile.exists())
			{
				//System.out.println(oldfile.getName()+"  "+oldfile.length());
				InputStream is=new FileInputStream(oldpath);
				OutputStream os=new FileOutputStream(newpath);
				byte[] buffer=new byte[2];
				while((byteread=is.read(buffer))!=-1)
				{
					os.write(buffer, 0, byteread);
				}
				os.close();
				is.close();
			}
		}catch(Exception e)
		{
			System.out.println("error");
			e.printStackTrace();
		}
		
	}
	
}
