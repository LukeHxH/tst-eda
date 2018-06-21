package tsteda;

public class LinkedListTest {
	
	public static void main(String[] args) {
		
	}

}

class RecursiveLinkedList {
	
	private Integer data;
	private RecursiveLinkedList previous;
	private RecursiveLinkedList next;
	
	public RecursiveLinkedList() {
		this(null, null, null);
	}
	
	public RecursiveLinkedList(Integer data, RecursiveLinkedList previous, RecursiveLinkedList next) {
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int size() {
		int size = 0;
		
		if (this.data != null)
			size = (this.next == null) ? 1 : 1 + this.next.size();
		
		return size;
	}
	
	public void insert(Integer element) {
		if (element != null) {
			if (this.data == null)
				this.data = element;
			else if (this.next == null) {
				this.next = new RecursiveLinkedList(element, this, null);
			} else {
				this.next.insert(element);
			}
		}
	}
	
	public void remove(Integer element) {
		if (element != null && !this.isEmpty() && this.data != null) {
			if (this.data.equals(element)) {
				if (this.next == null)
					this.data = null;
				else {
					this.data = this.next.data;
					this.next = this.next.next;
				}
			} else 
				if (this.next != null) 
					this.next.remove(element);
		}
	}
	
	public void removeFirst() {
		
	}
	
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.next == null) {
				if (this.previous == null)
					this.data = null;
				else
					this.previous.next = null;
			} else {
				this.next.removeLast();
			}
		}
	}
	
	public Integer search(Integer element) {
		return null;
	}

	public RecursiveLinkedList getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveLinkedList previous) {
		this.previous = previous;
	}

	public RecursiveLinkedList getNext() {
		return next;
	}

	public void setNext(RecursiveLinkedList next) {
		this.next = next;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}
}
