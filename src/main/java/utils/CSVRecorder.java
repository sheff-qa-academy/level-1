package utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVRecorder {

    public static void writeToCSV(List<WebElement> elementList, String attribute, String fileName) {

        try {

            CSVWriter writer = new CSVWriter(new FileWriter(fileName));
            String[] record = new String[elementList.size()];
            for (int i = 0; i < elementList.size(); i++) {
                record[i] = elementList.get(i).getAttribute(attribute);
            }
            writer.writeNext(record);
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public static List<String[]> readFromCSV(String fileName) {

        List<String[]> allData = null;

        try {

            FileReader filereader = new FileReader(fileName);
            CSVReader csvReader = new CSVReaderBuilder(filereader).build();
            allData = csvReader.readAll();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return allData;
    }
}

