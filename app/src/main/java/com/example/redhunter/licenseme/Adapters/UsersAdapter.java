package com.example.redhunter.licenseme.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.redhunter.licenseme.Models.RSign;
import com.example.redhunter.licenseme.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by RedHunter on 3/23/2018.
 */

public class UsersAdapter extends ArrayAdapter<RSign> {

    public UsersAdapter(Context context, ArrayList<RSign> users) {
        super(context, 0, users);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        RSign rsign = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.rsign, parent, false);
        }
        // Lookup view for data population

        TextView s_des = (TextView) convertView.findViewById(R.id.s_des);
        TextView f_des = (TextView) convertView.findViewById(R.id.f_des);






        // Populate the data into the template view using the data object

        ImageView f_name = (ImageView) convertView.findViewById(R.id.f_name);



        f_name.setImageResource(rsign.getF_name());

        s_des.setText(rsign.getS_des());
        f_des.setText(rsign.getF_des());
        // Return the completed view to render on screen
        return convertView;
    }
}