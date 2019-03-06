package ru.course.lambda.expressions.homework.MA;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

public class HttpGet {
    private String link;
    static InputStream content;

    public HttpGet(String link) {
        this.link = link;
    }

    public static InputStream getHttp(CloseableHttpClient httpclient, CloseableHttpResponse response) {
        httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://targethost/homepage");
        try {
            response = httpclient.execute((HttpUriRequest) httpGet);
        } catch (IOException e) {
            System.out.println("IO ex" + e);
        }
        try {
            content = response.getEntity().getContent();
        } catch (IOException e) {
            System.out.println("IO ex" + e);
        }
    return content;
    }
}
