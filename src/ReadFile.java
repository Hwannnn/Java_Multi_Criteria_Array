import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	private String filepath;
	private String filename;
	private ArrayList<String> train;
	private ArrayList<String> test;
	
	public ReadFile(String filepath){
		this.filepath = filepath;
		this.filename = filepath.split("/")[2];
		this.train = new ArrayList<String>();
		this.test = new ArrayList<String>();
		
		readData();
	}
	
	public void readData(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			String name_list = br.readLine();
			
			String s = "";
			int n = 0;
			while ((s = br.readLine()) != null) {
				if(s.equals("End") || s == "End" || s.equals("end") || s == "end") n++;
				else {
					if(n == 0) train.add(s);
					else test.add(s);
				}				
			}
			br.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
	
	public ArrayList<String> getTrain() {
		return this.train;
	}

	public ArrayList<String> getTest() {
		return this.test;
	}
	
	public String getFilename() {
		return this.filename;
	}

}

