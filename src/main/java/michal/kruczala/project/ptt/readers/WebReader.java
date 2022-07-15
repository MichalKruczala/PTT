package michal.kruczala.project.ptt.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebReader {
    public String downloadWebPage(String url) throws IOException {
        URLConnection urlConnection = getUrlConnection(url);
        StringBuilder result = readWebPage(urlConnection);
        return result.toString();

    }
    private URLConnection getUrlConnection(String url) throws IOException {
        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla");
        urlConnection.setReadTimeout(5000);
        urlConnection.setConnectTimeout(5000);
        return urlConnection;
    }
    private static StringBuilder readWebPage(URLConnection urlConnection) throws IOException {
        StringBuilder result = new StringBuilder();


        try (InputStream is = urlConnection.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            String line;

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }
        return result;
    }

}