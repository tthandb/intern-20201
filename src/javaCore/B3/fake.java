package javaCore.B3;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class fake {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<String> webPageLinks = Arrays.asList( //
                "https://www.google.com.vn/", "https://vnexpress.net/", "https://gpcoder.com/");
        List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
                .map(webPageLink -> downloadWebPage(webPageLink)).collect(Collectors.toList());
        CompletableFuture<Void> allFutures = CompletableFuture
                .allOf(pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()]));
        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
            return pageContentFutures.stream().map(pageContentFuture -> pageContentFuture.join())
                    .collect(Collectors.toList());
        });
        CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
            return pageContents.stream().filter(pageContent -> pageContent.contains("CompletableFuture")).count();
        });
        System.out.println("Number of Web Pages having CompletableFuture keyword: " + countFuture.get());
    }
    public static CompletableFuture<String> downloadWebPage(String pageLink) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Downloading: " + pageLink);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "CompletableFuture Completed";
        });
    }
}

