package B2;

import java.io.*;
import java.util.*;

public class B2 {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("week1/B2/input.txt");
        File output = new File("week1/B2/output.txt");
        ArrayList<String> wordList = new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordList.addAll(Arrays.asList(line.split("\\W+")));
            }
            for (int i = 0; i < wordList.size(); ++i) {
                wordList.set(i, wordList.get(i).toLowerCase());
            }
            HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
            for (String key : wordList) {
                int freq = freqMap.getOrDefault(key, 0);
                freqMap.put(key, ++freq);
            }
            bufferedReader.close();
            for (Map.Entry<String, Integer> result : freqMap.entrySet()) {
                bufferedWriter.write(result.getKey() + " " + result.getValue());
                System.out.println(result.getKey() + " " + result.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}