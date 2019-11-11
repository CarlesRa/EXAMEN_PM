package com.carlesramos.examen_pm.parsers;

import android.content.Context;
import com.carlesramos.examen_pm.model.ModelClass;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.IOException;
import java.io.InputStream;

public class DataParser {
    //crear array del model
    private ModelClass[] modelClasses;
    private InputStream dataFile;

    public DataParser(Context c) {
        /*
            obtenim una referencia al arxiu
            dataFile = c.getResources().openRawResource(R.raw.[nom del arxiu])
         */
    }

    public boolean parse(){
        boolean parsed = false;
        String json = null;
        //falta inicialitzar a null el array del model
        modelClasses = null;

        try {
            int size = dataFile.available();
            byte[] buffer = new byte[size];
            dataFile.read(buffer);
            dataFile.close();
            json = new String(buffer,"UTF-8");

            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            modelClasses = new ModelClass[jsonArray.length()];

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                //plenem les dades segons el model

                //creem un nou objecte i l'anyadim al array
            }
            parsed = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public ModelClass[] getModelClasses() {
        return modelClasses;
    }
}
