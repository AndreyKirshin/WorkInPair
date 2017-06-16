import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Networking {

    public static final String HORSTMAN_COM = "horstmann.com";
    public static final String DST_DIR = ".\\Pictures\\";

    public static void main(String[] args) throws IOException {

        List<String> pics = getReferencesToPictures(HORSTMAN_COM);

        for (String s : pics){
            String fileName = getFileName(s);
            savePicture(s, fileName);
        }

    }

    private static String getFileName(String s) {
        String[] ss = s.split("/");
        return ss[ss.length - 1];
    }

    private static void savePicture(String reference, String filename) throws IOException {
        URL url = new URL("http://" + HORSTMAN_COM + "/" + reference);
        URLConnection urlConnection = url.openConnection();

        InputStream is = urlConnection.getInputStream();

        File picName = new File(DST_DIR + filename);
        OutputStream os = new FileOutputStream(picName);
        byte[] buf = new byte[2048];

        int c = is.read(buf);
        while (c > 0){
            os.write(buf, 0, c);
            c = is.read(buf);
        }
        os.flush();
        os.close();
        is.close();
    }


    private static List<String> getReferencesToPictures(String urlStr) throws IOException {
        Document document = Jsoup.connect("http://" + urlStr).get();
        Elements elements = document.getElementsByTag("img");

        List<String> images = elements.eachAttr("src");

        System.out.println(images);

        return images;
    }
}
