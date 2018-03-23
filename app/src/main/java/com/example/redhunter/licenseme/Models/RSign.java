package com.example.redhunter.licenseme.Models;

import android.graphics.drawable.Drawable;

/**
 * Created by RedHunter on 3/23/2018.
 */

public class RSign {

    private int f_name;
    private String s_des;
    private String f_des;

    public RSign(int f_name, String s_des, String f_des) {
        this.f_name = f_name;
        this.s_des = s_des;
        this.f_des = f_des;
    }

    public int getF_name() {

        return f_name;
    }

    public void setF_name(int f_name) {
        this.f_name = f_name;
    }

    public String getS_des() {
        return s_des;
    }

    public void setS_des(String s_des) {
        this.s_des = s_des;
    }

    public String getF_des() {
        return f_des;
    }

    public void setF_des(String f_des) {
        this.f_des = f_des;
    }


}
