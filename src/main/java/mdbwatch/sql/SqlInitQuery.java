package mdbwatch.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.Scanner;

public class SqlInitQuery {
	
	public static String[] getQueryInit() {
		FileReader fl;
		try {
			File generator = new File(ClassLoader.getSystemResource("files//sqlGenerator.txt").toURI());
			fl = new FileReader(generator);
			Scanner ln = new Scanner(fl);
			String str = "";
			while(ln.hasNext()) {
				str = String.join("", str, ln.nextLine());
			}
			ln.close();
			String [] parts = str.split(";");
			return parts;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	return null;
	}
}
