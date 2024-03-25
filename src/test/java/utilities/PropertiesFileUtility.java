package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtility 
{
	public static String getValuesFromPropertiesFile(String propertieName)throws Exception
	{
		File files=new File("src\\test\\resources\\PropertiesFiles\\config.properties");
		FileInputStream  fi = new FileInputStream(files);
		Properties p = new Properties();
		String valueString="";
		try 
		{
			p.load(fi);
			valueString=p.getProperty(propertieName);
			fi.close();
			
		} catch (Exception e) 
		{
			e.getMessage();
		}
		return valueString;
		
	}

}
