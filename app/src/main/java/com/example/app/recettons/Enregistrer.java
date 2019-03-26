package com.example.app.recettons;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app.recettons.R;

public class Enregistrer extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText age;
    private EditText email;
    private EditText mdp;
    private EditText mdpConfirmer;
    private Button enregistrer;

    private Controleur controleur = new Controleur();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrer);

        enregistrer = (Button) findViewById(R.id.enregistrer);

        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        age = (EditText) findViewById(R.id.age);
        email = (EditText) findViewById(R.id.emailLand);
        mdp = (EditText) findViewById(R.id.mdp);
        mdpConfirmer = (EditText) findViewById(R.id.mdpConfirmer);

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(enregistrer())
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Enregistrer.this);
                    builder.setMessage(R.string.robot);
                    builder.setTitle(R.string.robot_title);
                    builder.setPositiveButton(R.string.robot_non, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            controleur.creerEtudiant(nom.getText().toString(),
                              prenom.getText().toString(),
                              Integer.parseInt(age.getText().toString()),
                              email.getText().toString(),
                              mdp.getText().toString()
                            );
                            ouvrirPageLogin();
                        }

                    });
                    builder.setNegativeButton(R.string.robot_oui, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                   AlertDialog dialog = builder.create();
                   dialog.show();


                }

                else{

                    creerUnToast("Incomplete fields or incorrect password");
                }


            }
        });
    }

    public boolean enregistrer(){


        if(!nom.getText().toString().equals("") &&
                !prenom.getText().toString().equals("") &&
                !age.getText().toString().equals("") &&
                !email.getText().toString().equals("") &&
                !mdp.getText().toString().equals("") &&
                !mdpConfirmer.getText().toString().equals("") &&

                mdp.getText().toString().equals(mdpConfirmer.getText().toString())){


            return true;


        }
        else{

            return false;
        }

    }


    public void ouvrirPageLogin(){

        Intent pageLogin = new Intent(Enregistrer.this, MainActivity.class);
        startActivity(pageLogin);

    }

    public void creerUnToast(CharSequence erreur){

        Context appContext = getApplicationContext();
        int duree = Toast.LENGTH_SHORT;

        Toast messageErreur = Toast.makeText(appContext, erreur, duree);
        messageErreur.show();

    }




}
