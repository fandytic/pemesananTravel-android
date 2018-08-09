package com.fancik.travelb;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Fandy TIC on 06/01/2018.
 */

public class PilihanTravelB extends AppCompatActivity {

    TextView txt_nohp;
    String nohp,id;
    SharedPreferences sharedpreferences;

    public static final String TAG_ID = "id";
    public static final String TAG_NOHP = "nohp";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilihan_travelb);

        txt_nohp = (TextView) findViewById(R.id.txt_nohp);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        nohp = getIntent().getStringExtra(TAG_NOHP);

        txt_nohp.setText(nohp);
    }

    public void pilihnusa(View view) {
        Intent i = new Intent(getApplicationContext(), TabPadang1.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }

    public void pilihannisa(View view) {
        Intent i = new Intent(getApplicationContext(), TabPadang2.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }

    public void pilihtri(View view) {
        Intent i = new Intent(getApplicationContext(), TabPadang3.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }
}
