import java.util.*;
public class LinkedListDriver{
	public static void main(String[] args) {
		LinkedList list = new SortedDoublyLinkedList();
		
		System.out.println(list);
		Warrior krogg = new Warrior("Krogg", 30, 50, 200);
		list.insert(krogg);

		System.out.println(list);
		Warrior gurkh = new Warrior("gurkh", 40, 45, 180);
		list.insert(gurkh);

		System.out.println(list);
		Warrior brynn = new Warrior("brynn", 45, 40, 190);
		list.insert(brynn);

		System.out.println(list);
		Warrior dolf = new Warrior("dolf", 20, 65, 210);
		list.insert(dolf);

		System.out.println(list);
		Warrior zuni = new Warrior("zuni", 50, 35, 170);
		list.insert(zuni);

		System.out.println(list);
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
	//constructor for SortedDoublyLinkedList
	public SortedDoublyLinkedList(){
		this.head = new Node(null,0);//clear Node head and make equal to null
		this.tail = new Node(null, 0);//clear Node tail and make equal to null
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
		}else if(temp.speed > head.speed){
			addFront(temp);
			size++;
		}else{
			addLast(temp);
			size++;
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
