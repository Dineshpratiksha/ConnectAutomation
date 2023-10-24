package SBV_utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Utils {
	
	public static String File_Name="./TestData/config.properties";
	
	public static Properties properties=null;
	
	static {
		File f=new File(File_Name);
		properties=new Properties();
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			properties.load(in);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getFileProperty(String strKey) {
		String strValue= null;
		try {
			File f=new File(File_Name);
			if(f.exists()) {
				strValue= properties.getProperty(strKey);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return strValue;
		
	}
}
