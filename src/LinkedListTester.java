import java.util.NoSuchElementException;

/**
 * LinkedListTester
 * A driver program to test all methods of the LinkedList class
 */
public class LinkedListTester {
    
    private static int testsPassed = 0;
    private static int totalTests = 0;
    
    public static void main(String[] args) {
        System.out.println("LINKED LIST TESTER");
        System.out.println("==================\n");
        
        // Run all tests
        testConstructor();
        testSize();

        testAddFirst();
        testAddLast();
        testIsEmpty();
        testGetFirst();
        testGetLast();
        testRemoveFirst();
        testRemoveLast();
        testAddAtIndex();
        testGetAtIndex();
        testRemoveAtIndex();
        testIndexOf();
        testContains();
        testToString();
        testClear();
        testReverse();
        
        // Print summary
        System.out.println("\nTEST SUMMARY");
        System.out.println("============");
        System.out.println("Tests passed: " + testsPassed + "/" + totalTests + 
                          " (" + (int)(100.0 * testsPassed / totalTests) + "%)");
    }
    
    private static void testConstructor() {
        printTestHeader("Constructor");
        
        LinkedList<String> list = new LinkedList<>();
        boolean test1 = list.size() == 0;
        boolean test2 = list.isEmpty();
        
        printTestResult("New list has size 0", test1);
        printTestResult("New list is empty", test2);
    }
    
    private static void testAddFirst() {
        printTestHeader("addFirst");
        
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("B");

        list.addFirst("A");
        boolean test1 = list.size() == 2;

        boolean test2 = list.getFirst().equals("A");

        boolean test3 = list.getLast().equals("B");

        printTestResult("Size after adding 2 elements", test1);
        printTestResult("First element is correct", test2);
        printTestResult("Last element is correct", test3);
    }
    
    private static void testAddLast() {
        printTestHeader("addLast");
        
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        
        boolean test1 = list.size() == 2;
        boolean test2 = list.getFirst().equals("A");
        boolean test3 = list.getLast().equals("B");
        
        printTestResult("Size after adding 2 elements", test1);
        printTestResult("First element is correct", test2);
        printTestResult("Last element is correct", test3);
    }
    
    private static void testSize() {
        printTestHeader("size");
        
        LinkedList<Integer> list = new LinkedList<>();
        boolean test1 = list.size() == 0;
        list.addFirst(1);
        list.addFirst(2);

        list.addFirst(3);

        boolean test2 = list.size() == 3;
        list.removeFirst();
        boolean test3 = list.size() == 2;

        printTestResult("Empty list has size 0", test1);
        printTestResult("List with 3 elements has size 3", test2);
        printTestResult("Size decreases after removal", test3);
    }
    
    private static void testIsEmpty() {
        printTestHeader("isEmpty");
        
        LinkedList<Double> list = new LinkedList<>();
        boolean test1 = list.isEmpty();
        
        list.addFirst(1.0);
        boolean test2 = !list.isEmpty();

        list.removeFirst();
        boolean test3 = list.isEmpty();
        
        printTestResult("New list is empty", test1);
        printTestResult("List with elements is not empty", test2);
        printTestResult("List is empty after removing all elements", test3);
    }
    
    private static void testGetFirst() {
        printTestHeader("getFirst");
        
        LinkedList<Character> list = new LinkedList<>();
        
        boolean test1 = false;
        try {
            list.getFirst();
        } catch (NoSuchElementException e) {
            test1 = true;
        }
        
        list.addFirst('B');
        list.addFirst('A');
        boolean test2 = list.getFirst() == 'A';
        
        list.removeFirst();
        boolean test3 = list.getFirst() == 'B';
        
        printTestResult("getFirst throws exception on empty list", test1);
        printTestResult("getFirst returns correct element", test2);
        printTestResult("getFirst returns new first after removal", test3);
    }
    
    private static void testGetLast() {
        printTestHeader("getLast");
        
        LinkedList<Character> list = new LinkedList<>();
        
        boolean test1 = false;
        try {
            list.getLast();
        } catch (NoSuchElementException e) {
            test1 = true;
        }
        
        list.addLast('A');
        list.addLast('B');
        boolean test2 = list.getLast() == 'B';
        
        list.removeLast();
        boolean test3 = list.getLast() == 'A';
        
        printTestResult("getLast throws exception on empty list", test1);
        printTestResult("getLast returns correct element", test2);
        printTestResult("getLast returns new last after removal", test3);
    }
    
