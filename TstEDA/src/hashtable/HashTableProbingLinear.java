package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class HashTableProbingLinear {
	
	private static HashTable hashTable;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		hashTable = new HashTable(size);
		menu(sc);
	}
	
	private static void menu(Scanner sc) {
		String op = sc.nextLine();
		while (!op.toLowerCase().trim().equals("end")) {
			String[] array = op.split(" ");
			switch(array[0].toLowerCase().trim()) {
				case "keys":
					keys();
					break;
				case "values":
					values();
					break;
				case "put":
					put(array[1], array[2]);
					break;
				case "remove":
					remove(array[1]);
			}
			op = sc.nextLine();
		}
	}

	private static void keys() {
		System.out.println(hashTable.getKeys());
		
	}

	private static void values() {
		System.out.println(hashTable.getValues());
		
	}

	private static void remove(String key) {
		hashTable.remove(Integer.parseInt(key));
		System.out.println(hashTable.toString());
	}

	private static void put(String key, String value) {
		hashTable.add(Integer.parseInt(key), value);
		System.out.println(hashTable.toString());
	}

}

class HashTable {
	private int size;
	private int elements;
	private Pair[] table;
	
	public HashTable(int size) {
		this.size = size;
		this.table = new Pair[size];
		this.elements = 0;
	}
	
	private int hash(int key) {
		return key % this.getSize();
	}
	
	private int hash(int key, int probe) {
		int out = 0;
		
		if (this.size > 0)
			out = (this.hash(key) + probe) % this.getSize();
		
		return out;
	}
	
	public boolean isEmpty() {
		return this.getElements() == 0;
	}
	
	public boolean isFull() {
		return this.getSize() == this.getElements();
	}

	public int getSize() {
		return size;
	}
	
	public int getElements() {
		return elements;
	}
	
	public void add(int key, String value) {
		if (value != null && !value.trim().isEmpty() && key >= 0) {
			Pair newPair = new Pair(key, value);
			int hash = this.hash(key, 0);
			
			if (!this.isFull()) {
				int i = 0;
				
				while (this.table[hash] != null && !this.table[hash].equals(newPair) 
						&& i < this.getSize())
					hash = this.hash(newPair.getKey(), ++i);
				
				if (this.table[hash] == null)
					this.elements++;
				
				this.table[hash] = newPair;
			} else {
				for (Pair p: this.table) {
					if (p.equals(newPair))
						p.setValue(value);
				}
			}
		}
	}
	
	public void remove(int key) {
		if (key >= 0 && !this.isEmpty()) {
			int hash = this.hash(key, 0);
			int i = 0;
			
			while (i < this.getSize()) {
				if (this.table[hash] != null && this.table[hash].getKey() == key)
					break;
				
				hash = this.hash(key, ++i);
			}
			
			if (this.table[hash] != null && this.table[hash].getKey() == key) {
				this.table[hash] = null;
				this.elements--;
			}
		}
	}
	
	public String getKeys() {
		Set<Integer> setKeys = new HashSet<>();
		
		if (!this.isEmpty()) {
			for (Pair p: this.table) {
				if (p != null)
					setKeys.add(p.getKey());
			}
		}
		
		Object[] out = setKeys.toArray();
		Arrays.sort(out);
		return Arrays.toString(out);
	}
	
	public String getValues() {
		List<String> listValues = new ArrayList<>();
		
		if (!this.isEmpty()) {
			for (Pair p: this.table) {
				if (p != null)
					listValues.add(p.getValue());
			}
		}
		
		Collections.sort(listValues);
		return Arrays.toString(listValues.toArray());
	}

	@Override
	public String toString() {
		return Arrays.toString(this.table);
	}
}

class Pair implements Comparable<Pair> {
	
	private int key;
	private String value;
	
	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "<" + this.key + ", " + this.value + ">";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return this.key == other.getKey();
	}

	@Override
	public int compareTo(Pair otherPair) {
		return Integer.compare(this.key, otherPair.key);
	}
}