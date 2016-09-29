/**
 * 
 * @author Luis Sierra, Carlos Solórzano
 * @since 28-09-2016
 * @param <E>
 */
public interface PriorityQueue<E> {
	
	/**
	 * 
	 * @param value El elemento a añadir
	 */
	public void add(E value);
	
	/**
	 * 
	 * @return True si no existen elementos en el Heap
	 */
	public boolean isEmpty();
	
	/**
	 * 
	 * @return El primer elemento del Heap
	 */
	public E getFirst();
	
	/**
	 *  
	 * @return El primer elemento del Heap. Lo elimina y ordena el Heap
	 */
	public E removeFirst();
}
