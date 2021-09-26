package dataStructures;

import model.IElementsOfStore;

public class Queue<E> implements IElementsOfStore{
	
	private QueueNode<E> front;
	private QueueNode<E> back;
	
	public Queue() {
		create();
	}
	
	public boolean create() {
		front = null;
		back = null;
		return true;
	}
	
	public boolean dequeue() {
		
		boolean verify = false;
		
		if(front != null && front.getNext() != null) {
			verify = true;
			front = front.getNext();
		}else {
			verify = true;
			front = null;
		}
		return verify;
	}
	
	public boolean enqueue(QueueNode<E> element) {
		
		boolean verify = false;
		
		if(front == null) {
			front = element;
		}else {
			verify = enqueueRecursive(front, element);	
		}
		
		
		return verify;
	}
	
	public boolean enqueueRecursive(QueueNode<E> current, QueueNode<E> newElement) {
		
		boolean verify = false;

		if(current != null && current.getNext() != null) {
			verify = enqueueRecursive(current.getNext(), newElement);
		}else if(current != null && current.getNext() == null) {
			current.setNext(newElement);
			back = newElement;
			verify = true;
		}
		
		return verify;
	}
	
	public boolean isEmpty() {
		
		boolean verify = false;
		
		if(front == null && back == null) {
			verify = true;
		}
		
		return verify;
	}
}
