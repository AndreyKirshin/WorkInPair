import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Networking {

    public static final String HORSTMAN_COM = "horstmann.com";
    public static final String DST_DIR = ".\\Pictures\\";

    public static void main(String[] args) throws IOException {

        List<String> pics = getReferencesToPicturesRegExp(HORSTMAN_COM);
        System.out.println(pics);
//        List<String> pics = getReferencesToPicturesJsoup(HORSTMAN_COM);

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
    private static InputStream connectWithPage(String urlStr) throws IOException{
        URL url = new URL("http://" + HORSTMAN_COM);
        URLConnection urlConnection = url.openConnection();

        InputStream is = urlConnection.getInputStream();

        return is;
    }

    private static List<String> getReferencesToPicturesRegExp(String urlStr) throws IOException {
        Pattern p = Pattern.compile("img.* src=\"(.*?)\"");

        InputStream is = connectWithPage(urlStr);
        Scanner scanner = new Scanner(is);
        List<String> images = new ArrayList<>();

        while (scanner.hasNext()){
            Matcher m = p.matcher(scanner.nextLine());
            if(m.find()){
                images.add(m.group(1));
            }
        }

        return images;
    }

    private static List<String> getReferencesToPicturesJsoup(String urlStr) throws IOException {
        Document document = Jsoup.connect("http://" + urlStr).get();
        System.out.println(document);
        Elements elements = document.getElementsByTag("img");
        List<String> images = elements.eachAttr("src");

        //System.out.println(images);

        return images;
    }
}
