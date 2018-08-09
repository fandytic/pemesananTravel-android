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

public class PilihanTravelC extends AppCompatActivity {
    TextView txt_nohp;
    String nohp,id;
    SharedPreferences sharedpreferences;
    public static final String TAG_ID = "id";
    public static final String TAG_NOHP = "nohp";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pilihan_travelc);

        txt_nohp = (TextView) findViewById(R.id.txt_nohp);

        sharedpreferences = getSharedPreferences(MainActivity.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        nohp = getIntent().getStringExtra(TAG_NOHP);

        txt_nohp.setText(nohp);
    }

    public void pilihbintang(View view) {
        Intent i = new Intent(getApplicationContext(), TabPadangPanjang1.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }

    public void pilihpermata(View view) {
        Intent i = new Intent(getApplicationContext(), TabPadangPanjang2.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_NOHP, nohp);
        startActivity(i);
    }
}
