package DSA;

import java.util.Iterator;

// generics
public class LinkedList<T> implements Iterable<T>{
	Node head;
	
	// node creation
	class Node{
		
		T data;
		Node next;
		
		Node(T val){
			data=val;
			next=null;
		}
	}
	
	LinkedList(){
		head=null;
		
	}
	
	// insert at beginning
	public void insertAtBegining(T val) {
		Node newNode=new Node(val);
		
		//list is empty
		if(head==null) {
			head=newNode;
		}
		else {  // list is not empty
			newNode.next=head;
			head=newNode;
		}
		
	}
	
	// Traverse 
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
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
		temp.next=newNode;
	}
	
	// delete At position
	public void deleteAtPos(int pos) {
		if(head==null) {
			throw new IndexOutOfBoundsException("List is empty");
		}
		if(pos==0) {
			head=head.next;
			return;
		}
		Node temp=head;
		Node prev=null;
		for(int i=1;i<=pos;i++) {
			prev=temp;
			temp=temp.next;
		}
		prev.next=temp.next;
	}
	
	// delete At beginning
	public void deleteAtBeginning() {
		if(head==null) {
			throw new IndexOutOfBoundsException("List is empty");
		}
		head=head.next;
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
	
	public void reverse() {
		Node prev=null;
		Node current=head;
		Node next=head.next;
		
		while(current!=null) {
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
	}
}
