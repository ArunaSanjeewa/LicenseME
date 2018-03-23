package com.example.redhunter.licenseme.AppConstant;
import java.util.ArrayList;


/**
 * Created by RedHunter on 1/10/2018.
 */

public class AppConstants {
    private static String BASE_URL = "http://learnersmanagementsystem.herokuapp.com/api";
    public static String AUTHENICATE_URL = BASE_URL + "/android-login";
    public static String GET_PERSONAL_DETAILS = BASE_URL + "/personalDetails";
    public static String GET_LESSONLIST_DETAILS = BASE_URL + "/lessonsLists";
    public static String GET_REGISTATION_DETAILS = BASE_URL + "/registrationDetails/search/findOneByPdetailsNic?";
}
