package javacore.B1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashSet;

public class B1 {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("src/javacore/test.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.close();
        Integer[] list1 = {1, 2,  4, 5};
        Integer[] list2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(list1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(list2));
        HashSet<Integer> unionSet = (HashSet<Integer>) set1.clone();
        HashSet<Integer> intersectionSet = (HashSet<Integer>) set1.clone();
        unionSet.addAll(set2);
        intersectionSet.retainAll(set2);
        System.out.println("set1: " + set1.toString());
        System.out.println("set2: " + set2.toString());
        System.out.println("unionSet: " + unionSet.toString());
        System.out.println("intersectionSet: " + intersectionSet.toString());
    }
}