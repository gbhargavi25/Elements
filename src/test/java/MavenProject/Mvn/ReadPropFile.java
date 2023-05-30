package MavenProject.Mvn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

	public static void main(String[] args) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("\\Users\\Satyadurga\\eclipse-workspace\\Mvn\\src\\test\\java\\MavenProject\\Mvn\\config.properties");
		
		prop.load(fis);
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("Name"));// prints null as key value is mismatched with config.properties
	}
	

}
