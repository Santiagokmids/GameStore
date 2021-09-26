package dataStructures;

public class StackNode<P> {
	
	private P element;
	private StackNode<P> next;
	
	public StackNode(P element) {
		this.element = element;
		next = null;
	}

	public P getElement() {
		return element;
	}

	public void setElement(P element) {
		this.element = element;
	}

	public StackNode<P> getNext() {
		return next;
	}

	public void setNext(StackNode<P> next) {
		this.next = next;
	}
}
