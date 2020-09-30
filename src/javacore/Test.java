package javacore;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args) {

//        Dot A = new Dot(800, 800);
//        Dot B = new Dot(4000, 800);
//        Dot C = new Dot(2400, 2400);
//        ArrayList<Dot> dotList = new ArrayList<>();
//        for (int i = 0; i < 8000; ++i) {
//            Dot newDot = new Dot(A, 400);
//            dotList.add(newDot);
//        }
//        dotList.forEach((e) -> {
//            System.out.println(e.getX() + " " + e.getY());
//        });
        int newY = ThreadLocalRandom.current().nextInt(0,0);
        System.out.println(newY);
    }
}
