import java.util.Random;
import java.util.*;
public class ComparisonDriver{
	public static void main(String[] args) {
		SortedDoublyLinkedList list = new SortedDoublyLinkedList();
		SortedArray array = new SortedArray();

		for (int i=0; i< 100; i++) {
			Warrior newWarrior = new Warrior("Generic", genStat(50),genStat(50),genStat(200));
			list.insert(newWarrior);
			array.insert(newWarrior);
		}
		System.out.println("Linked List assignmentCount: " + list.assignmentCount);
		System.out.println("Sorted Array assignmentCount: " + array.assignmentCount);
	}
	public static int genStat(int max){
			Random rand = new Random();
			return rand.nextInt(max) + 1;
		}
}
class Warrior{
	private String name;
	private int speed;
	private int strength;
	private int hp;
	public Warrior(String name, int speed, int str, int hp){
		this.name = name;
		this.speed = speed;
		this.strength = strength;
		this.hp = hp;
	}
	public String getName(){return this.name;}
	public int getSpeed(){return this.speed;}
	public int getStrength(){return this.strength;}
	public int getHp() {return this.hp;}
	public String toString(){
		return this.name + "(" + this.speed + ")";
	}
}
//don't need to touch this class
//Interface for Linked list to be used later on
interface LinkedList{
	void insert(Warrior warrior);//Will be used in the SortedDoublyLinkedList
	String toString();//toString will be called in sorted DoublyLinkedList
}
class SortedDoublyLinkedList implements LinkedList{
	class Node{
		String name;//declare name
		int speed;//declare speed
		Node prev;//declare Node prev reference to be used later
		Node next;//declare Node next reference to be used later
		//Node class constructor sets the instance values of name and speed
		public Node(String name, int speed){
			this.name = name;
			this.speed = speed;
		}
		//getters
		public int getSpeed(){return speed;}//Retrieves the value speed
		public String getName(){return name;}//Retrieves the value name
		//setters
		
		public void setName(){this.name = name;}
		public Node setPrev(){return this.prev = prev;}//sets the instance of prev equal to var prev
		public Node setNext(){return this.next = next;}//sets the instance of next equal to var next
	}
	private Node head;//Delare the head of the dll
	private Node tail;//Declare the tail of the dll
	private int size = 0;//set the size equal to zero
	public int assignmenCount = 0;	//declare the instance var for assignmentCount so that it can be accessed outside of the class
	//constructor for SortedDoublyLinkedList
	public SortedDoublyLinkedList(){
		this.head = new Node(null,0);//clear Node head and make equal to null
		this.tail = new Node(null, 0);//clear Node tail and make equal to null
		this.assignmentCount = assignmentCount;
	}
	public void increaseAssignment(){
		assignmentCount+=1;
	}
	//Method for checking if the list is empty
	public boolean isEmpty(){return size == 0;}
	//Method for adding Node to the front of the list
	public void addFront(Node temp){
		temp.next = head;
		head.prev = temp;
		head = temp;
	}
	//Methods for adding the Node to the end of the list
	public void addLast(Node temp){
		tail.next = temp;
		temp.prev = head;
		tail = temp;
	}

	//This method is from the linkedlist interfece and calls the other methods 
	//to insert the nodes into the list
	public void insert(Warrior warrior){
		SortedDoublyLinkedList.Node temp = new SortedDoublyLinkedList.Node(warrior.getName(), warrior.getSpeed());
		if(isEmpty()){
			head = temp;
			tail = temp;
			size++;
			increaseAssignment();
		}else if(temp.speed > head.speed){
			addFront(temp);
			size++;
			increaseAssignment();
		}else{
			addLast(temp);
			size++;
			increaseAssignment();
		}
	}
	//This method allows for the the outputted sorted list to be 
	//outputted to the screen
	public String toString(){
		String outPuttext = "";
		SortedDoublyLinkedList.Node start = head;
		if(isEmpty()){
			outPuttext = "List is Empty";
		}else{
			while(start != null){
				outPuttext+= start.name + ": " + start.speed + " ";
				start = start.next;
			}
		}
		return outPuttext;
	}
}
class SortedArray{
	//declare the instance var for assignmentCount so that it can be accessed outside of the class
	public int assignmentCount;
	public SortedArray(){
		this.assignmentCount = assignmentCount;//set assignmentCount
	}
	//This method goes through and increases the assignment count var
	public void increaseAssignment(){
		assignmentCount+=1;
	}
	public void insert(Warrior warrior){
		Warrior temp = new Warrior(warrior.getName(), warrior.getSpeed(), warrior.getStrength(), warrior.getHp());
		ArrayList<Warrior> array = new ArrayList<Warrior>();
		if(array.size() == 0){
			System.out.println("Empy array");
			increaseAssignment();
		//This line is supposed to check if the current version of Warrior objects speed is greater than the front of it
		}else if(temp.getSpeed() > (array.get(0.getSpeed())){
			array.add(0,temp);//adds to the front of the array and shifts values by 1
			increaseAssignment();//increases the assignment counter had to put it in a method because it wasn't liking it when debugging not in method
		}else{
			array.add(temp);//auto adds to the end of the array
			increaseAssignment();
		}	
	}
}
//I ran out of time when debugging the program as the midterm is tommorrrow