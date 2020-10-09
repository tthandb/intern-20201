package javaCore.B3;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.zip.CheckedOutputStream;

public class B3 {
    public static HashMap<String, Integer> globalFreq = new HashMap<String, Integer>();

    public static class CountWord implements Runnable {
        Integer id;

        public CountWord(Integer id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(id + " run");
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
                for (String key : wordList) {
                    int freq = globalFreq.getOrDefault(key, 0);
                    globalFreq.put(key, ++freq);
                }
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService es = Executors.newFixedThreadPool(6);
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 21; ++i) {
            CountWord task = new CountWord(i);
            futureList.add(CompletableFuture.runAsync(task, es));
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]))
                .whenComplete((input, exception) -> {
                    HashMap<String, Integer> sortedWordList = sortByValue(globalFreq);
                    int cnt = 0;
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/javaCore/B3/output.txt"))) {
                        for (Map.Entry<String, Integer> result : sortedWordList.entrySet()) {
                            cnt++;
                            if (cnt == 10) break;
                            bufferedWriter.write(result.getKey() + " " + result.getValue() + "\n");
//                            System.out.println(result.getKey() + " " + result.getValue());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Done");
                });
        es.shutdown();
    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(hm.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
}

