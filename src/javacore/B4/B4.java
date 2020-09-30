package javacore.B4;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Dot {
    private int x;
    private int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dot(Dot dot, int maxDistance) {
        int newY = ThreadLocalRandom.current().nextInt((int) Math.round(dot.getY() - maxDistance), (int) Math.round(maxDistance + dot.getY()));
        int temp = maxDistance * maxDistance - (newY - dot.getY()) * (newY - dot.getY());
        if(temp < 0) temp = 0;
        this.x = ThreadLocalRandom.current().nextInt(
                (int) Math.floor(dot.getX() - Math.sqrt(temp)),
                (int) Math.floor(dot.getX() + Math.sqrt(temp))
        );
        this.y = newY;
    }
}

public class B4 {
    public static void main(String[] args) {
        Dot A = new Dot(800, 800);
        Dot B = new Dot(4000, 800);
        Dot C = new Dot(2400, 2400);
        ArrayList<Dot> dotList = new ArrayList<>();
        for (int i = 0; i < 8000; ++i) {
            Dot newDot = new Dot(A, 400);
//            dotList.add(newDot);
            System.out.println(i + ": " + newDot.getX() + " " + newDot.getY());
        }
//        dotList.forEach((e) -> {
//            System.out.println(e.getX() + " " + e.getY());
//        });
    }
}
