package javaCore.B1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class B1 {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("src/javaCore/B1/test.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        int[] arr1 = IntStream.range(1, 200001).toArray();
        int[] arr2 = IntStream.range(100000, 300000).toArray();
        List<Integer> list1 = IntStream.of(arr1).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.of(arr2).boxed().collect(Collectors.toList());
        HashSet<Integer> set1 = new HashSet<>(list1);
       HashSet<Integer> set2 = new HashSet<>(list2);
        HashSet<Integer> unionSet = (HashSet<Integer>) set1.clone();
        HashSet<Integer> intersectionSet = (HashSet<Integer>) set1.clone();
        unionSet.addAll(set2);
        intersectionSet.retainAll(set2);
        buffer.write("unionSet: " + unionSet.toString());
        buffer.write("intersectionSet: " + intersectionSet.toString());
        buffer.close();
    }
}