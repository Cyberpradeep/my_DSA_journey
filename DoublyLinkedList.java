package DSA;

import java.util.Iterator;

// generics
public class DoublyLinkedList<T> implements Iterable<T>{
	Node head;
	Node tail;
	// node creation
	class Node{
		
		T data;
		Node prev;
		Node next;
		
		Node(T val){
			data=val;
			next=null;
			prev=null;
		}
	}
	
	DoublyLinkedList(){
		head=null;
		tail=null;
		
	}
	
	// insert at beginning
	public void insertAtBegining(T val) {
		Node newNode=new Node(val);
		
		//list is empty
		if(head==null) {
			head=newNode;
			tail=newNode;
		}
		else {  // list is not empty
			head.prev=newNode;
			newNode.next=head;
			head=newNode;
			
		}
		
	}
	
	// Traverse 
	public void display() {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	public void displayReverse() {
		if(head==null) {
			System.out.println("List is Empty");
			return;
		}
		Node temp=tail;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.prev;
		}
	}
	
	// insert At position
	public void insertAtPos(int pos,T val) {
		if(pos==0) {
			insertAtBegining(val);
			return;
		}
		
		Node newNode = new Node(val);
		Node temp=head;
		for(int i=1;i<pos;i++) {
			temp=temp.next;
			if(temp==null) {
				throw new IllegalArgumentException("Invalid Position " +pos);
			}
		}
		
		newNode.next=temp.next;
		newNode.prev=temp;
		
		if(temp==tail) {
			tail=newNode;
		}
		else 
			temp.next.prev=newNode;
			
		temp.next=newNode;
	}
	
	// delete At position
	public void deleteAtPos(int pos) {
		if(head==null) {
			throw new IndexOutOfBoundsException("List is empty");
		}
		if(pos==0) {
			head=head.next;
			if(head==null)
				tail=null;
			else
				head.prev=null;
			return;
		}
		Node temp=head;
		Node prev=null;
		for(int i=1;i<=pos;i++) {
			prev=temp;
			temp=temp.next;
			if(temp==null)
				throw new IndexOutOfBoundsException("Invalid position");

		}
		prev.next=temp.next;
		if(temp.next==null)
			tail=prev;
		else
			temp.next.prev=prev;
	}
	
	// delete At beginning
	public void deleteAtBeginning() {
		if(head==null) {
			throw new IndexOutOfBoundsException("List is empty");
		}
		head=head.next;
		if(head==null)
			tail=null;
		else
			head.prev=null;
		return;
	}
	
	
	
	public Iterator<T> iterator(){
		return new Iterator<T>() {
			Node temp=head;
		public boolean hasNext() {
			return temp!=null;
		}
		public T next() {
			T val  = temp.data;
			temp=temp.next;
			return val;
		}
	};
	}
	

}
