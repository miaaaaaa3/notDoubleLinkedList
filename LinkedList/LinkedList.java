
/*
 * Student information for assignment:
 * On my honor, Mia Tey, this programming assignment is my own work
 * and I have not provided this code to any other student.
 * UTEID: mat5693
 * email address: mia_tey@aol.com
 * TA name: Pranav
 * Number of slip days I am using: 0
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.StringBuilder;

public class LinkedList<E> implements IList<E> {
    // CS314 students. Add you instance variables here.
    // You decide what instance variables to use.
    // Must adhere to assignment requirements.
    // No ArrayLists or Java LinkedLists.
    private final DoubleListNode<E> HEADER;
    private int size;

    // CS314 students, add constructors here:

     /**
     * Constructor for an empty linked list with doubly linked nodes
     * O(1)
     */
    public LinkedList() {
        HEADER = new DoubleListNode<E>();
        // Make linked list circular
        HEADER.setNext(HEADER);
        HEADER.setPrev(HEADER);
    }

    // CS314 students, add methods here:

    /**
     * add item to the front of the list. <br>
     * pre: item != null <br>
     * post: size = old size + 1, get(0) = item
     * @param item the data to add to the front of this list
     * O(1)
     */ 
    public void addFirst(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Violation of precondition:" +
                " Object value may not be null.");
        }
        DoubleListNode<E> newFront = new DoubleListNode<E>(HEADER, item, HEADER.getNext());
        HEADER.getNext().setPrev(newFront);
        HEADER.setNext(newFront);
        size ++;
    }

    /**
     * add item to the end of the list. <br>
     * pre: item != null <br>
     * post: size = old size + 1, get(size -1) = item
     * @param item the data to add to the end of this list
     * O(1)
     */
    public void addLast(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Violation of precondition:" +
                " Object value may not be null.");
        }
        DoubleListNode<E> newLast = new DoubleListNode<E>(HEADER.getPrev(), item, HEADER);
        HEADER.getPrev().setNext(newLast);
        HEADER.setPrev(newLast);
        size ++;
    }

    /**
     * remove and return the first element of this list.<br>
     * pre: size > 0 (handled by remove(int pos) method) <br> 
     * post: size = old size - 1
     * @return the old first element of this list
     * O(1)
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * remove and return the last element of this list. <br>
     * pre: size > 0 <br>
     * post: size = old size - 1
     * @return the old last element of this list
     * O(1)
     */
    public E removeLast() {
        if (size <= 0) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " size > 0");
        }
        DoubleListNode<E> last = HEADER.getPrev(); 
        last.getPrev().setNext(HEADER);
        HEADER.setPrev(last.getPrev());
        size --;
        return last.getData();
    }

    /**
     * Add an item to the end of this list. <br>
     * pre: item != null  > 0 <br>
     * post: size() = old size() + 1, get(size() - 1) = item
     * @param item the data to be added to the end of this list, item != null
     * O(1)
     */
    public void add(E item) {
        addLast(item);
    }

    /**
     * Get an element from the list. <br>
     * pre: 0 <= pos < size <br>
     * @return the element at the specified position in the list
     * O(N)
     */
    public E get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " pos must be within bounds");
        }
        return getNode(pos).getData(); 
    }

    /**
     * Return a sublist of elements in this list from start inclusive to stop
     * exclusive. This list is not changed as a result of this call. <br>
     * pre: 0 <= start <= size, start <= stop <= size <br>
     * 
     * @param start index of the first element of the sublist.
     * @param stop stop - 1 is the index of the last element of the sublist.
     *
     * @return a list with stop - start elements, The elements are from positions 
     * start inclusive to stop exclusive in this list. If start == stop an empty 
     * list is returned.
     * O(N)
     */
    public IList<E> getSubList(int start, int stop) {
        if (start < 0 || start > size || start > stop || stop > size) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " start and stop must be within bounds. start cannot be > stop");
        }
        IList<E> result = new LinkedList<>();
        DoubleListNode<E> currNode = getNode(start);
        for (int i = start; i < stop; i++) {
            result.add(currNode.getData());
            currNode = currNode.getNext(); 
        }
        return result;
    }
    /**
     * Find the position of an element in the list.
     * pre: item != null <br>
     * 
     * @param item the element to search for in the list. Item != null
     *
     * @return return the index of the first element equal to item or a -1 
     * if item is not present
     * O(N)
     */
    public int indexOf(E item) {
        if (item == null) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " item != null");
        }
        return indexOf(item, 0);
    }

    /**
     * find the position of an element in the list starting at a specified position.
     * pre: 0 <= pos < size, item != null <br>
     * 
     * @param item the element to search for in the list. Item != null
     * @param pos the position in the list to start searching from
     *
     * @return  the index of the first element equal to item or a -1 if 
     * item is not present between pos and the end of the list
     * O(N)
     */
    public int indexOf(E item, int pos) {
        if (pos < 0 || pos >= size || item == null) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " 0 <= pos < size, item != null");
        }
        for (int index = pos; index < size; index++) {
            if (this.get(index).equals(item)) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Insert an item at a specified position in the list.
     * pre: 0 <= pos <= size, item != null <br>
     * post: size = old size + 1, get(pos) = item, all elements 
     * in the list with a positon >= pos have a position = old position + 1
     * 
     * @param item the data to add to the list, item != null
     * @param pos the position to insert the data at in the list
     * O(N)
     */
    public void insert(int pos, E item) {
        if (pos < 0 || pos > size || item == null) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " 0 <= pos <= size, item != null");
        }
        if (pos == size) { // Special case, no node at pos
            this.add(item);
        } else {
            DoubleListNode<E> currNode = getNode(pos); // O(N)
            DoubleListNode<E> newNode = new DoubleListNode<E>(currNode.getPrev(), item, currNode);
            currNode.getPrev().setNext(newNode);
            currNode.setPrev(newNode);
            size ++;                                                                                                                        
        }
    }
    
     /**
     * return the list to an empty state.
     * pre: none
     * post: size = 0
     * O(1)
     */
    public void makeEmpty() {
        // diconnect header from other nodes
        HEADER.setNext(HEADER);
        HEADER.setPrev(HEADER);
        size = 0;
    }

     /**
     * Remove the first occurrence of obj in this list. Return true 
     * if this list changed as a result of this call, false otherwise.
     * pre: obj != null <br>
     * post: if obj is in this list the first occurrence has been removed and 
     * size = old size - 1. If obj is not present the list is not altered 
     * in any way.
     *
     * @param obj The item to remove from this list. obj != null
     * @return true if this list changed as a result of this call, false otherwise.
     * O(N)
     */
    public boolean remove(E obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " obj != null");
        }
        DoubleListNode<E> currNode = HEADER;
        for (int index = 0; index < size; index++) {
            currNode = currNode.getNext();
            if (currNode.getData().equals(obj)) {
                currNode.getPrev().setNext(currNode.getNext());
                currNode.getNext().setPrev(currNode.getPrev());
                size --;
                return true;
            }
        }
        return false;
    }

     /**
     * Remove an element in the list based on position.
     * pre: 0 <= pos < size <br>
     * post: size = old size - 1, all elements of list with 
     * a position > pos have a position = old position - 1
     *
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     * O(N)
     */
    public E remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " 0 <= pos < size");
        }
        DoubleListNode<E> currNode = getNode(pos); // O(N)
        currNode.getPrev().setNext(currNode.getNext());
        currNode.getNext().setPrev(currNode.getPrev());
        size --;
        return currNode.getData();
    }

     /**
     * Remove all elements in this list from start inclusive to stop exclusive.
     * pre: 0 <= start <= size, start <= stop <= size <br>
     * post: size = old size - (stop - start)
     * a position > pos have a position = old position - 1
     * 
     * @param start position at beginning of range of elements to be removed
     * @param stop stop - 1 is the position at the end of the range of
     * elements to be removed
     * O(N)
     */
    public void removeRange(int start, int stop) {
        if (start < 0 || start > size || start > stop || stop > size) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " 0 <= start <= size, start <= stop <= size");
        }
        DoubleListNode<E> startNode = getNode(start); // O(N)
        DoubleListNode<E> stopNode = getNode(stop);
        startNode.getPrev().setNext(stopNode);
        stopNode.setPrev(startNode.getPrev());
        size -= (stop - start);
    }

     /**
     * Change the data at the specified position in the list. 
     * the old data at that position is returned.
     * pre: 0 <= pos < size, item != null <br>
     * post: get(pos) = item, return the old get(pos)
     *
     * @param pos the position in the list to overwrite
     * @param item the new item that will overwrite the old item, 
     * item != null
     * @return the old data at the specified position
     * O(N)
     */
    public E set(int pos, E item) {
        if (pos < 0 || pos >= size || item == null) {
            throw new IllegalArgumentException("Violation of precondition:" +
            " 0 <= pos < size, item != null");
        }
        DoubleListNode<E> currNode = getNode(pos); // O(N)
        E oldData = currNode.getData();
        currNode.setData(item);
        return oldData;
    }

     /**
     * Return the number of elements in this list.
     * pre: none <br>
     * @return the number of items in this list
     * O(1)
     */
    public int size() {
        return size;
    }

     /**
     * Return a String version of this list of linked nodes
     * 
     * @override toString in class Object
     * @return a String representation of this IList
     * O(N^2)
     */
    public String toString() {
        if (size == 0) { // special case empty list
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(get(0));
        for (int i = 1; i < size; i++) {
            sb.append(", ");
            sb.append(get(i)); 
        }         
            sb.append("]");
        return sb.toString();
    }

     /**
     * Return a node of a certain position in the LinkedList
     * O(N)
     */
    private DoubleListNode<E> getNode(int pos) {
        DoubleListNode<E> currNode = HEADER;
        for (int i = 0; i <= pos; i++) {
            currNode = currNode.getNext();
        }
        return currNode;
    }

     /**
     * Determine if this IList is equal to other. 
     * Two ILists are equal if they contain the same elements in the same order.
     * @override equals in class Object
     * @return true if this IList is equal to other, false otherwise
     * O(N)
     */
    public boolean equals(Object other) {
        // check if other is an IList before casting
    	if (!(other instanceof IList)) { 
    		return false;
    	}
        IList<?> otherList = (IList<?>) other; 

        // Check if sizes match
        if (otherList.size() != this.size) {
            return false;
        }

        // Use iterator to go through lists and check for equal elemenrs
        Iterator<E> thisIt = this.iterator();
        Iterator<?> otherIt = otherList.iterator();
        while (thisIt.hasNext()) {
        	if (!thisIt.next().equals(otherIt.next())) {
        		return false;
            }
        }
        return true;
    }

     /**
     * return an Iterator for this list.
     * pre: none
     * post: return an Iterator object for this List
     * O(1)
     */
    public Iterator<E> iterator() {
        return new DLLIterator();
    }

    /**
     * Create new class that implements iterator for our Double Linked List.
     * Credits: Mike Scott [for general structure, variable names, comments]
     */
    private class DLLIterator implements Iterator<E> {
        
        private DoubleListNode<E> nodeWithNextData;
        private boolean removeOk;
        
         /**
         * Constructor starts iterator at front of list
         * O(1)
         */
        public DLLIterator() {
            nodeWithNextData = HEADER.getNext();
        }
        
         /**
         * return true if it is okay to call next, false otherwise
         * O(1)
         */
        public boolean hasNext() {
            return nodeWithNextData != HEADER;
        }
        
         /**
         * the next element in this iteration
         * O(1)
         */
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("no more elements in this iteration");
            }
            E dataThatIsNext = nodeWithNextData.getData();

            // make iterator refer to next node in the structure.
            nodeWithNextData = nodeWithNextData.getNext();
            removeOk = true;
            return dataThatIsNext;
        }

         /**
         * the next element in this iteration
         * O(1)
         */
        public void remove() {
            if (removeOk) {
                DoubleListNode<E> nodeIteratorIsOn = nodeWithNextData.getPrev();
                nodeIteratorIsOn.getPrev().setNext(nodeWithNextData);
                nodeWithNextData.setPrev(nodeIteratorIsOn.getPrev());
                removeOk = false;
                size --;
            }
        }
    }
    
}
