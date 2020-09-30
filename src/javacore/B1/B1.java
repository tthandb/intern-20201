package javacore.B1;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class B1 {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("src/javacore/test.txt");
        BufferedWriter buffer = new BufferedWriter(writer);
        buffer.write("Welcome to java.");
        buffer.write("Welcome to java.");
        buffer.write("Welcome to java.");
        buffer.close();
        System.out.println("Success...");
    }
}