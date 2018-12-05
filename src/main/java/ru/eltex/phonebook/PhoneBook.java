//package ru.eltex.phonebook;

import  java.util.*;

public class PhoneBook{
	public static void main(String[] argv){
		System.out.println("ArrayList");
		testingTime(new ArrayList<Integer>());
		
		System.out.println("\nLinkedList");
		testingTime(new LinkedList<Integer>());
		
		System.out.println("\nTreeSet");
		testingTime(new TreeSet<Integer>());
		
	}
	public static void fillArray(Collection<Integer> array) {
		for(int i = 0; i < 1000000; i++) {
			array.add(i);
		}
	}
	
	public static void testingTime(Collection<Integer> array) {
		fillArray(array);
		long start = System.nanoTime();
		array.add(1000001);
		long finish = System.nanoTime();
		System.out.println("Adding " + (finish - start) / 1000000000.0);
		
		start = System.nanoTime();
		array.remove(1000001);
		finish = System.nanoTime();
		System.out.println("Remove " + (finish - start) / 1000000000.0);
	}
}