package com.example.app.recettons;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.recettons.R;

public class Home extends AppCompatActivity {

    private TextView bienvenue;
    private TextView aide;
    private Controleur controleur = new Controleur();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bienvenue = (TextView) findViewById(R.id.texteBienvenue);
        bienvenue.setText( "Welcome " +controleur.getUtilisateurCourant().recupererPrenom()+"!");
        bienvenue.setVisibility(View.VISIBLE);

        aide = (TextView) findViewById(R.id.aide);
        aide.setText(R.string.aide);
        aide.setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_search :
                AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
                builder.setMessage(R.string.search_desc);
                builder.setTitle(R.string.search_title);
                final EditText input = new EditText(Home.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);

                builder.setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Food.setFoodName(input.getText().toString());
                        Toast.makeText(getApplicationContext(), Food.getFoodName(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(Home.this, RecetteActivity.class);
                        startActivity(i);
                    }
                });

                builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
