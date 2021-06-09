
public class StackAsList<T> implements Stack<T> {
	private Node top;
	private int size = 0;

	@Override
	public T pop() {
		if (top.next != null) {
			T topString = top.data;
			top = top.next;
			size--;
			return topString;
		}
		else if (top != null) {
			T topString = top.data;
			top = null;
			size--;
			return topString;
		}
		else {
			throw new RuntimeException("Stack Underflow");
		}
	}
	
	public int getSize() {
	    return size;
	}

	@Override
	public void push(T elem) {
		if (top == null) {
			Node newNode = new Node(elem, null);
			top = newNode;
			size++;
		}
		else {
			Node formerTop = top;
			Node newNode = new Node(elem, formerTop);
			top = newNode;
			size++;
		}
	}
	

	public static void main(String[] args) {
		
	}
	
	
	@Override
	public String toString() {
		String toString = "";
		Node currentNode = top;
		while(currentNode != null) {
			toString = toString + currentNode.data;
			currentNode = currentNode.next;
		}
		return null;
	}

	private class Node {
		T data;
		Node next;
		
		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public T top() {
		if (top != null) {
			return top.data;
		}
		else {
			return null;
		}
	}
}
