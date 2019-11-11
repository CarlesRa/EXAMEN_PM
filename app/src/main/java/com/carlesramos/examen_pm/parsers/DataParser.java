package com.carlesramos.examen_pm.parsers;

import android.content.Context;

import com.carlesramos.examen_pm.R;
import com.carlesramos.examen_pm.model.Star;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DataParser {
    //crear array del model
    private ArrayList <Star> stars;
    private InputStream dataFile;

    public DataParser(Context c) {

        //obtenim una referencia al arxiu
        dataFile = c.getResources().openRawResource(R.raw.stars);

    }

    public boolean parse(){
        boolean parsed = false;
        String json = null;
        stars = null;

        try {
            int size = dataFile.available();
            byte[] buffer = new byte[size];
            dataFile.read(buffer);
            dataFile.close();
            json = new String(buffer,"UTF-8");

            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            stars = new ArrayList<>();

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //plenem les dades segons el model
                int id = jsonObject.getInt("id");
                int hip = jsonObject.getInt("hip");
                String bf = jsonObject.getString("bf");
                String proper = jsonObject.getString("proper");
                double re = jsonObject.getDouble("ra");
                double dec = jsonObject.getDouble("dec");
                double dist = jsonObject.getDouble("dist");
                double mag = jsonObject.getDouble("mag");
                String spect = jsonObject.getString("spect");
                //creem un nou objecte i l'anyadim al array
                stars.add(new Star(id,hip,bf,proper,re,dec,dist,mag,spect));
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public ArrayList<Star> getStars() {
        Collections.sort(stars);
        return stars;
    }
}
