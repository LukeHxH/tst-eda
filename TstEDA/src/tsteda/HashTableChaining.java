package tsteda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class HashTableChaining {
	
	private static TabelaHash hashTable;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		hashTable = new TabelaHash(size);
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
					System.out.println(hashTable.toString());
					break;
				case "remove":
					remove(array[1]);
					System.out.println(hashTable.toString());
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
	}

	private static void put(String key, String value) {
		hashTable.put(Integer.parseInt(key), value);
	}

}
class TabelaHash {
	private int size;
	private LinkedList<Pair>[] table;
	private Set<Integer> keys;
	private List<String> values;
	
	@SuppressWarnings("unchecked")
	public TabelaHash(int size) {
		this.size = size;
		this.table = new LinkedList[size];
		this.keys = new HashSet<Integer>();
		this.values = new ArrayList<String>();
		this.populaTabela();
	}

	private void populaTabela() {
		for (int i = 0; i < this.getSize(); i++)
			this.table[i] = new LinkedList<Pair>();
	}
	
	private int hash(int key) {
		return key % this.getSize();
	}
	
	private void ordenaLista() {
		for (LinkedList<Pair> list: this.table)
			Collections.sort(list);
	}

	public int getSize() {
		return size;
	}
	
	public void put(int key, String value) {
		int index = this.hash(key);
		Pair pair = new Pair(key, value);
		
		if (!this.table[index].contains(pair)) {
			this.table[index].add(pair);
			this.keys.add(key);
			this.values.add(value);
		} else {
			for (Pair par: this.table[index]) {
				if (par.getKey() == key) {
					this.values.remove(par.getValue());
					this.values.add(value);
					par.setValue(value);
				}
			}
		}
	}
	
	public void remove(int key) {
		int index = this.hash(key);
		
		if (!this.table[index].isEmpty() && this.keys.contains(key)) {
			int i = 0;
			int size = this.table[index].size();
			String value = "";
			while (i < size) {
				if (this.table[index].get(i).getKey() == key) {
					value = this.table[index].get(i).getValue();
					break;
				}
				i++;
			}
			
			this.table[index].remove(i);
			this.keys.remove(key);
			this.values.remove(value);
		}
	}
	
	public String getKeys() {
		Object[] array = this.keys.toArray();
		Arrays.sort(array);
		return Arrays.toString(array);
	}
	
	public String getValues() {
		Object[] array = this.values.toArray();
		Arrays.sort(array);
		return Arrays.toString(array);
	}
	
	@Override
	public String toString() {
		this.ordenaLista();
		return Arrays.toString(this.table);
	}
}
