import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 26.05.2017.
 */
public class FrequencyWords {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("war_and_peace.txt");
        Scanner fileScanner = new Scanner(file);

        Pattern pattern = Pattern.compile("(\\w{3,})");
        Matcher matcher;

        List<String> words = new ArrayList<>();
        while (fileScanner.hasNextLine()) {
            String string = fileScanner.nextLine();
            matcher = pattern.matcher(string);
            while (matcher.find()) {
                words.add(matcher.group(1));
            }
        }

        Map<String, Integer> mapOfWords = new HashMap<>();
        for (String word : words) {
            if (mapOfWords.containsKey(word)) {
                mapOfWords.put(word, mapOfWords.get(word) + 1);
            } else mapOfWords.put(word, 1);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(mapOfWords.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -(o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> res = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            res.put(entry.getKey(), entry.getValue());
        }

        for (int i = 0; i < 10; i++) {
            String theBestWord = (String) res.keySet().toArray()[i];
            System.out.println("№" + (i + 1) + " " + theBestWord + " -> " + res.get(theBestWord));
        }

    }
}


