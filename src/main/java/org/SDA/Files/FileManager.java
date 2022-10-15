package org.SDA.Files;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.SDA.Polymorphism.Dog;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String myFileDirectory = "C:\\Users\\matur\\Desktop";

    public static void example() {
        String filePath = myFileDirectory + "\\dog.json";
        // Dog dog = new Dog("Rex", 10, "German Shepherd");
        // writeToJson(filePath, dog);
        Dog dog = readFromJSON(filePath, Dog.class);
        System.out.println(dog);
    }

    public static void writeToTextFile(String filePath, String text) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(text);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void writeToTextFile(String filePath, String[] lines) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

            for (String line : lines) {
                bw.write(line);
                bw.write("\n");
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static String readFromTextFile(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String wholeText = "";
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                wholeText += "\n" + currentLine;
            }

            return wholeText;
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            return null;
        } catch (IOException e) {
            System.out.println("Error");
            return null;
        }
    }

    public static List<String> readLinesFromTextFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                lines.add(currentLine);
            }

            return lines;
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            return null;
        } catch (IOException e) {
            System.out.println("Error");
            return null;
        }
    }

    public static List<String[]> readFromCSVFilePrimitive(String filePath) {
        List<String[]> result = new ArrayList<>();
        List<String> lines = readLinesFromTextFile(filePath);

        for (String line : lines) {
            String[] cells = line.split("\t");
            result.add(cells);
        }

        return result;
    }

    public static List<String[]> readFromCSVFile(String filePath) {
        List<String[]> records = new ArrayList<>();

        try {
            CSVReader csvReader = new CSVReader(new FileReader(filePath), '\t');
            String[] nextRecord;

            while ((nextRecord = csvReader.readNext()) != null) {
                records.add(nextRecord);
            }

            return records;
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            return null;
        } catch (IOException e) {
            System.out.println("Error");
            return null;
        }
    }

    public static void writeToCSVFile(String filePath, List<String[]> values) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath));
            csvWriter.writeAll(values);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static <T> T readFromJSON(String filePath, Class<T> clazz) {
        Gson gson = new Gson();
        String json = readFromTextFile(filePath);
        T obj = gson.fromJson(json, clazz);
        return obj;
    }

    public static <T> void writeToJson(String filePath, T obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        writeToTextFile(filePath, json);
    }
}
