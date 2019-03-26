package com.example.app.recettons;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.recettons.R;


public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText mdp;
    private Button connecter;
    private Button enregistrer;

    private Controleur controleur = new Controleur();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.loginEmail);
        //email = sc.nextLine();

        mdp = (EditText) findViewById(R.id.loginMdp);
        enregistrer = (Button) findViewById(R.id.enregistrer);
        connecter = (Button) findViewById(R.id.connecter);




        connecter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                for(  Utilisateur i  : controleur.getListeUtilisateur()){
                    if(email.getText().toString().equals(i.getEmail()) && mdp.getText().toString().equals(i.getMdp())){
                        controleur.setUtilisateurCourant(i);


                        NotificationCompat.Builder mBuilder =
                                new NotificationCompat.Builder(MainActivity.this)
                                        .setSmallIcon(R.drawable.notification)
                                        .setContentTitle(getResources().getString(R.string.notification_title))
                                        .setContentText(getResources().getString(R.string.notification_desc))
                                        .setVibrate(new long[] { 200, 1000, 1000, 1000, 200 });
                        // .setSound(R.raw.alarm);

                        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                        mNotificationManager.notify(001, mBuilder.build());


                        ouvrirPageHome();
                    }



                    else{
                        creerUnToast("Login ou mot de passe incorrect !");

                    }
                }

            }});

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ouvrirPageEnregistrer();
            }
        });

    }


    public void ouvrirPageEnregistrer(){
        Intent pageEnregistrer = new Intent(MainActivity.this, Enregistrer.class);
        startActivity(pageEnregistrer);
    }

    public void ouvrirPageHome(){
        Intent pageHome = new Intent(MainActivity.this, Home.class);
        startActivity(pageHome);
    }

    public void creerUnToast(CharSequence erreur){
        Context appContext = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;

        Toast messageErreur = Toast.makeText(appContext, erreur, duree);
        messageErreur.show();
    }

}
