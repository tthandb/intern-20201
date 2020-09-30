package javacore.B4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

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
        int m = maxDistance * maxDistance - (newY - dot.getY()) * (newY - dot.getY());
        int origin = (int) Math.floor(dot.getX() - Math.sqrt(m));
        int bound = (int) Math.floor(dot.getX() + Math.sqrt(m));
        if (origin == bound) this.x = origin;
        else
            this.x = ThreadLocalRandom.current().nextInt(origin, bound);
        this.y = newY;
    }
}

public class B4 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("src/javacore/B4/output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Dot A = new Dot(800, 800);
            Dot B = new Dot(4000, 800);
            Dot C = new Dot(2400, 2400);
            ArrayList<Dot> dotList = new ArrayList<>();
            for (int i = 0; i < 8000; ++i) {
                Dot newDot = new Dot(A, 400);
                dotList.add(newDot);
            }
            for (int i = 0; i < 10000; ++i) {
                Dot newDot = new Dot(B, 500);
                dotList.add(newDot);
            }
            for (int i = 0; i < 12000; ++i) {
                Dot newDot = new Dot(B, 600);
                dotList.add(newDot);
            }
            Collections.shuffle(dotList);
            dotList.forEach((e) -> {
                try {
                    bufferedWriter.write(e.getX() + " " + e.getY() + "\n");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
