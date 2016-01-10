package dad;

import java.util.LinkedList;

class Sending<E> {
	private LinkedList<E> list = new LinkedList<E>();

	public void enqueueFifo(E item) {
		list.addLast(item);
	}

	public void enqueueLifo(E item) {
		list.addFirst(item);
	}

	public E dequeue() {

		return list.poll();

	}

	public boolean hasItems() {
		return !list.isEmpty();
	}

	public int size() {
		return list.size();
	}

	public void addItems(Sending<? extends E> q) {
		while (q.hasItems())
			list.addLast(q.dequeue());
	}

}
