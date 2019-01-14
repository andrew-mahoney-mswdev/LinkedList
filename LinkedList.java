import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<E> implements List<E> {
	private E value;
	private LinkedList<E> next;
	
	public LinkedList() {
		value = null;
		next = null;
	}

	public LinkedList<E> getNode(int index) { //Iteration
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		
		LinkedList<E> node = this;
		for (int nodeIndex = 0; nodeIndex < index; nodeIndex++)
			if (node != null)
				node = node.next;
		
		return node;
	}
	
	private LinkedList<E> alternative_getNode(int index) { //Recursion is no good because this is nesting methods ad infinitum.
		if (index < 0 || index >= size()) throw new IndexOutOfBoundsException();
		if (index == 0) return this;
		else return next.alternative_getNode(index-1);
	}
	
	public boolean add(E value) {
		LinkedList<E> node = this;

		while (node.next != null) node = node.next;
		node.value = value;
		node.next = new LinkedList<E>();

		return true;
	}
	
	public boolean isEmpty() {
		if (next == null) return true;
		else return false;
	}
	
	public int size() {
		LinkedList <E> node = this;
		int size = 0;
		
		while (node.next != null) {
			size++;
			node = node.next;
		}
		
		return size;
	}
	
	public E get(int index) {
		return getNode(index).value; 
	}
	
	public E set(int index, E value) {	
		LinkedList<E> node = getNode(index);
		E lastValue = node.value;
		node.value = value;

		return lastValue;
	}
	
	public void clear() {
		value = null;
		next = null;
	}

	public void add(int index, E value) {
		LinkedList<E> newNode = new LinkedList<E>();
		LinkedList<E> node = getNode(index);
		
		newNode.value = node.value;
		node.value = value;
		newNode.next = node.next;
		node.next = newNode;
	}
	
	public E remove(int index) {	
		LinkedList<E> node = getNode(index);
		E oldValue = node.value;
		if (next != null) {
			node.value = node.next.value;
			node.next = node.next.next;
		} else {
			node = getNode(index - 1);
			node.next = null;
		}
		return oldValue;
	}
	
	public boolean contains(Object O) {
		for (LinkedList<E> node = this; node.next != null; node = node.next)
			if (node.value == O) return true;
		
		return false;
	}

	public boolean remove(Object O) {
		LinkedList<E> lastNode = null, node = this;
		
		int index;
		for (index = 0; node.next != null && node.value != value; index++);
		
		if (index < size()) {
			remove(index);
			return true;
		} else
			return false;
	}

	public LinkedList<E> subList(int fromIndex, int toIndex) {
		LinkedList<E> newLinkedList = new LinkedList<E>();
		
		for (int index = fromIndex; index < toIndex; index++)
			newLinkedList.add(getNode(index).value);
		
		return newLinkedList;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(this);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	public class LinkedListIterator<E> implements Iterator<E> {
		
		private LinkedList<E> current;
		
		public LinkedListIterator(LinkedList<E> current) {
			this.current = current;
		}

		public boolean hasNext() {
			if (current.next != null) return true;
			else return false;
		}

		public E next() {
			E value = current.value;
			current = current.next;
			return value;
		}
	}
	
}
