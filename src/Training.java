 import java.util.ArrayList;

public class Training{
	private ArrayList<String> train;
	private ArrayList<String> type_criteria;
	private NameList<Character> name_criteria;
	private ArrayList<String> name_temp;
	
	public Training(ArrayList<String> train){
		this.train = train;
		this.type_criteria = new ArrayList<String>();
		this.name_criteria = new NameList<Character>();
		this.name_temp = new ArrayList<String>();
		
		extract();
		listing(name_temp);
	}
	
	private void extract(){
		String temp1 = "";
		String temp2 = "";
		ArrayList<String> names = new ArrayList<String>();
		
		for(String type : train){
			if(!temp1.equals(type.replace("\t", " ").split("\\s+")[0])){
				if(names.size() != 0) {
					coupling(names);
					names.clear();
				}
				temp1 = type.replace("\t", " ").split("\\s+")[0];
				type_criteria.add(temp1);
			}
			temp2 = type.replace("\t", " ").split("\\s+")[1];
			names.add(temp2);
		}
		coupling(names);
	}
	private void coupling(ArrayList<String> names){
		String pre = names.get(0);
		String next = "";
		
		for(int i=1; i<names.size(); i++){
			next = names.get(i);
			for(int j=0; j<next.length(); j++){
				if(j > 0) {
					if(pre.charAt(j-1) != next.charAt(j-1)) break;
					else {
						if(pre.charAt(j) != next.charAt(j)) {
							name_temp.add(pre.charAt(j) + "" + next.charAt(j));
						}
					}
				} else {
					if(pre.charAt(j) != next.charAt(j)) {
						name_temp.add(pre.charAt(j) + "" + next.charAt(j));
					}
				}
			}
			pre = next;
		}
	}
	
	private void listing(ArrayList<String> name_temp) {
		ArrayList<String> mid = new ArrayList<String>();
		for(String temp : name_temp){
			if(name_criteria.size() != 0) {
				int front = name_criteria.search(temp.charAt(0));
				int back = name_criteria.search(temp.charAt(1));
				
				if(front>=0 && back>=0) {
					if(front > back){
						name_criteria.swap(temp.charAt(0), temp.charAt(1), 0);
					} else{
						continue;
					}
				} else if(front >= 0){
					name_criteria.backInsert(temp.charAt(0), temp.charAt(1));
				} else if(back >= 0){
					name_criteria.frontInsert(temp.charAt(1), temp.charAt(0));
				} else {
					mid.add(temp);
				}
			} else {
				name_criteria.insert(temp.charAt(0));
				name_criteria.insert(temp.charAt(1));
			}
		}
		if(mid.size() != 0) listing(mid);
	}
	
	public ArrayList<String> getType_criteria() {
		return type_criteria;
	}

	public String getName_criteria() {
		return name_criteria.print();
	}
	
	public void print(){
		for(int i=0; i<type_criteria.size(); i++)
			System.out.print(type_criteria.get(i) + "  ");
		System.out.println();
		
		for(int i=0; i<name_criteria.size(); i++)
			System.out.print(name_criteria.get(i));
		System.out.println();
	}
}
