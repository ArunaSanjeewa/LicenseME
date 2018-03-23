package com.example.redhunter.licenseme.AsyncService;

import android.os.AsyncTask;

import com.example.redhunter.licenseme.Data.APIClient;

import org.json.JSONObject;

/**
 * Created by RedHunter on 3/20/2018.
 */

public class GetLessonListDetails extends AsyncTask<JSONObject, Void, JSONObject> {

    APIClient client = new APIClient();
    IGetLessonList response;

    String id;

    public GetLessonListDetails(IGetLessonList response){
        this.id=id;
        this.response=response;

    }


    @Override
    protected JSONObject doInBackground(JSONObject... params) {
        System.out.println("LessonList doInBackground******");
        JSONObject result=client.GetLessonListDetails();

        return result;
    }

    @Override
    protected void onPostExecute(JSONObject obj) {
        super.onPostExecute(obj);
        response.lessonListDetails(obj);




    }
}
