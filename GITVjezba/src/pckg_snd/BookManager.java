package pckg_snd;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class BookManager {
    private Map<String, List<String>> authorTitlesMap = new HashMap<>();

    public void addNewEntry(String author, String title) {
        authorTitlesMap.computeIfAbsent(author, k -> new ArrayList<>()).add(title);
    }

    public void listAllAuthorsThatBeginsWith(String prefix) {
        for (String author : authorTitlesMap.keySet()) {
            if (author.startsWith(prefix)) {
                System.out.println(author);
            }
        }
    }

    public void listAllTitlesForAuthor(String author) {
        List<String> titles = authorTitlesMap.get(author);
        if (titles != null) {
            for (String title : titles) {
                System.out.println(title);
            }
        } else {
            System.out.println("Autor nije pronađen: " + author);
        }
    }

    public void populateDataFromFile(String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" - ");
                if (parts.length == 2) {
                    addNewEntry(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException ioe) {
            System.err.println("Greška pri učitavanju: " + ioe.getMessage());
        }
    }

    public void printAuthorTitles() {
        for (Map.Entry<String, List<String>> entry : authorTitlesMap.entrySet()) {
            for (String title : entry.getValue()) {
                System.out.println(entry.getKey() + " - " + title);
            }
        }
    }

    public void writeDataIntoFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createDirectories(path.getParent());
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                for (Map.Entry<String, List<String>> entry : authorTitlesMap.entrySet()) {
                    for (String title : entry.getValue()) {
                        writer.write(entry.getKey() + " - " + title);
                        writer.newLine();
                    }
                }
            }
        } catch (IOException ioe) {
            System.err.println("Greška pri spremanju: " + ioe.getMessage());
        }
    }
}