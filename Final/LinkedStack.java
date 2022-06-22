package Final;


public final class LinkedStack<T> implements StackInterface<T>
{

private Node topNode; // References the first node in the chain

public LinkedStack() {
	topNode=null;
}


public void push(T newEntry) {
	Node newNode= new Node(newEntry,topNode);
	topNode=newNode;
	
}


public T pop() {
	if (isEmpty()) {
		throw new EmptyStackException("Empty Stack");
	}
	T top=peek();
	
	assert topNode!=null;
	topNode=topNode.getNext();
	
			return top;
}





public T peek() {
	
	if (isEmpty()) {
	throw new EmptyStackException("Empty Stack");
	}
	
	
	return topNode.getData();
}


public boolean isEmpty() {
	
	return topNode==null;
}


public void clear() {
	
	topNode=null;

}


private class Node
{

	private T data;
	private Node next;
	
	private Node(T dataPortion) 
	{
	this (dataPortion,null);
	}

	private Node (T dataPortion, Node nextNode)
	{
	setData(dataPortion);
	setNext(nextNode);
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}// end Node



}// end LinkedStack