    private static void testRemoveFirst() {
        printTestHeader("removeFirst");
        
        LinkedList<String> list = new LinkedList<>();
        
        boolean test1 = false;
        try {
            list.removeFirst();
        } catch (NoSuchElementException e) {
            test1 = true;
        }
        
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        
        boolean test2 = list.removeFirst().equals("A");
        boolean test3 = list.size() == 2;
        boolean test4 = list.getFirst().equals("B");
        
        printTestResult("removeFirst throws exception on empty list", test1);
        printTestResult("removeFirst returns correct element", test2);
        printTestResult("Size decreases after removeFirst", test3);
        printTestResult("New first element is correct", test4);
    }
    
    private static void testRemoveLast() {
        printTestHeader("removeLast");
        
        LinkedList<String> list = new LinkedList<>();
        
        boolean test1 = false;
        try {
            list.removeLast();
        } catch (NoSuchElementException e) {
            test1 = true;
        }
        
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        
        boolean test2 = list.removeLast().equals("C");
        boolean test3 = list.size() == 2;
        boolean test4 = list.getLast().equals("B");
        
        printTestResult("removeLast throws exception on empty list", test1);
        printTestResult("removeLast returns correct element", test2);
        printTestResult("Size decreases after removeLast", test3);
        printTestResult("New last element is correct", test4);
    }
    
    private static void testAddAtIndex() {
        printTestHeader("add at index");
        
        LinkedList<String> list = new LinkedList<>();
        
        // Test adding at index 0 (empty list)
        list.add(0, "B");
        boolean test1 = list.getFirst().equals("B") && list.size() == 1;
        
        // Test adding at beginning
        list.add(0, "A");
        boolean test2 = list.getFirst().equals("A") && list.size() == 2;
        
        // Test adding at end
        list.add(2, "D");
        boolean test3 = list.getLast().equals("D") && list.size() == 3;
        
        // Test adding in
        list.add(2, "C");
        boolean test4 = list.get(2).equals("C") && list.size() == 4;

        // Test invalid indices
        boolean test5 = false;
        try {
            list.add(-1, "X");
        } catch (IndexOutOfBoundsException e) {
            test5 = true;
        }
        
        boolean test6 = false;
        try {
            list.add(5, "X");
        } catch (IndexOutOfBoundsException e) {
            test6 = true;
        }
        
        printTestResult("Add to empty list", test1);
        printTestResult("Add at beginning", test2);
        printTestResult("Add at end", test3);
        printTestResult("Add in middle", test4);
        printTestResult("Exception for negative index", test5);
        printTestResult("Exception for index > size", test6);
    }
    
    private static void testGetAtIndex() {
        printTestHeader("get at index");
        
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        
        boolean test1 = list.get(0).equals("A");
        boolean test2 = list.get(1).equals("B");
        boolean test3 = list.get(2).equals("C");
        
        // Test invalid indices
        boolean test4 = false;
        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            test4 = true;
        }
        
        boolean test5 = false;
        try {
            list.get(3);
        } catch (IndexOutOfBoundsException e) {
            test5 = true;
        }
        
