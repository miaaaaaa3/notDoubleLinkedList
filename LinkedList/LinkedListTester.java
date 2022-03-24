/*  Student information for assignment:
 *
 *  On my honor, Mia Tey, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Mia Tey
 *  email address: mia_tey@aol.com
 *  UTEID: mat5693
 *  Section 5 digit ID: 51175
 *  Grader name: Pranav
 *  Number of slip days used on this assignment: 0
 */

/* Experiment results. CS314 students, place your experiment
 *  results here:
 * 
 * Operations that are faster when using LinkedList: 
 * -adding at front 
 * -removing from front
 * 
 * Operations that are faster when using the Java ArrayList class:
 * -getting random 
 * -getting all using get method
 * 
 * Operations that about the same speed for either Arraylist or LinkedList:
 * -adding at end
 * -getting all using iterator
 * 
 * For the operations tested via the experiment what do you think the Big O 
 * of each operation / method is based on the timing data? State your reasoning:
 * 
 * Note: Since each of the experiments were run N times, timing data is multiplied by N
 * 
 * adding at end operation:
 * -ArrayList: O(1) because as N doubles, time is multiplied by slightly more than 2
 *      (accounting for ArrayList resizing). This is because adding at end does not 
 *      require traversing through the entire N data.
 * -LinkedList: O(1) because as N doubles, time approx. doubles. This is because adding 
 *      at end is a simple rearrangement of references.
 * 
 * adding at front operation: 
 * -ArrayList: O(N) because as N doubles, time is mult. by 4. This is because N items
 *      are being shifted over when adding to front of list.
 * -LinkedList: O(1) because as N doubles, time approx. doubles. This is because LL
 *      simply rearranges references.
 * 
 * removing from front operation:
 * -ArrayList: O(N) because as N doubles, time is mult. by 4. This is because N 
 *      items are being shifted over when removing from front of list.
 * -LinkedList: O(1) because as N doubles, time approx. doubles. This is because LL 
 *      simply rearranges references.
 * 
 * getting random operation:
 * -ArrayList: O(1) because as N doubles, time approx. doubles, since retrieving 
 *      data of a position simply requires a direct reference through an index.
 * -LinkedList: O(N) because as N doubles, time is mult. by 4, since LL gives 
 *      reference to a header and then requires traversing through all nodes
 *      (since nodes are chained together by reference).
 *
  * getting all using iterator operation:
 * -ArrayList: O(1) because as N doubles, time approx doubles, since iterator 
 *      is simply traveling through N elements once.
 * -LinkedList: O(1) because as N doubles, time approx. doubles, since iterator 
 *      also simply traverses through N elements once to retrieve values.
 * 
 * getting all using get operation:
 * -ArrayList: O(1) because as N doubles, time approx. doubles. This is because
 *      retrieving data of a certain pos simply requires a direct reference to 
 *      that element through an index.
 * -LinkedList: O(N) because as N doubles, time is mult. by 4. This is because LL 
 *      gives reference to a header and then requires traversing through all nodes
 *      (since nodes are chained together by reference).
 */


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {
        
        //CS314 students. Add your tests here:
        myTests();

        // CS314 Students:
        // uncomment the following line to run tests comparing
        // your LinkedList class to the java ArrayList class.
        //comparison();
    }
    
    /*
     * My tests from LinkedList class
     */
    private static void myTests() {
        
        LinkedList<String> list = new LinkedList<>();

        // addFirst tests
        System.out.println("\nTest 1: addFirst(E item) method");
        list.add("9");
        list.add("P");
        list.add("W");
        list.addFirst("I");
        if (list.toString().equals("[I, 9, P, W]")) {
            System.out.println("Passed test 1");
        } else {
            System.out.println("Failed test 1");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 2: addFirst(E item) method");
        list.add("not first");
        list.add("2");
        list.add("3");
        list.addFirst("first");
        if (list.toString().equals("[first, not first, 2, 3]")) {
            System.out.println("Passed test 2");
        } else {
            System.out.println("Failed test 2");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 3: addFirst(E item) method");
        list.add("this");
        list.add("that");
        list.add("other");
        list.add("8");
        list.add("!");
        list.addFirst("one");
        if (list.toString().equals("[one, this, that, other, 8, !]")) {
            System.out.println("Passed test 3");
        } else {
            System.out.println("Failed test 3");
        }

        // addLast tests
        list = new LinkedList<>();
        System.out.println("\nTest 4: addLast(E item) method");
        list.add("e");
        list.add("1");
        list.add("p");
        list.addLast("I");
        if (list.toString().equals("[e, 1, p, I]")) {
            System.out.println("Passed test 4");
        } else {
            System.out.println("Failed test 4");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 5: addLast(E item) method");
        list.add("not last");
        list.add("this");
        list.add("o");
        list.addLast("last");
        if (list.toString().equals("[not last, this, o, last]")) {
            System.out.println("Passed test 5");
        } else {
            System.out.println("Failed test 5");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 6: addLast(E item) method");
        list.add("C");
        list.add("S");
        list.add("3");
        list.add("1");
        list.add("4");
        list.addLast("Mike Scott");
        if (list.toString().equals("[C, S, 3, 1, 4, Mike Scott]")) {
            System.out.println("Passed test 6");
        } else {
            System.out.println("Failed test 6");
        }

        // removeFirst tests
        list = new LinkedList<>();
        System.out.println("\nTest 7: removeFirst() method");
        list.add("y");
        list.add("s");
        list.add("3");
        list.add("P");
        list.add("2");
        list.add("6");
        list.removeFirst();
        if (list.toString().equals("[s, 3, P, 2, 6]")) {
            System.out.println("Passed test 7");
        } else {
            System.out.println("Failed test 7");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 8: removeFirst()) method");
        list.add("unnecessary");
        list.add("o");
        list.add("j");
        list.add("l");
        list.add("5");
        list.add("2");
        list.removeFirst();
        if (list.toString().equals("[o, j, l, 5, 2]")) {
            System.out.println("Passed test 8");
        } else {
            System.out.println("Failed test 8");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 9: removeFirst() method");
        list.add("to be removed");
        list.add("this");
        list.add("E");
        list.add("I");
        list.add("A");
        list.add("V");
        list.removeFirst();
        if (list.toString().equals("[this, E, I, A, V]")) {
            System.out.println("Passed test 9");
        } else {
            System.out.println("Failed test 9");
        }

        // removeLast tests
        list = new LinkedList<>();
        System.out.println("\nTest 10: removeLast() method");
        list.add("3");
        list.add("5");
        list.add("9");
        list.add("1");
        list.add("2");
        list.add("6");
        list.removeLast();
        if (list.toString().equals("[3, 5, 9, 1, 2]")) {
            System.out.println("Passed test 10");
        } else {
            System.out.println("Failed test 10");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 11: removeLast() method");
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.removeLast();
        if (list.toString().equals("[A, B, C, D, E]")) {
            System.out.println("Passed test 11");
        } else {
            System.out.println("Failed test 11");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 12: removeLast() method");
        list.add("3");
        list.add("A");
        list.add("CS");
        list.add("P");
        list.add("6");
        list.add("to be removed");
        list.removeLast();
        if (list.toString().equals("[3, A, CS, P, 6]")) {
            System.out.println("Passed test 12");
        } else {
            System.out.println("Failed test 12");
        }

        // add tests
        list = new LinkedList<>();
        System.out.println("\nTest 13: add(E item) method");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        if (list.toString().equals("[1, 2, 3, 4]")) {
            System.out.println("Passed test 13");
        } else {
            System.out.println("Failed test 13");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 14: add(E item) method");
        list.add("alpha");
        list.add("beta");
        list.add("gamma");
        list.add("delta");
        if (list.toString().equals("[alpha, beta, gamma, delta]")) {
            System.out.println("Passed test 14");
        } else {
            System.out.println("Failed test 14");
        }

        list = new LinkedList<>();
        System.out.println("\nTest 15: add(E item) method");
        list.add("epsilon");
        if (list.toString().equals("[epsilon]")) {
            System.out.println("Passed test 15");
        } else {
            System.out.println("Failed test 15");
        }

        // get tests
        LinkedList<Integer> intList = new LinkedList<>();

        intList.add(4); //0
        intList.add(3); //1
        intList.add(2); //2
        intList.add(7); //3
        intList.add(3); //4
        intList.add(9); //5
        
        System.out.println("\nTest 16: get method");
        if (intList.get(3).equals(7)) {
            System.out.println("Passed test 16");
        } else {
            System.out.println("Failed test 16");
        }

        System.out.println("\nTest 17: get method");
        if (intList.get(0).equals(4)) {
            System.out.println("Passed test 17");
        } else {
            System.out.println("Failed test 17");
        }

        System.out.println("\nTest 18: get method");
        if (intList.get(intList.size()-1).equals(9)) {
            System.out.println("Passed test 18");
        } else {
            System.out.println("Failed test 18");
        }

        // getSubList tests
        System.out.println("\nTest 19: getSubList method");
        LinkedList<Integer> other = new LinkedList<>();
        other.add(3); //1
        other.add(2); //2
        if (intList.getSubList(1, 3).equals(other)) {
            System.out.println("Passed test 19");
        } else {
            System.out.println("Failed test 19");
        }

        System.out.println("\nTest 20: getSubList method");
        other = new LinkedList<>();
        other.add(7); //3
        other.add(3); //4
        other.add(9); //5
        if (intList.getSubList(3, 6).equals(other)) {
            System.out.println("Passed test 20");
        } else {
            System.out.println("Failed test 20");
        }

        System.out.println("\nTest 21: getSubList method");
        other = new LinkedList<>();
        other.add(4); //0
        if (intList.getSubList(0, 1).equals(other)) {
            System.out.println("Passed test 21");
        } else {
            System.out.println("Failed test 21");
        }

        // indexOf(E item) tests
        LinkedList<String> strList = new LinkedList<>();

        strList.add("A"); //0
        strList.add("E"); //1
        strList.add("I"); //2
        strList.add("O"); //3
        strList.add("U"); //4
        strList.add("Y"); //5
        strList.add("A"); //6
        strList.add("E"); //7
        strList.add("I"); //8
        strList.add("O"); //9
        strList.add("U"); //10
        strList.add("Y"); //11

        System.out.println("\nTest 22: indexOf(E item) method");
        int result = strList.indexOf("A");
        if (result == 0) {
            System.out.println("Passed test 22");
        } else {
            System.out.println("Failed test 22");
        }

        System.out.println("\nTest 23: indexOf(E item) method");
        result = strList.indexOf("O");
        if (result == 3) {
            System.out.println("Passed test 23");
        } else {
            System.out.println("Failed test 23");
        }

        System.out.println("\nTest 24: indexOf(E item) method");
        result = strList.indexOf("Y");
        if (result == 5) {
            System.out.println("Passed test 24");
        } else {
            System.out.println("Failed test 24");
        }

        // indexOf(E item, int pos) tests
        System.out.println("\nTest 25: indexOf(E item, int pos) method");
        result = strList.indexOf("U", 5);
        if (result == 10) {
            System.out.println("Passed test 25");
        } else {
            System.out.println("Failed test 25");
        }

        System.out.println("\nTest 26: indexOf(E item, int pos) method");
        result = strList.indexOf("A", 4);
        if (result == 6) {
            System.out.println("Passed test 26");
        } else {
            System.out.println("Failed test 26");
        }

        System.out.println("\nTest 27: indexOf(E item, int pos) method");
        result = strList.indexOf("I", 7);
        if (result == 8) {
            System.out.println("Passed test 27");
        } else {
            System.out.println("Failed test 27");
        }

        // insert tests
        System.out.println("\nTest 28: insert method");
        strList.insert(0, "new");
        Object[] actual = toArray(strList);
        Object[] expected = new Object[] {"new", "A", "E", "I", "O", "U", "Y", "A", "E", "I", "O", "U", "Y"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 28");
        } else {
            System.out.println("Failed test 28");
        }    
        
        System.out.println("\nTest 29: insert method");
        strList.insert(3, "8");
        actual = toArray(strList);
        expected = new Object[] {"new", "A", "E", "8", "I", "O", "U", "Y", "A", "E", "I", "O", "U", "Y"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 29");
        } else {
            System.out.println("Failed test 29");
        } 

        System.out.println("\nTest 30: insert method");
        strList.insert(strList.size(), "last");
        actual = toArray(strList);
        expected = new Object[] {"new", "A", "E", "8", "I", "O", "U", "Y", "A", "E", "I", "O", "U", "Y", "last"};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 30");
        } else {
            System.out.println("Failed test 30");
        } 

        // makeEmpty tests
        System.out.println("\nTest 31: makeEmpty method");
        strList.makeEmpty();
        actual = toArray(strList);
        expected = new Object[] {};
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 31");
        } else {
            System.out.println("Failed test 31");
        } 

        System.out.println("\nTest 32: makeEmpty method");
        list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.makeEmpty();
        actual = toArray(list);
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 32");
        } else {
            System.out.println("Failed test 32");
        } 

        System.out.println("\nTest 33: makeEmpty method");
        list = new LinkedList<>();
        list.add("o");
        list.add("j");
        list.add("l");
        list.add("5");
        list.add("2");
        list.makeEmpty();
        actual = toArray(list);
        System.out.println( "Expected result: " + Arrays.toString(expected) );
        System.out.println( "Actual result: " + Arrays.toString(actual) );  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 33");
        } else {
            System.out.println("Failed test 33");
        } 

        // boolean remove(E obj) test
        System.out.println("\nTest 34: boolean remove(E obj) method");
        list = new LinkedList<>();
        list.add("o");
        list.add("j");
        list.add("l");
        list.add("5");
        list.add("2");
        boolean removed = list.remove("l");
        actual = toArray(list);
        expected = new Object[] {"o", "j", "5", "2"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && removed) {
            System.out.println("Passed test 34");
        } else {
            System.out.println("Failed test 34");
        }

        System.out.println("\nTest 35: boolean remove(E obj) method");
        removed = list.remove("o");
        actual = toArray(list);
        expected = new Object[] {"j", "5", "2"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && removed) {
            System.out.println("Passed test 35");
        } else {
            System.out.println("Failed test 35");
        }

        System.out.println("\nTest 36: boolean remove(E obj) method");
        removed = list.remove("not here");
        actual = toArray(list);
        expected = new Object[] {"j", "5", "2"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && !removed) {
            System.out.println("Passed test 36");
        } else {
            System.out.println("Failed test 36");
        }

        // E remove(int pos) tests
        System.out.println("\nTest 37: E remove(int pos) method");
        String removedElem = list.remove(1);
        actual = toArray(list);
        expected = new Object[] {"j", "2"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && removedElem.equals("5")) {
            System.out.println("Passed test 37");
        } else {
            System.out.println("Failed test 37");
        }

        System.out.println("\nTest 38: E remove(int pos) method");
        removedElem = list.remove(1);
        actual = toArray(list);
        expected = new Object[] {"j"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && removedElem.equals("2")) {
            System.out.println("Passed test 38");
        } else {
            System.out.println("Failed test 38");
        }

        System.out.println("\nTest 39: E remove(int pos) method");
        removedElem = list.remove(0);
        actual = toArray(list);
        expected = new Object[] {};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && removedElem.equals("j")) {
            System.out.println("Passed test 39");
        } else {
            System.out.println("Failed test 39");
        }

        // removeRange tests
        System.out.println("\nTest 40: removeRange(int start, int stop) method");
        list.add("alpha"); 
        list.add("beta");
        list.add("gamma");
        list.add("delta");
        list.add("epsilon");
        list.add("zeta");
        list.add("eta");
        list.add("theta");
        list.removeRange(1, 4);
        actual = toArray(list);
        expected = new Object[] {"alpha", "epsilon", "zeta", "eta", "theta"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 40");
        } else {
            System.out.println("Failed test 40");
        }

        System.out.println("\nTest 41: removeRange(int start, int stop) method");
        list.removeRange(0, 2);
        actual = toArray(list);
        expected = new Object[] {"zeta", "eta", "theta"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 41");
        } else {
            System.out.println("Failed test 41");
        }

        System.out.println("\nTest 42: removeRange(int start, int stop) method");
        list.removeRange(2, 3);
        actual = toArray(list);
        expected = new Object[] {"zeta", "eta"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 42");
        } else {
            System.out.println("Failed test 42");
        }

        // set method
        System.out.println("\nTest 43: set method");
        list = new LinkedList<>();
        list.add("Q");
        list.add("W");
        list.add("E");
        list.add("R");
        list.add("T");
        list.add("Y");
        String oldValue = list.set(0, "A");
        actual = toArray(list);
        expected = new Object[] {"A", "W", "E", "R", "T", "Y"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && oldValue.equals("Q")) {
            System.out.println("Passed test 43");
        } else {
            System.out.println("Failed test 43");
        }

        System.out.println("\nTest 44: set method");
        oldValue = list.set(4, "B");
        actual = toArray(list);
        expected = new Object[] {"A", "W", "E", "R", "B", "Y"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && oldValue.equals("T")) {
            System.out.println("Passed test 44");
        } else {
            System.out.println("Failed test 44");
        }

        System.out.println("\nTest 45: set method");
        oldValue = list.set(list.size() - 1, "C");
        actual = toArray(list);
        expected = new Object[] {"A", "W", "E", "R", "B", "C"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected) && oldValue.equals("Y")) {
            System.out.println("Passed test 45");
        } else {
            System.out.println("Failed test 45");
        }

        // size tests
        System.out.println("\nTest 46: size method");
        if (list.size() == 6) {
            System.out.println("Passed test 46");
        } else {
            System.out.println("Failed test 46");
        }

        System.out.println("\nTest 47: size method");
        list = new LinkedList<>();
        list.add("Q");
        list.add("W");
        list.add("E");
        list.add("R");
        list.add("T");
        list.add("Y");
        list.add("Q");
        list.add("W");
        list.add("E");
        list.add("R");
        list.add("T");
        list.add("Y");
        if (list.size() == 12) {
            System.out.println("Passed test 47");
        } else {
            System.out.println("Failed test 47");
        }

        System.out.println("\nTest 48: size method");
        list = new LinkedList<>();
        if (list.size() == 0) {
            System.out.println("Passed test 48");
        } else {
            System.out.println("Failed test 48");
        }

        // toString tests
        System.out.println("\nTest 49: toString method");
        if (list.toString().equals("[]")) {
            System.out.println("Passed test 49");
        } else {
            System.out.println("Failed test 49");
        }

        System.out.println("\nTest 50: toString method");
        list.add("A");
        list.add("S");
        list.add("D");
        list.add("F");
        String expectedStr = "[A, S, D, F]";
        if (list.toString().equals(expectedStr)) {
            System.out.println("Passed test 50");
        } else {
            System.out.println("Failed test 50");
        }

        System.out.println("\nTest 51: toString method");
        list = new LinkedList<>();
        list.add("M");
        list.add("N");
        list.add("B");
        expectedStr = "[M, N, B]";
        if (list.toString().equals(expectedStr)) {
            System.out.println("Passed test 51");
        } else {
            System.out.println("Failed test 51");
        }

        // equals tests
        System.out.println("\nTest 52: equals method");
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("L");
        list1.add("K");
        list1.add("J");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("L");
        list2.add("K");
        list2.add("J");
        if (list1.equals(list2)) {
            System.out.println("Passed test 52");
        } else {
            System.out.println("Failed test 52");
        }

        System.out.println("\nTest 53: equals method");
        list1 = new LinkedList<>();
        list1.add("G");
        list1.add("H");
        list1.add("3");
        list2 = new LinkedList<>();
        list2.add("G");
        list2.add("H");
        list2.add("3");
        if (list1.equals(list2)) {
            System.out.println("Passed test 53");
        } else {
            System.out.println("Failed test 53");
        }

        System.out.println("\nTest 54: equals method");
        list2 = new LinkedList<>();
        list2.add("0");
        list2.add("H");
        list2.add("3");
        if (!list1.equals(list2)) {
            System.out.println("Passed test 54");
        } else {
            System.out.println("Failed test 54");
        }

        // iterator hasNext() tests
        System.out.println("\nTest 55: iterator hasNext method");
        Iterator<String> it = list2.iterator();
        if (it.hasNext()) {
            System.out.println("Passed test 55");
        } else {
            System.out.println("Failed test 55");
        }

        System.out.println("\nTest 56: iterator hasNext method");
        it.next();
        it.next();
        it.next();
        if (!it.hasNext()) {
            System.out.println("Passed test 56");
        } else {
            System.out.println("Failed test 56");
        }

        System.out.println("\nTest 57: iterator hasNext method");
        list = new LinkedList<>();
        if (!list.iterator().hasNext()) {
            System.out.println("Passed test 57");
        } else {
            System.out.println("Failed test 57");
        }

        // iterator next() tests
        System.out.println("\nTest 58: iterator next method");
        it = list1.iterator();
        Object resultStr = it.next();
        if (resultStr.equals("G")) {
            System.out.println("Passed test 58");
        } else {
            System.out.println("Failed test 58");
        }

        System.out.println("\nTest 59: iterator next method");
        resultStr = it.next();
        if (resultStr.equals("H")) {
            System.out.println("Passed test 59");
        } else {
            System.out.println("Failed test 59");
        }

        System.out.println("\nTest 60: iterator next method");
        resultStr = it.next();
        if (resultStr.equals("3")) {
            System.out.println("Passed test 60");
        } else {
            System.out.println("Failed test 60");
        }

        // iterator remove() tests
        System.out.println("\nTest 61: iterator remove method");
        list = new LinkedList<>();
        list.add("6");
        list.add("k");
        list.add("a");
        it = list.iterator();
        it.next();
        it.remove();
        actual = toArray(list);
        expected = new Object[] {"k", "a"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 61");
        } else {
            System.out.println("Failed test 61");
        }

        System.out.println("\nTest 62: iterator remove method");
        list = new LinkedList<>();
        list.add("P");
        list.add("O");
        list.add("I");
        it = list.iterator();
        it.next();
        it.remove();
        actual = toArray(list);
        expected = new Object[] {"O", "I"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 62");
        } else {
            System.out.println("Failed test 62");
        }

        System.out.println("\nTest 63: iterator remove method");
        list = new LinkedList<>();
        list.add("Y");
        list.add("H");
        list.add("N");
        it = list.iterator();
        it.next();
        it.next();
        it.remove();
        actual = toArray(list);
        expected = new Object[] {"Y", "N"};
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(actual));  
        if (arraysSame(actual, expected)) {
            System.out.println("Passed test 63");
        } else {
            System.out.println("Failed test 63");
        }
    }


    



    // Convert elements of list to an array. Uses the list
    // size method and iterator.
    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while(it.hasNext()){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }
   
    
    private static final int NUM_DOUBLINGS_OF_N = 5;
    private static final int NUM_REPEATS_OF_TEST = 100;

    // A method to be run to compare the LinkedList you are completing and the Java ArrayList class
    private static void comparison(){
        Stopwatch s = new Stopwatch();
        
        int initialN = 2000;
        addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 4000;
        addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 4000;
        addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 4000;
        removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 4000;
        removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 200000;
        getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 200000;
        getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 200000;
        getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
        getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

        initialN = 200000;
        getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
        initialN = 200000;
        getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

    }

    // These pairs of methods illustrate a failure to use polymorphism
    // If the students had implemented the Java list interface there
    // could be a single method. Also we could use function objects to
    // reduce the awful repitition of code.
    private static void addEndArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: ArrayList", totalTimes, initialN);
    }

    private static void showResults(String title, double[] times, int initialN) {
        System.out.println();
        System.out.println("Number of times test run: " + NUM_REPEATS_OF_TEST);
        System.out.println(title);
        for (double time : times) {
            System.out.print("N = " + initialN + ", total time: ");
            System.out.printf("%7.4f\n", time);
            initialN *= 2;
        }
        System.out.println();
    }

    private static void addEndLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at end: LinkedList", totalTimes, initialN);
    }

    private static void addFrontArrayList(Stopwatch s, int initialN, int numTests){ 
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    javaList.add(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: ArrayList", totalTimes, initialN);
    }

    private static void addFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                s.start();
                for (int j = 0; j < n; j++) {
                    studentList.insert(0, j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Adding at front: LinkedList", totalTimes, initialN);
    }

    private static void removeFrontArrayList(Stopwatch s, int initialN, int numTests){     
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<String> javaList = new ArrayList<>();
                for(int j = 0; j < n; j++)
                    javaList.add(j + "");
                s.start();
                while (!javaList.isEmpty()) {
                    javaList.remove(0);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Removing from front: ArrayList", totalTimes, initialN);
    }

    private static void removeFrontLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;    
            for (int i = 0; i < numTests; i++) {
                LinkedList<String> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j + "");
                }
                s.start();
                while (studentList.size() != 0) {
                    studentList.removeFirst();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("removing from front: LinkedList", totalTimes, initialN);
    }

    private static void getRandomArrayList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            int total = 0;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                for (int j = 0; j < n; j++) {
                    total += javaList.get(r.nextInt(javaList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: ArrayList", totalTimes, initialN);
    }

    private static void getRandomLinkedList(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];     
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            Random r = new Random();
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                int total = 0;
                s.start();
                for (int j = 0; j < n; j++) {
                    total += studentList.get(r.nextInt(studentList.size()));
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting random: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingIterator(Stopwatch s, int initialN, int numTests){

        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for(int i = 0; i < numTests; i++){
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                Iterator<Integer> it = javaList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }        
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingIterator(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                Iterator<Integer> it = studentList.iterator();
                s.start();
                int total = 0;
                while (it.hasNext()) {
                    total += it.next();
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using iterator: LinkedList", totalTimes, initialN);
    }

    private static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                ArrayList<Integer> javaList = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    javaList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < javaList.size(); j++) {
                    x += javaList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: ArrayList", totalTimes, initialN);
    }

    private static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN, int numTests){
        double[] totalTimes = new double[numTests];        
        for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
            int n = initialN;
            for (int i = 0; i < numTests; i++) {
                LinkedList<Integer> studentList = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    studentList.add(j);
                }
                s.start();
                int x = 0;
                for (int j = 0; j < studentList.size(); j++) {
                    x += studentList.get(j);
                }
                s.stop();
                totalTimes[i] += s.time();
                n *= 2;
            }
        }
        showResults("Getting all using get method: LinkedList", totalTimes, initialN);
    }
}
