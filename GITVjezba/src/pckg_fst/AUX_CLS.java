package pckg_fst;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AUX_CLS {

    public static void addNewEntry(TreeMap<String, ArrayList<String>> map, String author, String title) {
        map.computeIfAbsent(author, k -> new ArrayList<>()).add(title);
    }

    public static TreeMap<String, ArrayList<String>> authorTitles(ArrayList<String[]> data) {
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        for (String[] pair : data) {
            if (pair.length == 2) {
                addNewEntry(map, pair[0].trim(), pair[1].trim());
            }
        }
        return map;
    }

    public static void listAllAuthorsThatBeginsWith(TreeMap<String, ArrayList<String>> map, String prefix) {
        for (String author : map.keySet()) {
            if (author.startsWith(prefix)) {
                System.out.println(author);
            }
        }
    }

    public static void listAllTitlesForAuthor(TreeMap<String, ArrayList<String>> map, String author) {
        ArrayList<String> titles = map.get(author);
        if (titles != null) {
            for (String title : titles) {
                System.out.println(title);
            }
        } else {
            System.out.println("Autor nije pronađen: " + author);
        }
    }

    public static ArrayList<String[]> parseAuthorTitleData(String data) {
        ArrayList<String[]> list = new ArrayList<>();
        String[] lines = data.split("\\r?\\n");
        for (String line : lines) {
            String[] parts = line.split(" - ");
            if (parts.length == 2) {
                list.add(new String[]{parts[0], parts[1]});
            }
        }
        return list;
    }

    public static void printAuthorTitles(TreeMap<String, ArrayList<String>> map) {
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            for (String title : entry.getValue()) {
                System.out.println(entry.getKey() + " - " + title);
            }
        }
    }

    public static String readTxtFile(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException ioe) {
            System.err.println("Greška pri čitanju datoteke: " + ioe.getMessage());
            return "";
        }
    }

    public static void writeDataIntoFile(TreeMap<String, ArrayList<String>> map, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createDirectories(path.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
                    for (String title : entry.getValue()) {
                        writer.write(entry.getKey() + " - " + title);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException ioe) {
            System.err.println("Greška pri pisanju datoteke: " + ioe.getMessage());
        }
    }
}
