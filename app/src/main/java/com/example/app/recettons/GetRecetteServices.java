package com.example.app.recettons;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class GetRecetteServices extends IntentService {

    private static final String get_recette_services = "com.example.app.recettons.action.GET_RECETTE_SERVICES";
    private static final String TAG = "GetRecetteServices";


    public GetRecetteServices() {
        super("GetRecetteServices");
    }


    // TODO: Customize helper method
    public static void startActionGetRecette(Context context) {
        Intent intent = new Intent(context, GetRecetteServices.class);
        intent.setAction(get_recette_services);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (get_recette_services.equals(action)) {
                handleActionGetRecette();
            }
        }
    }


    private void handleActionGetRecette() {
        Log.i(TAG, "Thread service name : " + Thread.currentThread().getName());
        URL url = null;

        try {
            url = new URL("https://api.edamam.com/search?q="+ Food.getFoodName() + "&app_id=e31a4e3f&app_key=93d6d7c32fe02294f2b3fe2535fa7c23&from=0&to=5");
            Log.i(TAG, "URL : " + url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (HttpsURLConnection.HTTP_OK == conn.getResponseCode()) {
                copyInputStreamToFile(conn.getInputStream(), new File(getCacheDir(), "recettes.json"));
                Log.d(TAG, "Recipe JSON downloaded !");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(RecetteActivity.RECETTES_UPDATE));
    }

    private void copyInputStreamToFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
