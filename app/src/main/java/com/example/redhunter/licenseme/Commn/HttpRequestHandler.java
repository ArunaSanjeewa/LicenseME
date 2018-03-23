package com.example.redhunter.licenseme.Commn;

/**
 * Created by RedHunter on 1/10/2018.
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/**
 * Created by uer on 1/19/2017.
 */


public class HttpRequestHandler {

    public String send(String url, HttpMethod method, String token, JSONObject requestJson){
        try {
            String json = "";

            InputStream responseStream = null;
            String result = "{}";
            DefaultHttpClient httpClient = new DefaultHttpClient();

            switch (method){
                case POST:
                {
                    HttpPost request = new HttpPost(url);
                    request.setHeader(new BasicHeader("Content-Type","application/json"));
                    request.setHeader(new BasicHeader("x-access-token",token));

                    json = requestJson.toString();
                    StringEntity se = new StringEntity(json);
                    request.setEntity(se);

                    HttpResponse response = httpClient.execute(request);
                    responseStream = response.getEntity().getContent();
                    break;
                }
                case GET:
                {


                    //  System.out.println(url);
                    url += "?token=" + token + getQueryString(requestJson);

                    HttpGet httpGet = new HttpGet(url);
                    //   System.out.println(httpGet);
                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    //System.out.println("asdfagdhjlqa");
                    HttpEntity httpEntity = httpResponse.getEntity();
                    //  System.out.println(httpEntity);
                    responseStream = httpEntity.getContent();
                    System.out.println("re");
                    break;

                }
            }
            if(responseStream != null)
                result = convertInputStreamToString(responseStream);
            else
                result = "Did not work!";
            System.out.println("Did not work!");

            return result;

        }catch (Exception ex){
            System.out.println(ex+"dlfkdlfkldkfl");
            return "{}";
        }
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private String getQueryString(JSONObject json ){
        StringBuilder sb = new StringBuilder();
        try {

            Iterator<String> keys = json.keys();
            sb.append("&");
            while (keys.hasNext()) {
                String key = keys.next();
                sb.append(key);
                sb.append("=");
                sb.append(json.get(key));
                sb.append("&");
            }
        }catch (Exception ex){

        }
        return sb.toString();
    }
}



