    import java.io.ObjectStreamException;
    import java.lang.annotation.ElementType;
    import java.util.NoSuchElementException;

    /**
     * LinkedList class
     * A implementation of a singly linked list data structure
     * with a head pointer.
     *
     * AP CS students: Implement all methods in this file
     */
    public class LinkedList<E> {

        /**
         * Node class for the LinkedList
         * Contains data and a reference to the next node
         */
        private class Node {
            private E data;         // Data stored in this node
            private Node next;      // Reference to the next node in the list

            /**
             * Constructor for the Node class
             * @param data The data to store in this node
             */
            public Node(E data) {
                this.data = data;
            }

            /**
             * Constructor for the Node class
             * @param data The data to store in this node
             * @param next The reference to the next node
             */
            public Node(E data, Node next) {
                this.data = data;
                this.next = next;
            }
        }

        // Instance variables for the LinkedList
        private Node head;  // Reference to the first node in the list
        private int size;   // Number of elements in the list

        /**
         * Default constructor for the LinkedList class
         * Creates an empty list
         */
        public LinkedList() {
            head = null;
            size = 0;
        }

        /**
         * Returns the number of elements in the list
         * @return The number of elements in the list
         */
        public int size() {
            return size;
        }

        /**
         * Checks if the list is empty
         * @return true if the list is empty, false otherwise
         */
        public boolean isEmpty() {
            return head == null;
        }

        /**
         * Returns the first element in the list without removing it
         * @return The first element in the list
         * @throws NoSuchElementException if the list is empty
         */
        public E getFirst() {
            if(head != null) {
                return head.data;
            } else {
                throw new NoSuchElementException();
            }
        }

        /**
         * Returns the last element in the list without removing it
         * @return The last element in the list
         * @throws NoSuchElementException if the list is empty
         */
        public E getLast() {
            if(head == null) {
                throw new NoSuchElementException();
            }
            Node current = head;
            while(current.next != null) {
                current = current.next;
                Node slow = head, fast = head;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                    if (slow == fast) {
                        current.next = null;
                    }
                }
            }
            return current.data; // Placeholder return value

        }

        /**
         * Adds an element to the beginning of the list
         * @param element The element to add
         */
        public void addFirst(E element) {
            Node newN = new Node(element);
            if(head == null) {
                head = newN;
            }
            newN.next = head;
            head = newN;
            size++;
        }

        /**
         * Adds an element to the end of the list
         * @param element The element to add
         */
        public void addLast(E element) {
            Node newN = new Node(element);
            if(head == null) {
                head = newN;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newN;
            }
            size++;
        }

        /**
         * Removes and returns the first element in the list
         * @return The first element in the list
         * @throws NoSuchElementException if the list is empty
         */
        public E removeFirst() {
            if(head == null) {
                throw new NoSuchElementException();
            }
            E first = head.data;
            head = head.next;
            size--;
            if(size == 0) {
                head =null;
            }
            return first; // Placeholder return value
        }

        /**
         * Removes and returns the last element in the list
         * @return The last element in the list
         * @throws NoSuchElementException if the list is empty
         */
        public E removeLast() {
            E last = null;
            if(head == null) {
                throw new NoSuchElementException("Why not exist");
            }
            Node current = head;
            while(current.next.next != null) {
                current = current.next;
            }
            last = current.next.data;
            current.next = null;
            size--;
            return last; // Placeholder return value
        }

        /**
         * Adds an element at the specified index
         * @param index The index at which to add the element
         * @param element The element to add
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        public void add(int index, E element) {
            if(index>size || index<0) {
                throw new IndexOutOfBoundsException("to big bro");
            }
            Node newN = new Node(element);
            Node current = head;
            if(index == 0) {
                newN.next = head;
                head = newN;
            } else {
                for(int i = 0; i < index-1; i++) {
                    current = current.next;
                }
                newN.next = current.next;
                current.next = newN;
            }
            size++;
        }

        /**
         * Returns the element at the specified index without removing it
         * @param index The index of the element to return
         * @return The element at the specified index
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        public E get(int index) {
            if(index > size-1 || index<0) {
                throw new IndexOutOfBoundsException("funny");
            }
            Node current = head;
            if(index == size) {
              for(int i = 0; i < size; i++) {
                  current = current.next;
                  if(current == null) {
                      return null;
                  }
              }
              return current.data;
            }
            for(int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        /**
         * Removes and returns the element at the specified index
         * @param index The index of the element to remove
         * @return The element at the specified index
         * @throws IndexOutOfBoundsException if the index is out of range
         */
        public E remove(int index) {
            if(index >= size || index < 0) {
                throw new IndexOutOfBoundsException("eee");
            }
            E sendBack;
            if(index ==0 ) {
                sendBack = head.data;
                head = head.next;
            } else {
                Node current =head;
                for(int i = 0; i < index-1; i++) {
                    current = current.next;
                }

                Node hehe = current.next;
                sendBack = hehe.data;

                current.next = hehe.next;
            }
            size--;
            return sendBack;
        }

        /**
         * Returns the index of the first occurrence of the specified element
         * @param element The element to search for
         * @return The index of the first occurrence of the element, or -1 if not found
         */
        public int indexOf(E element) {
            if(head == null) {
                return -1;
            }
            int index = 0;
            while(index < size) {
                if(get(index) == element) {
                    return index;
                };
                index++;
            }
            return -1;
        }

        /**
         * Checks if the list contains the specified element
         * @param element The element to search for
         * @return true if the list contains the element, false otherwise
         */
        public boolean contains(E element) {
            if(head == null) {
                return false;
            }
            int index = 0;
            while(index < size) {
                if(get(index) == element) {
                    return true;
                };
                index++;
            }
            return false;
        }

        /**
         * Returns a string representation of the list
         * @return A string representation of the list
         */
        @Override
        public String toString() {
            StringBuilder string = new StringBuilder();
            if(head == null) {
                return "[]";
            }

            for(Node current = head; current != null; current = current.next) {
                if(!string.toString().isEmpty()) {
                    string.append(", ").append(current.data);
                } else {
                    string.append(current.data);
                }

            }
            return "[" + string + "]"; // Placeholder return value
        }

        /**
         * Clears the list, removing all elements
         */
        public void clear() {
            head = null;
            size = 0;
        }

        /**
         * Extra challenge: Reverses the list in place
         */
        public void reverse() {
            Node current = head;
            Node prev = null;
            Node next = null;
            while(current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }
    }
