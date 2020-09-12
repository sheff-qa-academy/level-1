package checks;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckCollectionAttribute {

    private String result = "";

    public boolean isCollectionsAttributeEquals(List<String> elementsList, List<String[]> string) {

        List<String> list = new ArrayList<>();
        int count = 0;

        if (elementsList.size() != list.size()) {
            result += "The quantity of elements is not equal: " + elementsList.size() + " and " + list.size() + " elements. ";
        }

        for (String[] strings : string) {
            list.addAll(Arrays.asList(strings));
        }

        StringBuilder resultBuilder = new StringBuilder(result);
        for (int i = 0; i < elementsList.size();) {

            if (list.get(i).equalsIgnoreCase(elementsList.get(i))) {
                i++;
            } else {
                resultBuilder.append(" ").append(list.get(i)).append(" : ").append(elementsList.get(i)).append(".");
                count++;
                i++;
            }

        }
        result = resultBuilder.toString();

        return (count == 0);
    }

    public String getResult() {
        return result;
    }
}
