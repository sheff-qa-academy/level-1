package utils;

import com.opencsv.CSVWriter;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
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
}
