package com.example.app.recettons;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.app.recettons.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class RecetteActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recette);

        recyclerView = findViewById(R.id.rv_current);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        RecetteAdapter ra = new RecetteAdapter(getRecetteFromFile());

        recyclerView.setAdapter(ra);

        GetRecetteServices.startActionGetRecette(this);
        IntentFilter intentFilter = new IntentFilter(RECETTES_UPDATE);
        LocalBroadcastManager.getInstance(this).registerReceiver(new RecetteUpdate(), intentFilter);

    }

    public static final String RECETTES_UPDATE = "com.example.charles.recettons.action.RECETTES_UPDATE";
    private final String TAG = "RecetteActivity";

    public class RecetteUpdate extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "Intent : " + getIntent().getAction());
            JSONArray array = getRecetteFromFile();
            RecetteAdapter ra = (RecetteAdapter) recyclerView.getAdapter();
            ra.setNewRecette(array);
            Log.d("cont ", Integer.toString(array.length()));
        }
    }

    public JSONArray getRecetteFromFile(){
        try {

            InputStream is = new FileInputStream(getCacheDir() + "/" + "recettes.json");
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new JSONObject(new String(buffer,"UTF-8")).getJSONArray("hits");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new JSONArray();
        } catch (JSONException e) {
            e.printStackTrace();
            return new JSONArray();
        }
    }
}
