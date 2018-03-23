package com.example.redhunter.licenseme;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.redhunter.licenseme.AsyncService.GetLessonListDetails;
import com.example.redhunter.licenseme.AsyncService.IGetLessonList;
import com.example.redhunter.licenseme.Models.Lesson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LessonList extends AppCompatActivity implements IGetLessonList {
    private ArrayAdapter<String> listAdapterbor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        loadLessonListDetails();
    }
    final LessonList pdd = this;

    private void loadLessonListDetails() {

        GetLessonListDetails sendPalletData = new GetLessonListDetails(pdd);

        sendPalletData.execute();

    }

    @Override
    public void lessonListDetails(JSONObject jsonObject) {
        LinkedHashSet<String> borc = new LinkedHashSet<String>();
        String[] array = {};

        //System.out.println("xsaasfasfada");
        //System.out.println("RESULT:RR" + jsonObject);
        final ListView list = (ListView) findViewById(R.id.lessonList);
        ArrayList<String> planetList1 = new ArrayList<String>();
        JSONArray jo = null;
        jo = new JSONArray();
        try {

            JSONObject jo1 = new JSONObject();
           jo1= jsonObject.getJSONObject("_embedded");
            jo = jo1.getJSONArray("lessonsLists");
            System.out.println("jo" + jo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println("jo.length():"+jo.length());
     for(int i=0;i<jo.length();i++){

         try {
             JSONObject joo= new JSONObject();
             Lesson l = new Lesson();

             joo =jo.getJSONObject(i);

             String s = (joo.getString("lessontype")+"-"+joo.getString("leassonEn"));
             //System.out.println("S :"+s);
             planetList1.add(s);


         } catch (JSONException e) {
             e.printStackTrace();
         }

     }




        listAdapterbor = new ArrayAdapter<String>(this, R.layout.scan_keg_layout_list, R.id.barcodetv1, planetList1);

        list.setAdapter(listAdapterbor);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("Click :"+list.getAdapter().getItem(i).toString());
                String s =list.getAdapter().getItem(i).toString();
                Toast.makeText(pdd,s, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
