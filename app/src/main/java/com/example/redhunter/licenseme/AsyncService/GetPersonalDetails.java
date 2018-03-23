package com.example.redhunter.licenseme.AsyncService;

import android.os.AsyncTask;

import com.example.redhunter.licenseme.Data.APIClient;
import com.example.redhunter.licenseme.PerDetails;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by RedHunter on 3/16/2018.
 */

public class GetPersonalDetails extends AsyncTask<JSONObject, Void, JSONObject> {

    APIClient client = new APIClient();
    IGetResponsePersonalDetails response;

    String id;

    public GetPersonalDetails(String id,IGetResponsePersonalDetails response){

        this.id=id;
        this.response=response;

    }


    @Override
    protected JSONObject doInBackground(JSONObject... params) {
        System.out.println("Exist pallet doInBackground******");
        JSONObject result=client.GetPersonalDetails(id);

        return result;
    }

    @Override
    protected void onPostExecute(JSONObject obj) {
        super.onPostExecute(obj);
        response.personalDetails(obj);




    }
}
