package dataStructures;

public class Stack<T> {

	private StackNode<T> top;
	
	public Stack() {
		createStack();
	}
	
	public void createStack() {
		top = null;
	}
	
	public StackNode<T> pop(){
		
		StackNode<T> toSend = new StackNode<T>(null);
		
		if(top != null) {
			
			toSend = top;
			
			if(top.getNext() != null) {
				top = top.getNext();
			}else {
				top = null;
			}
		}
		
		return toSend;
	}
	
	public boolean push(T element) {
		
		StackNode<T> newNode = new StackNode<T>(element);
		boolean verify = false;
		
		if(top == null) {
			top = newNode;
		}else {
			newNode.setNext(top);
			top = newNode;
			verify = true;
		}
		
		return verify;
	}
	
	public StackNode<T> top(){
		
		StackNode<T> newNode = new StackNode<T>(null);
		
		if(top != null) {
			newNode = top;
		}
		
		return newNode;
	}
	
	public boolean isEmpty() {
		boolean verify = false;
		
		if(top == null) {
			verify = true;
		}
		
		return verify;
	}
}
