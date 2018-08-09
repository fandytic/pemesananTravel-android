package com.fancik.travelb;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Fandy TIC on 15/01/2018.
 */

public class HttpHandler {
    private static final String TAG =
            HttpHandler.class.getSimpleName();
    public static final String MYURL = "http://192.168.31.188/TravelB/";
    public static final String VIEW = "view.php";
    public static final String INSERT = "insert.php";
    public static final String INSERT2 = "insert2.php";
    public static final String UPDATE = "update.php";
    public static final String DELETE = "delete.php";
    public HttpHandler() {
    }
    public String callJson() {
        String response = null;
        try {
            URL url = new URL(MYURL + VIEW);
            HttpURLConnection conn = (HttpURLConnection)
                    url.openConnection();
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new
                    BufferedInputStream(conn.getInputStream());
            response = convertStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " +
                    e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " +
                    e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    public String sendJson(String url, Member member) {
        InputStream inputStream = null;
        String result = "";
        try {

// create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
// make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);
            String json = "";
// build jsonObject

            JSONObject jsonObj = new JSONObject();
            jsonObj.accumulate(Static.ID, member.getId());
            jsonObj.accumulate(Static.NOHP,member.getNohp());
            jsonObj.accumulate(Static.PASS,member.getPass());
            jsonObj.accumulate(Static.NAMA,member.getNama());
            jsonObj.accumulate(Static.ALAMAT,member.getAlamat());

// convert JSONObject to JSON to String
            json = jsonObj.toString();


// set json to StringEntity
            StringEntity se = new StringEntity(json);

// set httpPost Entity
            httpPost.setEntity(se);

            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type","application/json");
            HttpResponse httpResponse =
                    httpclient.execute(httpPost);
            // receive response as inputStream
            inputStream =
                    httpResponse.getEntity().getContent();
            // convert inputstream to string
            if (inputStream != null)
                result =
                        convertStreamToString(inputStream);
            else
                result = "Did not work!";
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return result;
    }

    public String sendJson2(String url, Pesanan pesanan) {
        InputStream inputStream = null;
        String result = "";
        try {

// create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
// make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);
            String json = "";
// build jsonObject

            JSONObject jsonObj = new JSONObject();
            jsonObj.accumulate(Static.ID, pesanan.getId());
            jsonObj.accumulate(Static.NOHP,pesanan.getNohp());
            jsonObj.accumulate(Static.NAMA,pesanan.getNama());
            jsonObj.accumulate(Static.ALAMAT,pesanan.getAlamat());
            jsonObj.accumulate(Static.JUMLAH,pesanan.getJumlah());
            jsonObj.accumulate(Static.DUDUK,pesanan.getDuduk());
            jsonObj.accumulate(Static.JAM,pesanan.getJam());

// convert JSONObject to JSON to String
            json = jsonObj.toString();


// set json to StringEntity
            StringEntity se = new StringEntity(json);

// set httpPost Entity
            httpPost.setEntity(se);

            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type","application/json");
            HttpResponse httpResponse =
                    httpclient.execute(httpPost);
            // receive response as inputStream
            inputStream =
                    httpResponse.getEntity().getContent();
            // convert inputstream to string
            if (inputStream != null)
                result =
                        convertStreamToString(inputStream);
            else
                result = "Did not work!";
        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }
        return result;
    }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(is));

        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
