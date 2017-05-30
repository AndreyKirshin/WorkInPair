import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 26.05.2017.
 */
public class SimvolStatistic {
    public static void main(String[] args) throws IOException {
        //System.out.println(loadStringFromFile());
        System.out.println(calculateFrequency());
    }

    private static Map calculateFrequency() throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        String string = loadStringFromFile();
        //System.out.println(string);
        for (int i = 0; i < string.length(); i++) {
            char c = Character.toLowerCase(string.charAt(i));
            if ((c >= 'a') && (c <= 'z')) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else map.put(c, 1);
            }
        }
        return map;
    }

    private static String loadStringFromFile() throws IOException {
        Class<SimvolStatistic> clss = SimvolStatistic.class;
        String stringFullFile;
        try (InputStream inputStream = clss.getResourceAsStream("war_and_peace.txt")) {
            System.out.println(inputStream);
            try (ByteArrayOutputStream byteStream = new ByteArrayOutputStream()) {
                byte[] buff = new byte[4096];
                int length;
                while ((length = inputStream.read(buff)) != -1) {
                    byteStream.write(buff, 0, length);
                }
                stringFullFile = byteStream.toString("UTF-8");
                return stringFullFile;
            }
        }

    }
}
