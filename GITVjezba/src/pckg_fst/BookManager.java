package pckg_fst;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookManager {
    private Map<String, List<String>> authorTitlesMap = new HashMap<>();

    public void addNewEntry(String author, String title){
        authorTitlesMap.computeIfAbsent(author, k -> new ArrayList<>()).add(title);
    }

    public void listAllAuthorsThatBeginsWith(String letter){
        for(String author: authorTitlesMap.keySet()){
            if (author.startsWith(letter)){
                System.out.println(author);
            }
        }
    }

    public void listAllTitlesForAuthor(String author){
        List<String> titles = authorTitlesMap.get(author);
        if(titles == null){
            System.out.println("No titles found for author " + author);
        }else{
            for(String title:titles){
                System.out.println(title);  
            }
        }
    }

    public void populatedDataFromFile(String filePath){
        Path path = Paths.get(filePath);
        try(BufferedReader reader = Files.newBufferedReader(path)){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("-");
                if(parts.length == 2){
                    addNewEntry(parts[0].trim(), parts[1].trim());
                }
            }
        }catch (IOException ioe){
            System.out.println("Greska pri ucitavanju: " + ioe.getMessage());
        }
    }

    public void printAuthorTitles(){
        for(Map.Entry<String, List<String>> entry : authorTitlesMap.entrySet()){
            for(String title : entry.getValue()){
                System.out.println(entry.getKey() + " - " + title);
            }
        }
    }

    public void writeDataIntoFile(String filePath){
        Path path = Paths.get(filePath);
        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            for(Map.Entry<String, List<String>> entry : authorTitlesMap.entrySet()){
                for(String title: entry.getValue()){
                    writer.write(entry.getKey() + " - " + title);
                    writer.newLine();
                }
            }
        }catch(IOException ioe){
            System.out.println("Greska pri pisanju: " + ioe.getMessage());
        }
    }
}
