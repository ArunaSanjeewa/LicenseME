package com.example.redhunter.licenseme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.redhunter.licenseme.AsyncService.GetPersonalDetails;
import com.example.redhunter.licenseme.AsyncService.IGetResponsePersonalDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PerDetails extends AppCompatActivity implements IGetResponsePersonalDetails{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_per_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);


        String id=null;
        loadPersonalDetails("912082091V");
    }

    final PerDetails pd = this;

    private void loadPersonalDetails(String id) {

        GetPersonalDetails sendPalletData = new GetPersonalDetails(id, pd);

        sendPalletData.execute();

    }


    @Override
    public void personalDetails(JSONObject jsonObject) {
        TextView fname = (TextView) findViewById(R.id.fname);
        TextView sname = (TextView) findViewById(R.id.sname);
        TextView bday = (TextView) findViewById(R.id.bday);
        TextView adds = (TextView) findViewById(R.id.adds);
        TextView gend = (TextView) findViewById(R.id.gend);
        TextView height = (TextView) findViewById(R.id.height);
        TextView weight = (TextView) findViewById(R.id.weight);
        TextView bgroup = (TextView) findViewById(R.id.bgroup);
        TextView mobile = (TextView) findViewById(R.id.mobile);
        try {
            JSONObject ob1 = new JSONObject();
            JSONArray ob2 = new JSONArray();
            ob1=jsonObject.getJSONObject("_embedded");
            ob2=ob1.getJSONArray("personalDetails");
            JSONObject ob3= new JSONObject();
            ob3 =ob2.getJSONObject(0);
            fname.setText(ob3.getString("fullName"));
            sname.setText(ob3.getString("shortName"));
            bday.setText(ob3.getString("birthday"));
            adds.setText(ob3.getString("address"));
            gend.setText(ob3.getString("gender"));
            height.setText(ob3.getString("height"));
            weight.setText(ob3.getString("weight"));
            bgroup.setText(ob3.getString("bloodGroup"));
            mobile.setText(ob3.getString("mobileNumber"));

            System.out.println("RR"+ob2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
