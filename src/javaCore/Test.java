package javaCore;


import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = IntStream.range(1, 200001).toArray();
        int[] arr2 = IntStream.range(100000, 300000).toArray();
        for (int e:arr1){
            System.out.println(e);
        }
    }
}
