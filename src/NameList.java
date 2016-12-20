
public class NameList<T>{
	private int size;
	private Node header;
	
	public NameList(){
		this.header = null;
		size = 0;
	}
	
	private class Node<T>{
		private T data;
		private Node next;
		
		Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public int search(T x){
		if(size == 0){
			System.out.println("empty");
		} else {
			Node<T> temp = header;
			int n = 0;
			while(temp != null){
				if(temp.data == x) return n;
				temp = temp.next;
				n++;
			}
		}
		return -1;
	}
	
	public void insert(T x){
		if(header == null){
			header = new Node(x, header);
			size++;
		} else {
			header.next = new Node(x, header.next);
			size++;
		}
		
		
	}
	
	public void backInsert(T c, T x){
		Node<T> temp = header;
		
		while(temp != null){
			if(temp.data == c){
				temp.next = new Node(x, temp.next);
				size++;
				return;
			}
			temp = temp.next;
		}
	}
	
	public void frontInsert(T c, T x){
		Node<T> temp = header;

		while(temp != null){
			if(temp.data == c){
				char t = (char) temp.data;
				temp.data = x;
				temp.next = new Node(t, temp.next);
				size++;
				return;
			}
			temp = temp.next;
		}
	}
	
	public void swap(T a, T b, int n){
		if(n == 2) return;
		
		Node<T> temp = header;
		while(temp != null){
			if(temp.data == a){
				temp.data = b;
				break;
			}
			temp = temp.next;
		}
		
		swap(b, a, ++n);
	}
	
	public int size(){
		return this.size;
	}
	
	public T get(int n){
		Node<T> temp = header;
		String names = "";
		
		if(n == 0) return temp.data;
		else {
			for(int i=0; i<n; i++) temp = temp.next;
			return temp.data;
		}
		
		
	}
	
	public String print(){
		Node<T> temp = header;
		String names = "";
		while(temp!=null){
			names += temp.data;
			temp = temp.next;
		}
		return names;
	}
	
}
