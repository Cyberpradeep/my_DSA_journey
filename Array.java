// Lit Implementation using Array


package DSA;

import java.util.*;

class DynamicArray<T>{  // generic datatype we can assign data type during object creation 
	
	
	static final int initialCapacity=16;     // constant => final  and static variable 
	
	private T[] arr;
	private int size, capacity;
	
	
	@SuppressWarnings("unchecked")
	DynamicArray(){
		size=0;
		arr=(T[])new Object[initialCapacity];
		capacity=initialCapacity;
	}
	
	// add function
	public void add(T val) {
		if(size==capacity) {
			expandArray();
		}
		arr[size++]=val;
		
	}
	
	// Creating Dynamic array
	private void expandArray() {
		capacity *=2;
		arr=java.util.Arrays.copyOf(arr, capacity);
	}
	
	
	//display
	public void display() {
		System.out.println("Items");
		for(int i=0;i<size;i++) {
			
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	// insert at position
	public void insertAtPos(int pos, T val) {
		if(size==capacity) {
			expandArray();
		}
		for(int i=size-1;i>=pos;i--) {
			arr[i+1]=arr[i];
		}
		arr[pos]=val;
		size++;
	}
	
	
	// delete at position
	public void delete(int pos) {
		for(int i=pos+1;i<size;i++) {
			arr[i-1]=arr[i];
		}
		size--;
		
		if(capacity>initialCapacity && capacity>3*size)
			shrinkArray();
	}
	
	// Shrink array
	public void shrinkArray() {
		capacity /=2;
		arr=java.util.Arrays.copyOf(arr,capacity);
	}
	public int length() {
		return size;
	}
	
	//Search
	
	public int search(T val) {
		int index=0;
		for(int i=0;i<size;i++) {
			if(arr[i]==val) {
				index=i;
			}
			break;
		}
		return index;
	}
}



public class Array {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		DynamicArray<Integer> list = new DynamicArray<>();
		int val,pos;
		while(true) {
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(" 1=> Insert at end");
			System.out.println(" 2=> Display");
			System.out.println(" 1=> instert at specified position");
			System.out.println(" 1=> delete at specified position");
			System.out.println(" 1=> exit");
			
			System.out.println("Enter your choice:");
			int n = in.nextInt();
			System.out.println("-----------------------------------------------------------------------------");
			switch(n) {
			case 1: 
				System.out.println(" enter the value");
				 val = in.nextInt();
				list.add(val);
				break;
			case 2:
				list.display();
				break;
			case 3:
				System.out.println("Enter the position:");
				pos = in.nextInt();
				System.out.println("Enter the value:");
				val=in.nextInt();
				list.insertAtPos(pos,val);
				break;
			case 4:
				System.out.println("Enter the position:");
				pos = in.nextInt();
				list.delete(pos);
				break;
			case 5:
				System.out.println("Enter the value to search");
				val=in.nextInt();
				System.out.println(list.search(val));
				breaj;
			case 6:
				System.exit(0);
			default:
				System.out.println("Enter the valid choice:");
			}

		}
	}

}
