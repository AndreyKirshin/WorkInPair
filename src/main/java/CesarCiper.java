import sun.nio.cs.StandardCharsets;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CesarCiper {
    public static void main(String[] args) throws IOException {
        int d = Integer.parseInt(args[0]);
        String inputFile = args[1];
        String outputFile = args[2];
        String key = args[3];

        System.out.println(inputFile + " " + outputFile);


        Writer writer = new FileWriter(outputFile);
        Reader reader = new FileReader(inputFile);
        String buf;
        try {
            buf = new String(Files.readAllBytes(Paths.get(inputFile)));
            writer.write(ceasar(buf, d));
            writer.close();
        } catch (Exception exp) {
        }

        File decodeFile = new File("decode.txt");
        Writer decodeWriter = new FileWriter(decodeFile);
        if (key.equals("-d") && (!outputFile.isEmpty())) {
            System.out.println(key);
            d = d*(-1);
            System.out.println(d);
            try {
                buf = new String(Files.readAllBytes(Paths.get(outputFile)));
                String encodedStr = ceasar(buf, d);
                decodeWriter.write(encodedStr);
            } catch (Exception exp) {
            }
        }

        reader.close();
        writer.close();
        decodeWriter.close();
    }

    public static String ceasar(String s, int d) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char enc = (char) (c + d);
            str = str + enc;
        }
        return str;
    }
}
