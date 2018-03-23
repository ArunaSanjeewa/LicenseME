package com.example.redhunter.licenseme;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.redhunter.licenseme.AsyncService.GetPersonalDetails;
import com.example.redhunter.licenseme.AsyncService.GetRegistationDetails;
import com.example.redhunter.licenseme.AsyncService.IGetRegistationDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegistationDetails extends AppCompatActivity implements IGetRegistationDetails{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loadRegistationDetails("912082091V");

    }
    final RegistationDetails pd = this;

    private void loadRegistationDetails(String id) {

        GetRegistationDetails sendPalletData = new GetRegistationDetails(id, pd);

        sendPalletData.execute();

    }

    @Override
    public void registaionDetails(JSONObject jsonObject) {
        System.out.println("RRWWWWWWWWW"+jsonObject);
        TextView fname = (TextView) findViewById(R.id.registrationNumber);
        TextView sname = (TextView) findViewById(R.id.registerDate);
        TextView bday = (TextView) findViewById(R.id.oldDrivingLicenceNumber);
        TextView adds = (TextView) findViewById(R.id.oldLicenceIssuedate);
        TextView gend = (TextView) findViewById(R.id.ntmiNumber);
        TextView height = (TextView) findViewById(R.id.ntmiDate);

        try {


            fname.setText(jsonObject.getString("registrationNumber"));
            sname.setText(jsonObject.getString("registerDate"));
            bday.setText(jsonObject.getString("oldDrivingLicenceNumber"));
            adds.setText(jsonObject.getString("oldLicenceIssuedate"));
            gend.setText(jsonObject.getString("ntmiNumber"));
            height.setText(jsonObject.getString("ntmiDate"));



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
