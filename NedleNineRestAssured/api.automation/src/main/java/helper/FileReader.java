package helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {
	
	public Properties loadPrperties(String fileName, String folder ) throws IOException {
		String path = System.getProperty("user.dir") + File.separator + folder + File.separator + fileName +".properties";
		File file = new File(path);
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		return prop;	
	}

}
