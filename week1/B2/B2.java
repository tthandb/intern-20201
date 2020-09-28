package B2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class B2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("week1/B2/input.txt"));
        while (scanner.hasNext()) {
            String mes = scanner.next("\\w+");
            System.out.println(mes);
        }
    }
}