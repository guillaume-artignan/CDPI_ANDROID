package com.example.cdpi;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class GetToiletteTask extends AsyncTask<String,Integer, HashMap> {

    public MapsActivity map;

    public GetToiletteTask(MapsActivity map){
        this.map = map;
    }

    @Override
    protected HashMap doInBackground(String... strings) {
        String s = strings[0];

        try {
            URL u = new URL(s);
            URLConnection http = u.openConnection();
            Gson g = new Gson();
            InputStream ins = http.getInputStream();
            InputStreamReader insr = new InputStreamReader(ins);
            return g.fromJson(insr,HashMap.class);

        }catch (IOException e){
            Log.e("ERROR",e.getMessage());
        }

        return null;
    }

    @Override
    protected void onPostExecute(HashMap hashMap) {
        super.onPostExecute(hashMap);
        map.onDataReceived(hashMap);
    }
}
