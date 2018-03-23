package com.example.redhunter.licenseme.AsyncService;

import android.os.AsyncTask;

import com.example.redhunter.licenseme.Data.APIClient;
import com.example.redhunter.licenseme.RegistationDetails;

import org.json.JSONObject;

/**
 * Created by RedHunter on 3/23/2018.
 */

public class GetRegistationDetails extends AsyncTask<JSONObject, Void, JSONObject> {

    APIClient client = new APIClient();
    IGetRegistationDetails response;

    String id;

     public GetRegistationDetails(String id, IGetRegistationDetails pd) {
        this.id=id;
        this.response=pd;
    }


    @Override
    protected JSONObject doInBackground(JSONObject... params) {

        JSONObject result=client.GetRegistationDetails(id);
        System.out.println("Doin Back"+result);

        return result;
    }

    @Override
    protected void onPostExecute(JSONObject obj) {
        super.onPostExecute(obj);
        response.registaionDetails(obj);




    }
}
