import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingFile {

	public static void main(String[] args) {
		String strLine = "";
		String filePath = "/Users/chukka/Desktop/Java/library/Dictionary";
		FileInputStream fstream = null;
		BufferedReader br = null;

		if (doesFileExists(filePath)) {
			System.out.println(" File Exist!!!");

			try {

				fstream = new FileInputStream(filePath);
				br = new BufferedReader(new InputStreamReader(fstream));
				while ((strLine = br.readLine()) != null) {
					//split the contents and print as Dictionary meaning
					
					//String[] strContents = strLine.split("( - )");
					String[] strContents = strLine.split("(?<=[-,])");
					for(String str : strContents ) {
						System.out.println(str.replaceAll("[-,]",""));
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) { 
					try { 
							br.close(); 
						} 
					catch(Throwable t) { 
						} 
					}
			}
		} else {
			System.out.println("OOPS, File Does Not Exist!!!");
		}
	}
	
	static boolean doesFileExists(String filePath) {
		File file = new File(filePath);
		boolean exists = file.exists();
		return exists;
	}
	
}








