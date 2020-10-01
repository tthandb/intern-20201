package javaCore.B3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
            System.out.println("-----------------------------------------");
//            System.out.println(this.id + " run");
//            System.out.println("-----------------------------------------");
            File input = new File("src/javaCore/B3/input/" + this.id + ".txt");
            ArrayList<String> wordList = new ArrayList<String>();
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
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
                }
                freqMap.forEach((key, value) -> {
                    globalFreq.put(key, globalFreq.get(key) + value);
                });
                bufferedReader.close();
//                for (Map.Entry<String, Integer> result : freqMap.entrySet()) {
//                    System.out.println(result.getKey() + " " + result.getValue());
//                }

            } catch (IOException e) {
                e.printStackTrace();
            }

//            System.out.println("-----------------------------------------");
//            System.out.println(this.id + " end");
//            System.out.println("-----------------------------------------");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 21; ++i) {
            CountWord runnable = new CountWord(i);
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Run");
        for (Map.Entry<String, Integer> result : globalFreq.entrySet()) {
            System.out.println(result.getKey() + " " + result.getValue());
        }
    }
}
