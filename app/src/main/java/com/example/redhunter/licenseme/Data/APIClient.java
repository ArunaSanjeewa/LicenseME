package com.example.redhunter.licenseme.Data;

/**
 * Created by RedHunter on 1/10/2018.
 */


import android.util.Log;

import com.example.redhunter.licenseme.AppConstant.AppConstants;
import com.example.redhunter.licenseme.Commn.HttpMethod;
import com.example.redhunter.licenseme.Commn.HttpRequestHandler;
import com.example.redhunter.licenseme.Models.User;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashSet;


/**
 * Created by uer on 1/19/2017.
 */

public class APIClient {

    HttpRequestHandler requestHandler = new HttpRequestHandler();

    public User Authenticate(String useremail, String password) {

        User user = new User(useremail);

        try {
            final String result;
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("email", useremail);
            jsonObject.accumulate("password", password);
            System.out.println("APICLIENT AUTHENTICATION"+" "+useremail+" "+password);
            JSONObject respons = new JSONObject(requestHandler.send(AppConstants.AUTHENICATE_URL, HttpMethod.POST, "", jsonObject));
            JSONObject userDetails = (JSONObject) respons.get("local");
            String userEmail=userDetails.getString("email");
            user.setEmail(userEmail);
            System.out.println("OKKKKKKKK-"+userEmail+""+respons);
            return user;

        } catch (Exception ex) {
            return null;

        }
    }
    public JSONObject GetPersonalDetails(String id) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("id", id);
            System.out.println(jsonObject);
            JSONObject respons = new JSONObject(requestHandler.send(AppConstants.GET_PERSONAL_DETAILS, HttpMethod.GET, "", jsonObject));
            System.out.println("API CLIENT -GetPersonalDetails"+respons);
            return respons;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public JSONObject GetRegistationDetails(String id) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("nic", id);
            System.out.println(jsonObject);
            JSONObject respons = new JSONObject(requestHandler.send(AppConstants.
                                                GET_REGISTATION_DETAILS,
                                                HttpMethod.GET, "", jsonObject));
            System.out.println("API CLIENT -GetRegistation"+respons);
            return respons;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public JSONObject GetLessonListDetails() {
        try {

            JSONObject respons = new JSONObject(requestHandler.send(AppConstants.GET_LESSONLIST_DETAILS, HttpMethod.GET, "", null));
            System.out.println("API CLIENT -GetLessonListDetails"+respons);
            return respons;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




}

