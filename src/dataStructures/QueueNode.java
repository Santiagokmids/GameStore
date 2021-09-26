package dataStructures;

public class QueueNode<Q> {

	private Q element;
	private QueueNode<Q> next;
	private QueueNode<Q> previous;
	
	public QueueNode(Q element) {
		this.element = element;
		next = null;
		previous = null;
	}

	public Q getElement() {
		return element;
	}

	public void setElement(Q element) {
		this.element = element;
	}

	public QueueNode<Q> getNext() {
		return next;
	}

	public void setNext(QueueNode<Q> next) {
		this.next = next;
	}

	public QueueNode<Q> getPrevious() {
		return previous;
	}

	public void setPrevious(QueueNode<Q> previous) {
		this.previous = previous;
	}
}
