package me.jihooo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private static final String RESOURCES = "src/main/resources/";

    public List<Books> bookAnalyze(final String fileName) {
   final Path path = Paths.get(RESOURCES + fileName);

            List<Books> list = new ArrayList<>();

     try {
         List<String> lines = Files.readAllLines(path);
            for(String a : lines) {

                String[] arr = a.split(",");
                String bookName = arr[0];
                String category = arr[1];
                String yesorno = arr[2];
                Books book = new Books(bookName, category, yesorno);
                list.add(book);
            }

     } catch (IOException e) {
         e.printStackTrace();
     }
        return list;
    }

    public List<Members> memberAnalyze(final String fileName) {
        final Path path = Paths.get(RESOURCES + fileName);

        List<Members> list = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(path);

                for(String a : lines) {

                    String[] arr = a.split("\t");
                    String name = arr[0];
                    String bookName = arr[1];
                    String expectedRD = arr[2];
                    String realRD = arr[3];
                    Members member = new Members(name, bookName, expectedRD, realRD);
                    list.add(member);
                }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
