package Final;




	public final class LinkedQueue<T> implements QueueInterface<T>
	{
		private Node firstNode;
		private Node lastNode;
		
	
	

		private class Node
		{
		    private T data;
		    private Node next;

		    //Constructors
		    private Node(T dataPortion)
		    {
		        this(dataPortion, null);
		    }
		    private Node(T dataPortion, Node nextNode)
		    {
		        data = dataPortion;
		        next = nextNode;
		    }

		    //Getters and setters
		    public T getData()
		    {
		        return data;
		    }
		    public Node getNextNode()
		    {
		        return next;
		    }

		    public void setData(T data)
		    {
		        this.data = data;
		    }
		    public void setNextNode(Node next)
		    {
		        this.next = next;
		    }

		}// end Node

	@Override
	public void enqueue(T newEntry) {
		Node newNode= new Node(newEntry,null);
		if(isEmpty())
			firstNode=newNode;
		else
		lastNode.setNextNode(newNode);
		
		lastNode=newNode;
	}

	@Override
	public T dequeue() {
		T front=getFront();
		assert firstNode!=null;
		firstNode.setData(null);
		firstNode=firstNode.getNextNode();
		if(firstNode==null)
			lastNode=null;
		return front;
	}

	@Override
	public T getFront() {
		if(isEmpty())
			throw new EmptyQueueException();
		else
		
		return firstNode.getData();
	}

	@Override
	public boolean isEmpty() {
		
		return (firstNode==null)&&(lastNode==null);
	}

	@Override
	public void clear() {
		firstNode=null;
		lastNode=null;
		
	}
} // end Linkedqueue