        printTestResult("Get first element", test1);
        printTestResult("Get middle element", test2);
        printTestResult("Get last element", test3);
        printTestResult("Exception for negative index", test4);
        printTestResult("Exception for index >= size", test5);
    }
    
    private static void testRemoveAtIndex() {
        printTestHeader("remove at index");
        
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        
        // Test removing first element
        boolean test1 = list.remove(0).equals("A");
        boolean test2 = list.size() == 3 && list.getFirst().equals("B");
        
        // Test removing middle element
        boolean test3 = list.remove(1).equals("C");
        boolean test4 = list.size() == 2 && list.get(1).equals("D");
        
        // Test removing last element
        boolean test5 = list.remove(1).equals("D");
        boolean test6 = list.size() == 1 && list.getFirst().equals("B");
        
        // Test invalid indices
        boolean test7 = false;
        try {
            list.remove(-1);
        } catch (IndexOutOfBoundsException e) {
            test7 = true;
        }
        
        boolean test8 = false;
        try {
            list.remove(1);
        } catch (IndexOutOfBoundsException e) {
            test8 = true;
        }
        
        printTestResult("Remove first element returns correct value", test1);
        printTestResult("List state correct after removing first", test2);
        printTestResult("Remove middle element returns correct value", test3);
        printTestResult("List state correct after removing middle", test4);
        printTestResult("Remove last element returns correct value", test5);
        printTestResult("List state correct after removing last", test6);
        printTestResult("Exception for negative index", test7);
        printTestResult("Exception for index >= size", test8);
    }
    
    private static void testIndexOf() {
        printTestHeader("indexOf");
        
        LinkedList<String> list = new LinkedList<>();
        
        // Test empty list
        boolean test1 = list.indexOf("A") == -1;
        
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("B");
        
        // Test finding elements
        boolean test2 = list.indexOf("A") == 0;
        boolean test3 = list.indexOf("B") == 1;  // First occurrence
        boolean test4 = list.indexOf("C") == 2;
        
        // Test element not in list
        boolean test5 = list.indexOf("X") == -1;
        
        // Test null element
        boolean test6 = list.indexOf(null) == -1;
        
        list.addLast(null);
        boolean test7 = list.indexOf(null) == 4;
        
        printTestResult("Empty list returns -1", test1);
        printTestResult("First element found", test2);
        printTestResult("Middle element found (first occurrence)", test3);
        printTestResult("Last element found", test4);
        printTestResult("Non-existent element returns -1", test5);
        printTestResult("Null returns -1 when not in list", test6);
        printTestResult("Null element found when present", test7);
    }
    
    private static void testContains() {
        printTestHeader("contains");
        
        LinkedList<String> list = new LinkedList<>();
        
        // Test empty list
        boolean test1 = !list.contains("A");
        
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        
        // Test finding elements
        boolean test2 = list.contains("A");
        boolean test3 = list.contains("B");
        boolean test4 = list.contains("C");
        
        // Test element not in list
        boolean test5 = !list.contains("X");
        
        // Test null element
        boolean test6 = !list.contains(null);
        
        list.addLast(null);
        boolean test7 = list.contains(null);
        
        printTestResult("Empty list returns false", test1);
        printTestResult("First element found", test2);
        printTestResult("Middle element found", test3);
        printTestResult("Last element found", test4);
        printTestResult("Non-existent element returns false", test5);
        printTestResult("Null returns false when not in list", test6);
        printTestResult("Null element found when present", test7);
    }
    
    private static void testToString() {
        printTestHeader("toString");
        
        LinkedList<String> list = new LinkedList<>();
        
        // Test empty list
        boolean test1 = list.toString().equals("[]");
        
        // Test single element
        list.addLast("A");
        boolean test2 = list.toString().equals("[A]");
        
        // Test multiple elements
        list.addLast("B");
        list.addLast("C");
        boolean test3 = list.toString().equals("[A, B, C]");
        
        printTestResult("Empty list returns []", test1);
        printTestResult("Single element formatted correctly", test2);
        printTestResult("Multiple elements formatted correctly", test3);
    }
    
    private static void testClear() {
        printTestHeader("clear");
        
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        
        list.clear();
        boolean test1 = list.isEmpty();
        boolean test2 = list.size() == 0;
        
        boolean test3 = false;
        try {
            list.getFirst();
        } catch (NoSuchElementException e) {
            test3 = true;
        }
        
        printTestResult("List is empty after clear", test1);
        printTestResult("Size is 0 after clear", test2);
        printTestResult("Cannot access elements after clear", test3);
    }
    
    private static void testReverse() {
        printTestHeader("reverse (challenge)");
        
        // Test empty list
        LinkedList<String> emptyList = new LinkedList<>();
        emptyList.reverse();
        boolean test1 = emptyList.isEmpty();
        
        // Test single element
        LinkedList<String> singleList = new LinkedList<>();
        singleList.addLast("A");
        singleList.reverse();
        boolean test2 = singleList.getFirst().equals("A") && singleList.size() == 1;
        
        // Test multiple elements
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");
        
        list.reverse();
        boolean test3 = list.size() == 4;
        boolean test4 = list.get(0).equals("D") && 
                        list.get(1).equals("C") && 
                        list.get(2).equals("B") && 
                        list.get(3).equals("A");
        
        printTestResult("Empty list remains empty after reverse", test1);
        printTestResult("Single element list unchanged after reverse", test2);
        printTestResult("Size unchanged after reverse", test3);
        printTestResult("Elements reversed correctly", test4);
    }
    
    private static void printTestHeader(String methodName) {
        System.out.println("\nTesting " + methodName + ":");
        System.out.println("-".repeat(20));
    }
    
    private static void printTestResult(String testDescription, boolean passed) {
        totalTests++;
        if (passed) {
            testsPassed++;
            System.out.println("âœ“ PASS: " + testDescription);
        } else {
            System.out.println("âœ— FAIL: " + testDescription);
        }
    }
}
