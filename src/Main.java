import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		//read file
		String filepath = "./file/test3.txt";
		ReadFile data = new ReadFile(filepath);
		
		//bring data
		ArrayList<String> train = data.getTrain();
		ArrayList<String> test = data.getTest();
		String filename = data.getFilename();
		
		//search criteria
		Training analysis = new Training(train);
		ArrayList<String> type_criteria = analysis.getType_criteria();
		String name_criteria = analysis.getName_criteria();

		//array test data
		Test evaluation = new Test(test, type_criteria, name_criteria); 
		
		//print result
		System.out.println(filename);
		System.out.println("Criteria----");
		analysis.print();
		System.out.println("Sorted result----");
		evaluation.print();
		
		
	}

}
