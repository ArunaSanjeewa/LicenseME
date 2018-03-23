package com.example.redhunter.licenseme;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonReader;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.redhunter.licenseme.Adapters.UsersAdapter;
import com.example.redhunter.licenseme.Models.RSign;
import com.opencsv.CSVReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TSigns extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsigns);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        JSONArray items=null;

        try{
            String template = "{ \"items\":\n" +
                    "[  {\n" +
                    "    \"f_name\":\"DWS-1\",\n" +
                    "    \"s_des\":\"Left Bend Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where there is a sharp bend to the left.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-2\",\n" +
                    "    \"s_des\":\"Right Bend Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where there is a sharp bend to the right.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-3\",\n" +
                    "    \"s_des\":\"Double Bend to Left Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place ahead where two bends on a road are in close proximity to each other; the first being towards the left and the second to the right.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-4\",\n" +
                    "    \"s_des\":\"Double Bend to Right Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place ahead where two bends on a road are in close proximity to each other; the first being towards the right and the second to the left.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-5\",\n" +
                    "    \"s_des\":\"Hair Pin Bend to Right Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where there is a hair-pin bend to the right.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-6\",\n" +
                    "    \"s_des\":\"Hair Pin Bend to Left Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where there is a hair-pin bend to the left.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-7\",\n" +
                    "    \"s_des\":\"Dual Carriage-way Ends\",\n" +
                    "    \"f_des\":\"End of a dual carriageway of a road ahead.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-8\",\n" +
                    "    \"s_des\":\"Dual Carriage-way Starts Ahead\",\n" +
                    "    \"f_des\":\"A place ahead where the dual carriageway of a road starts.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-9\",\n" +
                    "    \"s_des\":\"Road Narrows Ahead\",\n" +
                    "    \"f_des\":\"A place ahead where the road narrows on both sides.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-10\",\n" +
                    "    \"s_des\":\"Road Narrows on the Left Side Ahead\",\n" +
                    "    \"f_des\":\"A place ahead where the road narrows on the left hand side.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-11\",\n" +
                    "    \"s_des\":\"Road Narrows on the Right Side Ahead\",\n" +
                    "    \"f_des\":\"A place ahead where the road narrows on the right hand side\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-12\",\n" +
                    "    \"s_des\":\"Cross Roads Ahead\",\n" +
                    "    \"f_des\":\"A junction ahead of two intersecting roads.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-13\",\n" +
                    "    \"s_des\":\"Staggered Junction Ahead with First Side Road to Left\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a major road with a staggered junction ahead where two side roads intersect the major road close to each other with the first side road towards the left and the second side road to the right.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-14\",\n" +
                    "    \"s_des\":\"Staggered Junction Ahead with First Side Road to Right\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a major road with a staggered junctions ahead where two side roads intersect the major road close to each other with the first side road towards the right and the second side road to the left.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-15\",\n" +
                    "    \"s_des\":\"T Junction Ahead\",\n" +
                    "    \"f_des\":\"A place ahead where one road meets another to form a _T junction.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-16\",\n" +
                    "    \"s_des\":\"Y Junction Ahead\",\n" +
                    "    \"f_des\":\"A Y junction of three roads ahead meeting at a common place.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-17\",\n" +
                    "    \"s_des\":\"Traffic From Left Merges Ahead\",\n" +
                    "    \"f_des\":\"A junction ahead where a side road on the left merges with the major road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-18\",\n" +
                    "    \"s_des\":\"Side Road From Left Intersects at Right Angle Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A junction ahead where a side road on the left intersects the major road at right angles.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-19\",\n" +
                    "    \"s_des\":\"Traffic From Right Merges Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A junction ahead where a side road on the right merges with the major road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-20\",\n" +
                    "    \"s_des\":\"Side Road From Right Intersects at Right Angle Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A junction ahead where a side road on the right intersects the major road at right angles.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-21\",\n" +
                    "    \"s_des\":\"Narrow Bridge or Culvert Ahead\",\n" +
                    "    \"f_des\":\"A place ahead where there is a narrow bridge or culvert\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-22\",\n" +
                    "    \"s_des\":\"Two-way Traffic Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A section of road; ahead temporarily or permanently carrying two-way traffic on the same carriageway.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-23\",\n" +
                    "    \"s_des\":\"Stop Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a minor road ahead where traffic has to stop and give priority to traffic on the major road it intersects or meets according to Regulation 10.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-24\",\n" +
                    "    \"s_des\":\"Give Way Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a road ahead where traffic has to give way to traffic on the major road it intersects or meets before entering the junction according to Regulation 10.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-25\",\n" +
                    "    \"s_des\":\"Roundabout Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place ahead where two or more roads intersect with a circular centre island in the middle and traffic has to move round the centre island in clockwise direction referred to as a roundabout.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-26\",\n" +
                    "    \"s_des\":\"Light Signals Ahead\",\n" +
                    "    \"f_des\":\"An intersection ahead controlled by Traffic Light Signals.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-27\",\n" +
                    "    \"s_des\":\"Dangerous Descent Ahead\",\n" +
                    "    \"f_des\":\"A section of a road ahead where there is a steep downward gradient.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-28\",\n" +
                    "    \"s_des\":\"Dangerous Ascent Ahead\",\n" +
                    "    \"f_des\":\"A section of a road ahead where there is a steep upward gradient.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-29\",\n" +
                    "    \"s_des\":\"Slippery Road Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place or a section of a road ahead which is slippery and liable for skidding.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-30\",\n" +
                    "    \"s_des\":\"Loose Aggregate/ Gravel Ahead\",\n" +
                    "    \"f_des\":\"A road section ahead with loose aggregate / gravel on the carriageway.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-31\",\n" +
                    "    \"s_des\":\"Falling Rocks Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place or a section of a road ahead where there is a risk of rocks falling on to the carriageway or where fallen rocks may lie on the carriageway.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-32\",\n" +
                    "    \"s_des\":\"Pedestrian Crossing Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where pedestrians cross the carriageway\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-33\",\n" +
                    "    \"s_des\":\"Children present/ crossing Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place along a road ahead where a school or playground is located in the vicinity and where children stay on the road or cross frequently.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-34\",\n" +
                    "    \"s_des\":\"Blind people crossing Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place ahead where blind people frequently cross the carriageway; at a Pedestrian Crossing ahead.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-35\",\n" +
                    "    \"s_des\":\"Road Work Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a road ahead where men are working on the carriageway and roadwork is in progress.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-36\",\n" +
                    "    \"s_des\":\"Level Crossing with Gates Ahead\",\n" +
                    "    \"f_des\":\"A railway level crossing protected by gates ahead.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-37\",\n" +
                    "    \"s_des\":\"Unprotected Level Crossing Ahead\",\n" +
                    "    \"f_des\":\"An unprotected railway level crossing ahead.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-38\",\n" +
                    "    \"s_des\":\"Bus Lane Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where a bus lane is reserved for the use of buses.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-39\",\n" +
                    "    \"s_des\":\"Cycle Lane Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a road ahead where a bicycle lane is reserved for the use of bicycles.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-40\",\n" +
                    "    \"s_des\":\"Cyclist crossing Ahead\",\n" +
                    "    \"f_des\":\"A place ahead where cyclists enter or cross the road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-41\",\n" +
                    "    \"s_des\":\"Cattle Crossing Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place ahead where cattle and/ or other animals may cross the road or may be found on the road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-42\",\n" +
                    "    \"s_des\":\"Road Ahead on a Quay\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place ahead where the road is on a quay or a place where a side of the road drops steeply into a river; lake; water-course; waterway or sea.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-43\",\n" +
                    "    \"s_des\":\"Dangerous Side Slopes Ahead\",\n" +
                    "    \"f_des\":\"A narrow road section ahead where the side slopes are dangerously steep.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-44\",\n" +
                    "    \"s_des\":\"Road Hump Ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a road ahead where humps have been formed to reduce vehicle speed.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-45\",\n" +
                    "    \"s_des\":\"Uneven Road Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where the carriageway is dangerously uneven.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-46\",\n" +
                    "    \"s_des\":\"Dip or Causeway Ahead\",\n" +
                    "    \"f_des\":\"A dip ahead on the road or causeway\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-47\",\n" +
                    "    \"s_des\":\"Hump Bridge Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where a hump bridge is located\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-48\",\n" +
                    "    \"s_des\":\"Tunnel Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where a tunnel is located\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-49\",\n" +
                    "    \"s_des\":\"Low flying Air Crafts Ahead\",\n" +
                    "    \"f_des\":\"An area ahead for low flying aircraft\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-50\",\n" +
                    "    \"s_des\":\"Railway Level Crossing Ahead\",\n" +
                    "    \"f_des\":\"A place on a road ahead where there is a railway level crossing\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"DWS-51\",\n" +
                    "    \"s_des\":\"Railway Level Crossing Comprising Two or More Tracks ahead\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A place on a road ahead where there is a railway level crossing comprising two or more tracks\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-1\",\n" +
                    "    \"s_des\":\"Distance to a Hazardous section of a road\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the distance from the sign to the beginning of a dangerous section of a road\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-2\",\n" +
                    "    \"s_des\":\"Length of a Hazardous section of a road\",\n" +
                    "    \"f_des\":\"A panel used to indicate the length of a hazardous section of a road\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-3\",\n" +
                    "    \"s_des\":\"Direction to a Hazard on an Intersecting Road\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the direction to a hazard on an intersecting road where the distance from the intersection to the hazard is short\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-4\",\n" +
                    "    \"s_des\":\"School (supplementing a Warning Sign) to be affixed to Sign DWS-33\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel fixed to the Danger Warning Sign DWS-33; children crossing ahead; when the warning applies to a road section at a school\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-1\",\n" +
                    "    \"s_des\":\"No Entry\",\n" +
                    "    \"f_des\":\"No entry for vehicular traffic to enter a particular road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-2\",\n" +
                    "    \"s_des\":\"No Left Turn\",\n" +
                    "    \"f_des\":\"No left turn for vehicular traffic at an intersection.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-3\",\n" +
                    "    \"s_des\":\"No Right Turn\",\n" +
                    "    \"f_des\":\"No right turn for vehicular traffic at an intersection.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-4\",\n" +
                    "    \"s_des\":\"No U-turn\",\n" +
                    "    \"f_des\":\"U turns prohibited for vehicular traffic.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-5\",\n" +
                    "    \"s_des\":\"No Overtaking\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Overtaking of power driven vehicles other than two-wheeled mopeds and two wheeled motor cycles without sidecar is prohibited.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-6\",\n" +
                    "    \"s_des\":\"End of No Overtaking\",\n" +
                    "    \"f_des\":\"End of prohibition of overtaking conveyed by Sign PHS-5\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-7\",\n" +
                    "    \"s_des\":\"Overtaking by Goods Vehicles Prohibited\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Overtaking of power driven vehicles other than two-wheeled mopeds and two wheeled motor cycles without sidecar by goods vehicles exceeding 3.5 tons is prohibited.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-8\",\n" +
                    "    \"s_des\":\"End of Overtaking by Goods Vehicles\",\n" +
                    "    \"f_des\":\"End of prohibition of overtaking conveyed by Sign PHS-7.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-9\",\n" +
                    "    \"s_des\":\"No Horning\",\n" +
                    "    \"f_des\":\"Sound signals are prohibited at a location or section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-10\",\n" +
                    "    \"s_des\":\"Road Closed for all vehicles\",\n" +
                    "    \"f_des\":\n" +
                    "    \"All vehicles are prohibited from entering a particular road or section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-11\",\n" +
                    "    \"s_des\":\"Road closed for Motor vehicles\",\n" +
                    "    \"f_des\":\"Motor vehicles are prohibited from entering a road or a section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-12\",\n" +
                    "    \"s_des\":\"Road Closed for Buses\",\n" +
                    "    \"f_des\":\"Buses are prohibited from entering a particular road or section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-13\",\n" +
                    "    \"s_des\":\"Road Closed for Lorries\",\n" +
                    "    \"f_des\":\"Lorries are prohibited from entering a particular road or section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-14\",\n" +
                    "    \"s_des\":\"Road closed for Articulated vehicles\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Articulated vehicles are prohibited from entering a road or a section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-15\",\n" +
                    "    \"s_des\":\"Road Closed for Power Driven Agricultural Vehicles\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Power driven agricultural vehicles are prohibited from entering a road or a section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-16\",\n" +
                    "    \"s_des\":\"Road closed for Hand Tractors\",\n" +
                    "    \"f_des\":\"Hand tractors are prohibited from entering a road or a section of a road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-17\",\n" +
                    "    \"s_des\":\"Road Closed for Three-Wheelers\",\n" +
                    "    \"f_des\":\"Three wheelers are prohibited from entering a road or a section of a road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-18\",\n" +
                    "    \"s_des\":\"Road Closed for Motorcycles\",\n" +
                    "    \"f_des\":\"Motor cycles are prohibited from entering a road or a section of a road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-19\",\n" +
                    "    \"s_des\":\"Road Closed for Cycles\",\n" +
                    "    \"f_des\":\"Cyclists are prohibited from entering a road or a section of a road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-20\",\n" +
                    "    \"s_des\":\"Road Closed for Animal-drawn Vehicles\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Animal drawn vehicles are prohibited from entering a road or a section of a road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-21\",\n" +
                    "    \"s_des\":\"Road Closed for Hand carts\",\n" +
                    "    \"f_des\":\"Hand carts are prohibited from entering a road or a section of a road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-22\",\n" +
                    "    \"s_des\":\"Road Closed for Pedestrians\",\n" +
                    "    \"f_des\":\"Pedestrians are prohibited from entering a road or a section of a road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-23\",\n" +
                    "    \"s_des\":\"No Parking\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Parking of vehicles is prohibited on the side of the road where the sign is situated.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-24\",\n" +
                    "    \"s_des\":\"No Parking and Standing\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Parking and standing of vehicles is prohibited on the side of the road where the sign is situated.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-25\",\n" +
                    "    \"s_des\":\"No Parking on Odd days\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Parking of vehicles is prohibited on odd days of the month(1; 3; 5; 7; 9; 11; 13; 15; 17; 19; 21; 23; 25; 27; 29; 31 of the month) on the side of road where the sign is situated.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PHS-26\",\n" +
                    "    \"s_des\":\"No Parking on Even days\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Parking of vehicles is prohibited on even days of the month (2; 4; 6; 8; 10; 12; 14; 16; 18; 20; 22; 24; 26; 28; 30 of the month) on the side of road where the sign is situated.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-1\",\n" +
                    "    \"s_des\":\"Width Limit\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicles or Vehicles and load; of overall width exceeding width indicated are prohibited.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-2\",\n" +
                    "    \"s_des\":\"Height Limit\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicles; or Vehicles and load; of overall height exceeding height indicated are prohibited.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-3\",\n" +
                    "    \"s_des\":\"Weight Limit\",\n" +
                    "    \"f_des\":\"Vehicles; or Vehicles and load; exceeding weight indicated are prohibited.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-4\",\n" +
                    "    \"s_des\":\"Weight Limit on One Axle\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicles; or Vehicles and load; exceeding axle weight indicated are prohibited.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-5\",\n" +
                    "    \"s_des\":\"vehicles within built-up areas except for 3 wheelers and land vehicles\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicle categories - Motor cars; dual purpose vehicles; motor cycles; Motor coaches and motor lorries are prohibited from travelling at speed limit indicated; applicable for built up areas or hilly terrain except for 3 wheelers and tractors.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-6\",\n" +
                    "    \"s_des\":\"Speed Limit for light vehicles outside built-up areas\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicle categories - Motor cars; dual purpose vehicles and motor cycles are prohibited from travelling at speed limit indicated; applicable for non-built up areas.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-7\",\n" +
                    "    \"s_des\":\"Speed Limit for heavy vehicles in non built-up areas\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicle categories - Motor coaches and motor lorries are prohibited from travelling at speed exceeding speed limit indicated; applicable for non- built up areas.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-8\",\n" +
                    "    \"s_des\":\n" +
                    "    \"Speed Limit for 3 wheelers and land vehicles in built-up and non built-up areas\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicle categories - Motor tricycle vans; motor tricycles; land vehicles and steam driven motor vehicles are prohibited from travelling at speed exceeding speed limit indicated; applicable for built up and non- built up areas.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-9\",\n" +
                    "    \"s_des\":\n" +
                    "    \"Speed Limit for all vehicles within school areas and hospitals or any other specificed location\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicles prohibited from travelling at speed exceeding speed limit indicated; applicable for locations where there are schools; hospitals or any other specified places for all categories of vehicles. The figure indicated shall be applicable.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"RSS-10\",\n" +
                    "    \"s_des\":\"End of Speed Limit\",\n" +
                    "    \"f_des\":\n" +
                    "    \"End of prohibition of speed limit conveyed by Sign PHS-5. The numerals indicated in the sign may be changed depending on the specified speed limit\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-1\",\n" +
                    "    \"s_des\":\"Turn Left\",\n" +
                    "    \"f_des\":\"Vehicular traffic must turn left at an intersection.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-2\",\n" +
                    "    \"s_des\":\"Turn Right\",\n" +
                    "    \"f_des\":\"Vehicular traffic must turn right at an intersection.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-3\",\n" +
                    "    \"s_des\":\"Straight Ahead\",\n" +
                    "    \"f_des\":\"Vehicular traffic must proceed straight ahead at an intersection.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-4\",\n" +
                    "    \"s_des\":\"Turn Left Ahead\",\n" +
                    "    \"f_des\":\"Vehicular traffic must turn left ahead at an intersection.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-5\",\n" +
                    "    \"s_des\":\"Turn Right Ahead\",\n" +
                    "    \"f_des\":\"Vehicular traffic must turn right ahead at an intersection.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-6\",\n" +
                    "    \"s_des\":\"Pass Left Side\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicular traffic passing the sign must keep to the left of the sign indicated by the arrow on the sign.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-7\",\n" +
                    "    \"s_des\":\"Pass Right Side\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicular traffic passing the sign must keep to the right of the sign as indicated by the arrow on the sign.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-8\",\n" +
                    "    \"s_des\":\"Pass either side\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicular traffic passing the sign may keep to the left or to the right of the sign as indicated by the arrows.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"MNS-9\",\n" +
                    "    \"s_des\":\"Compulsory Roundabout\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Vehicles entering the intersection must give priority to vehicles from the right at the transverse Road Marking RM-2 of Schedule 5 placed on the carriageway or if the Road Marking is not visible; at the road intersection; and proceed beyond in conformity with the direction indicated by arrows; in a clockwise sense at the roundabout.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PRS-1\",\n" +
                    "    \"s_des\":\"Stop to give priority to vehicles on the adjacent road\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Notification to drivers on a road that they must stop and give priority to vehicles on the adjacent road which the road intersects; in accordance with the requirements specified in paragraph (1) of Regulation 10.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PRS-2\",\n" +
                    "    \"s_des\":\"Give Way to vehicles on the adjacent road\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Notification to drivers on a road that they must give way to vehicles on the adjacent road; which they enter; in accordance with the requirements specified in paragraph (2) of Regulation 10.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PRS-3\",\n" +
                    "    \"s_des\":\"Priority Road to vehicles on the major road\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Notification to drivers of vehicles on a major road which intersects a minor road that drivers of vehicles on the minor road entering the major road at the intersection are required to give priority to vehicles on the major road in conformity with paragraph (1) or paragraph (2) of Regulation 10.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PRS-4\",\n" +
                    "    \"s_des\":\"End of Priority given to vehicles on the major road\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Notification to drivers of vehicles on a major road that priority given to drivers on the major road as notified by Sign PRS-3 ends.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PRS-5\",\n" +
                    "    \"s_des\":\"Priority for the Oncoming Traffic\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Notification to drivers of vehicles approaching a narrow section of a road that they shall give priority to on coming vehicles over the narrow section of the road\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"PRS-6\",\n" +
                    "    \"s_des\":\"Priority over Oncoming Traffic Vehicles\",\n" +
                    "    \"f_des\":\n" +
                    "    \"Notification to drivers of vehicles approaching a narrow section of a road that drivers of vehicles moving in opposite direction are required to give priority to oncoming vehicles over the narrow section of road.\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-1\",\n" +
                    "    \"s_des\":\"Distance to a Regulation\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the distance from the sign to the beginning of a Regulation\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-2\",\n" +
                    "    \"s_des\":\"Length of a Regulation sign\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the length of a Regulation indicated by a Regulatory Sign\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-3\",\n" +
                    "    \"s_des\":\"Start of Regulation for Parking and Standing Prohibition\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the start of Regulation for the parking or the parking and standing prohibition\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-4\",\n" +
                    "    \"s_des\":\"Direction of Regulation for Parking and Standing Prohibition\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the continuation of Regulation for the parking or the parking and standing\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-5\",\n" +
                    "    \"s_des\":\"End of Regulation for Parking and Standing Prohibition\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the end of Regulation for the parking or the parking and standing\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-6\",\n" +
                    "    \"s_des\":\n" +
                    "    \"Time Limitation of Parking Prohibition or Parking and Standing Prohibition and direction of the prohibition\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel used to indicate the time during which a Parking prohibition or Parking and Standing prohibition applies and the direction or directions of the prohibition\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-7\",\n" +
                    "    \"s_des\":\"Exemption from Regulation to be affixed to Sign RSS-9\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel fixed to a Prohibitory Sign to indicate exemption from the prohibition. The text on the panel may vary depending on the exemption\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-8\",\n" +
                    "    \"s_des\":\n" +
                    "    \"School or any other specified places (supplementing a Regulatory Sign) - To be affixed to Sign RSS-9\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel fixed to a Regulatory Sign RSS-9 to indicate a Regulation on a road section at a school or any other specified place such as Speed Limit or No Horning\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-9\",\n" +
                    "    \"s_des\":\"To be affixed to Speed Limit Sign RSS-5\",\n" +
                    "    \"f_des\":\"A panel fixed to the Sign RSS-5 to indicate the categories of vehicles\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-10\",\n" +
                    "    \"s_des\":\"To be affixed to Speed Limit Sign RSS-6\",\n" +
                    "    \"f_des\":\"A panel fixed to the Sign RSS-6 to indicate the categories of vehicles\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-11\",\n" +
                    "    \"s_des\":\"To be affixed to Speed Limit Sign RSS-7\",\n" +
                    "    \"f_des\":\"A panel fixed to the Sign RSS-7 to indicate the categories of vehicles\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-12\",\n" +
                    "    \"s_des\":\"To be affixed to Speed Limit Sign RSS-8\",\n" +
                    "    \"f_des\":\"A panel fixed to the Sign RSS-8 to indicate the categories of vehicles\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-13\",\n" +
                    "    \"s_des\":\"To be affixed in between Speed Limit Sign RSS-5 and APR09\",\n" +
                    "    \"f_des\":\"A panel fixed in between Speed Limit Sign RSS-5 and APR09\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"f_name\":\"APD-14\",\n" +
                    "    \"s_des\":\n" +
                    "    \"To be affixed to Signs PHS-1; PHS-2 or PHS-3 at the Entry to an Expressway\",\n" +
                    "    \"f_des\":\n" +
                    "    \"A panel fixed to the Sign PHS-1; PHS-2 or PHS-3 at the entry to an Expressway\"\n" +
                    "  }\n" +
                    "]}";

            JSONObject jsonWithArrayInIt = new JSONObject(template); //JSONObject created for the template.
             items = jsonWithArrayInIt.getJSONArray("items"); //JSONArray of Items got from the JSONObject.

            System.out.println(items.toString());

        }catch(JSONException je){
            //Error while creating JSON.
        }
        // Construct the data source
        ArrayList<RSign> arrayOfUsers = new ArrayList<RSign>();
// Create the adapter to convert the array to views


        UsersAdapter adapter = new UsersAdapter(this, arrayOfUsers);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.rsign_list);
        listView.setAdapter(adapter);
        // Add item to adapter
        //ImageView imageNameToId  = (ImageView) findViewById(R.id.f_name);


        for (int i = 0; i < items.length(); i++) {
            try {
                JSONObject j = (JSONObject) items.get(i);
                //System.out.println("SSSSSSS:"+j);
                String str =j.getString("f_name");
                str = str.replace("-", "");
                str = str.toLowerCase();
                System.out.println(str);
                int imageId = getResourseId(this, str, "drawable", getPackageName());



                RSign newR = new RSign(imageId,j.getString("s_des"), j.getString("f_des"));
                arrayOfUsers.add(newR);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
       // adapter.addAll(arrayOfUsers);

    }

// Or even append an entire new collection
// Fetching some data, data has now returned
// If data was JSON, convert to ArrayList of User objects.

    public static int getResourseId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }


    }


