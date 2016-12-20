import java.util.*;

public class Test {
	private ArrayList<String> test;
	private ArrayList<String> type_criteria;
	private String name_criteria;
	private Hashtable<String, ArrayList<String>> types_map;
	private Hashtable<Character, Integer> names_map;
	private ArrayList<String> result;
	
			
	public Test(ArrayList<String> test, ArrayList<String> type_criteria, String name_criteria){
		this.test = test; 
		this.type_criteria = type_criteria;
		this.name_criteria = name_criteria;
		this.types_map = new Hashtable<String, ArrayList<String>>();
		this.names_map = new Hashtable<Character, Integer>();
		this.result = new ArrayList<String>();
		
		prepare();
		typeArray();
		nameArray();
	}
	
	private void prepare(){
		for(int i=0; i<type_criteria.size(); i++)
			types_map.put(type_criteria.get(i), new ArrayList<String>());
		
		for(int i=0; i<name_criteria.length(); i++)
			names_map.put(name_criteria.charAt(i), i);
		
	}
	
	private void typeArray(){
		for(int i=0; i<test.size(); i++){
			String line_data = test.get(i);
			ArrayList<String> temp = types_map.get(line_data.replace("\t", " ").split("\\s+")[0]);
			temp.add(line_data);
		}
	}
	
	private void nameArray(){
		for(String temp : type_criteria){
			ArrayList<String> lists = types_map.get(temp);
			
			Hashtable<Integer, Integer> temp_map = new Hashtable<Integer, Integer>();
			Hashtable<Integer, String> temp_code = new Hashtable<Integer, String>();
			for(int i=0; i<lists.size(); i++){
				String name = (lists.get(i)).replace("\t", " ").split("\\s+")[1];
				
				int r = transName(name);
				if(r != -1) {
					temp_map.put(lists.get(i).hashCode(), r);
					temp_code.put(lists.get(i).hashCode(), lists.get(i));
				}
			}
			sortByValue(temp_map, temp_code);
		}
	}
	
	private List sortByValue(Hashtable temp_map, Hashtable temp_code) {
        List<String> list = new ArrayList();
        list.addAll(temp_map.keySet());
         
        Collections.sort(list,new Comparator() {
             
            public int compare(Object o1,Object o2) {
                Object v1 = temp_map.get(o1);
                Object v2 = temp_map.get(o2);
                 
                return ((Comparable) v1).compareTo(v2);
            }
             
        });
        Iterator it = list.iterator();
        while(it.hasNext()){
            
        Integer temp = Integer.parseInt(it.next()+"");
            result.add((String) temp_code.get(temp));
        }
        return list;
    }
	
	private int transName(String name) {
		String temp = "";
		for(int i=0; i<name.length(); i++){
			char c = name.charAt(i);
			if(names_map.get(c) == null || names_map.get(c).equals(null)){
				System.out.println(c + "는 규칙에 없는 알파벳입니다.");
				return -1;
			}
			temp += names_map.get(name.charAt(i)) + ""; 
		}
		return Integer.parseInt(temp);
	}
	
	public void print(){
		for(int i=0; i<result.size(); i++){
			System.out.println(result.get(i));
		}
	}

}
