package javaCore.B3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class B3 {
    public static HashMap<String, Integer> globalFreq = new HashMap<String, Integer>();

    public static class CountWord implements Runnable {
        String name;
        Integer id;

        public CountWord(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            File input = new File("src/javaCore/B3/input/" + this.id + ".txt");
            ArrayList<String> wordList = new ArrayList<String>();
//            HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/javaCore/B3/output.txt"));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    wordList.addAll(Arrays.asList(line.split("\\W+")));
                }
                for (int i = 0; i < wordList.size(); ++i) {
                    wordList.set(i, wordList.get(i).toLowerCase());
                }
                for (String key : wordList) {
                    int freq = globalFreq.getOrDefault(key, 0);
                    globalFreq.put(key, ++freq);
                }
                bufferedReader.close();
                for (Map.Entry<String, Integer> result : globalFreq.entrySet()) {
                    bufferedWriter.write(result.getKey() + " " + result.getValue() + "\n");
                    System.out.println(result.getKey() + " " + result.getValue());
                }
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void blabla(){
        ExecutorService es = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 21; ++i) {
            CountWord task = new CountWord(i);
            es.submit(task);
        }
        es.shutdown();
    }
    public static void main(String[] args) {
        blabla();
        System.out.println("end");
    }
}
