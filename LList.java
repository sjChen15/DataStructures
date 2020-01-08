//LList.java
//Jenny Chen
//Make methods for the Linked List Assignment


class LNode{
	private int val; //the value that the LNode holds
	private LNode next;	//the next LNode after this LNode in the LList
	private LNode last;	//the last LNode before this LNode in the LList
	
	//LNode constructor
	//takes the LNode before and after and the value this LNode holds
	public LNode(LNode b, int v, LNode n){
		//set the values to their respective fields
		val = v;
		next = n;
		last = b;
	}
	//returns the value the LNode holds
	public int getVal(){
		return val;
	}
	//returns the LNode this LNode is pointing towards
	public LNode getNext(){
		return next; 
	}
	//returns the LNode behind this LNode
	public LNode getLast(){
		return last;
	}
	//takes an int v and sets the value of the LNode to v
	public void setVal(int v){
		val = v;
	}
	//takes an LNode n and sets the next LNode after this one as n
	public void setNext(LNode n){
		next = n;
	}
	//takes an LNode n and sets the last LNode before this one as n
	public void setLast(LNode n){
		last = n;
	}
	//returns the value in the LNode as a string
	public String toString(){
		return "{"+val+"}";
	}
}

class LList{
	private LNode head; //the first LNode in the LList
	private LNode tail;	//the last LNode in the LList
	
	//LList constructor
	//makes an empty LList
	public LList(){
		//set head and tail as null 
		head = null;
		tail = null;
	}
	//takes a value v and adds it to the front of the LList
	public void add(int v){
		LNode temp = new LNode(null,v,head); //temp is the LNode that is to be added
		
		if(head == null){ //check if the LList is empty
			tail = temp;
		}
		else{
			head.setLast(temp);
		}
		head = temp;
	}
	//deletes the first LNode in the LList and returns its value
	public int pop(){
		int val = head.getVal();	//val is the value in the LNode
		if(head == tail){	//check if there is only one item in the LList
			head = null;
			tail = null;
			return val;
		}
		head = head.getNext();
		head.setLast(null);
		return val;
	}
	//adds a value to the front of the LList
	public void push(int val){
		add(val);//does the same thing as add
	}
	//adds a value to the back of the LList
	public void enqueue(int v){
		if(head == tail && head == null){	//check if there are no LNodes in the LList
			add(v);
		}
		else{
			LNode tmp = new LNode(tail,v,null);	//tmp is the new LNode to be added 
			tail.setNext(tmp);
			tail = tmp;
		}	
		
	}
	public LNode getHead(){
		return head;
	}
	//deletes the first LNode in the LList and returns its value
	public int dequeue(){
		//does the same thing as pop
		return pop();
	}
	//returns the LList in a string form
	public String toString(){
		LNode tmp = head;	//tmp will go through all the LNodes in the LList
		String ans = "";	//ans is the string that will be returned
		while(tmp!=null){	
			ans+=tmp;
			tmp = tmp.getNext();
		}
		return ans;
	}
	//delete will delete an LNode n
	public void delete(LNode n){
		if(head == n && tail == n){ //check if n is the only LNode in the LList
			head = null;
			tail = null;
		}
		else if(n.getLast() == null){ //check if n is the first LNode in the LList
			(n.getNext()).setLast(null);
			head = n.getNext();
		}
		else if(n.getNext() == null){ //check if n is the last LNode in the LList
			(n.getLast()).setNext(null);
			tail = n.getLast();
		}
		else{
			LNode last = n.getLast();
			LNode next = n.getNext();
			last.setNext(next);
			next.setLast(last);
		}
	}
	//override delete to delete the first LNode with a a value of n
	public void delete(int n){
		LNode tmp = head;	//the LNode that will go through the LList
		while(tmp.getVal()!= n){
			tmp = tmp.getNext();
		}
		delete(tmp);	
	}
	//deletes an LNode at a position pos
	public void deleteAt(int pos){
		LNode n = head;	//the LNode that will go through the LList
		//first LNode is position 0
		for(int i = 0; i<pos; i++){
			n = n.getNext();
		}
		delete(n);
	}
	//takes a value i and inserts it into a sorted LList
	//the LList is sorted from largest to smallest value
	public void sortedInsert(int i){
		if(head == tail && head == null){	//check if the LList is empty
			add(i);
		}
		else{
			LNode tmp = head;	//the LNode that will go through the LList
			while(true){	
				if(tmp == head && i>=tmp.getVal()){	//check if i is the largest value 
					add(i);
					break;
				}
				else if(tmp == tail && i<=tmp.getVal()){//check if i is the smallest value
					enqueue(i);
					break;
				}
				else if(i<=tmp.getVal() && i>tmp.getNext().getVal()){//check if i belongs in between two values
					LNode n = new LNode(tmp,i,tmp.getNext());	//makes the new LNode
					tmp.setNext(n);
					tmp.getNext().setLast(n);
					break;
					
				}
				tmp = tmp.getNext();
			}	
		}
		
	}
	//removes repeating values in the LList
	public void removeDuplicates(){
		if(head!=tail){	//makes sure that there is more than one value in the LList
			LNode n = head;	//the LNode that compare will be compared to
			LNode compare = n.getNext();//the LNode that will go through the LNodes after n to compare if they have equal values
			while(true){
				if(n.getNext() == null){//if the whole list has been gone through
					break;
				}
				else if(compare == null){//if compare has compared all values to n
					n = n.getNext();
					compare = n.getNext();
				}
				else if(n.getVal() == compare.getVal()){
					LNode tmp = compare;
					compare = compare.getNext();
					delete(tmp);
				}
				else{
					compare = compare.getNext();
				}
				
			}
		}
	}
	//reverses the order of the values in the LList
	public void reverse(){
		if(head!=tail){
			LNode set = tail;//the LNode that will be the head of the reversed LList
			while(true){
				if(set.getLast() == head){ 
					int val = head.getVal(); //val is the value that will be moved to the end of the LList
					delete(head);
					enqueue(val);
					break;
				}
				int val = set.getLast().getVal(); //the value that will be moved to the back of the LList
				delete(set.getLast());
				enqueue(val);			
			}
		}
	}
	//returns a new LList that is a copy of the current LList
	public LList clone(){
		LList nNodes = new LList(); //the copy of the old LList
		LNode clone = head;	//clone will go through the current LList to get values for the new one
		nNodes.add(clone.getVal());
		clone = clone.getNext();
		while(clone!=null){
			nNodes.enqueue(clone.getVal());
			clone = clone.getNext();
		}
		return nNodes;
	}
}
	

class LTest{
	public static void main(String[]args){
		LList grades = new LList();
		grades.add(70);
		grades.add(50);
		grades.add(100);
		System.out.println(grades);
		grades.deleteAt(0);
		System.out.println(grades);
	}
}
	