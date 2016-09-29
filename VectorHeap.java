/**
 * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/code/Heap.java
 * @author Luis Sierra, Carlos Solórzano
 * @since 28-09-2016
 * @param <E>
 */
import java.util.*;
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{

	private Vector<E> vector;
	private int size;
	
	/**
	 * Constructor vacío
	 */
	public VectorHeap() {
		size = 0;
		vector = new Vector<E>();
	}

	@Override
	public void add(E value) {
		size++;
		vector.add(value);
		bubbleUp();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public E getFirst() {
		return vector.firstElement();
	}

	@Override
	public E removeFirst() {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		E temp = vector.remove(0);
		size--;
		bubbleDown();
		return temp;
	}
	
	/**
	 * Ordena el Heap cuando se inserta un nuevo elemento
	 */
	private void bubbleUp() {
		int index = this.size - 1;
		while (hasParent(index)) {
			if (vector.get(index).compareTo(parent(index)) < 0) {
				swap(index, parentIndex(index));
			}
			index--;
		}
	}
	
	/**
	 * Ordena el Heap cuando se elimina el primer elemento
	 */
	private void bubbleDown() {
		int index = 0;
		while(hasLeft(index)) {
			int smaller = leftChild(index);
			if (hasRight(index) && 
					vector.get(leftChild(index)).compareTo(vector.get(rightChild(index)))
					> 0) {
				smaller = rightChild(index);
			}
			
			if (vector.get(index).compareTo(vector.get(smaller)) > 0) {
				swap(index, smaller);
			} else {
				break;
			}
			
			index = smaller;
		}
	}
	
	/**
	 * 
	 * @param index La posición del elemento
	 * @return True si el elemento tiene un padre
	 */
	private boolean hasParent(int index) {
		return index > 0;
	}

	/**
	 * 
	 * @param index La posición del elemento
	 * @return El padre del elemento
	 */
	private E parent(int index) {
		return vector.elementAt(parentIndex(index));
	}
	
	/**
	 * 
	 * @param index El índice del elemento
	 * @return El índice del padre
	 */
	private int parentIndex(int index) {
		return index/2;
	}
	
	/**
	 * 
	 * @param index El índice del elemento
	 * @return El índice del hijo izquierdo
	 */
	private int leftChild(int index) {
		return index * 2;
	}
	
	/**
	 * 
	 * @param index El índice del elemento
	 * @return El índice del hijo derecho
	 */
	private int rightChild(int index) {
		return (index * 2) + 1;
	}
	
	/**
	 * 
	 * @param index El índice del elemento
	 * @return True si tiene hijo izquierdo
	 */
	private boolean hasLeft(int index) {
		return (leftChild(index) <= size - 1);
	}
	
	/**
	 * 
	 * @param index El índice del elemento
	 * @return True si tiene hijo derecho
	 */
	private boolean hasRight(int index) {
		return (rightChild(index) <= size - 1);
	}
	
	/**
	 * 
	 * @param n1 El índice de la primera posición
	 * @param n2 El índice de la segunda posición
	 */
	private void swap(int n1, int n2) {
		E temp = vector.elementAt(n1);
		vector.set(n1, vector.elementAt(n2));
		vector.set(n2, temp);		
	}
	
	public String toString() {
		String string = "";
		for (int i = 0; i != size; i++) {
			string += vector.elementAt(i) + "\r\n";
		}
		return string;
	}
	
	/**
	 * 
	 * @return La cantidad de elementos del Heap
	 */
	public int getSize() {
		return size;
	}
}
