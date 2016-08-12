package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Util {
	public static String fileToString(File file,String encoding) throws IOException{
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream in = new FileInputStream(file);
		in.read(fileContent);
		in.close();
		return new String(fileContent,encoding);
	}
	
	public static String fileToString(String filePath,String encoding) throws IOException{
		File file = new File(filePath);
		return fileToString(file,encoding);
	}
	
	public static String fileToString(String filePath) throws IOException{
		return fileToString(filePath,"UTF-8");
	}
}
